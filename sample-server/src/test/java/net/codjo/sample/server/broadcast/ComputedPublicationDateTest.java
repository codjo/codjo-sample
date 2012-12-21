package net.codjo.sample.server.broadcast;
import java.sql.SQLException;
import net.codjo.broadcast.common.computed.ComputedFieldTestCase;
import net.codjo.broadcast.server.api.SqlUtil;
import net.codjo.database.common.api.structure.SqlTable;
/**
 *
 */
public class ComputedPublicationDateTest extends ComputedFieldTestCase<ComputedPublicationDate, BookPreferences> {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context.putParameter("dbApplicationUser", tokio.getConnection().getMetaData().getUserName());
    }


    /**
     * TODO[Segolene]P1 rendre multibase probleme du number ET de la contrainte
     * Dommage de ne pas recuperer la méthode de creation de table de ComputedFieldGenerator (mais package protected)
     */
    protected void createComputedTable() {
        String computedTableName = context.replaceVariables(preferences.getComputedTableName());
        tokio.getJdbcFixture().create(SqlTable.temporaryTable(computedTableName),
                                      "SELECTION_ID number(18) not null, "
                                      + computedField.getSqlDefinition() + " null ,"
                                      + "constraint PK_TMP_COMPUTED primary key (SELECTION_ID)"
        );
    }


    @Override
    protected ComputedPublicationDate createComputedField() {
        return new ComputedPublicationDate();
    }


    @Override
    protected BookPreferences createPreferences() {
        return new BookPreferences();
    }


    @Override
    protected void createSelectionTable() throws SQLException {
        final String selectionTableName = context.replaceVariables(preferences.getSelectionTableName());
        //TODO[Segolene] ca serait pas mal d'utiliser createSelectionTable de BookSelector mais ca a l'air de poser des
        //probleme : ORA-02264: nom déjà utilisé par une contrainte existante (test ci-dessous)
        // new BookSelector(0).createSelectionTable(tokio.getConnection(),selectionTableName);
        SqlUtil.dropTable(tokio.getConnection(), selectionTableName);
        tokio.getJdbcFixture()
              .create(SqlTable.temporaryTable(selectionTableName), "   SELECTION_ID              number(18) null,"
                                                                   + " TITLE      varchar2(255)  not null,"
                                                                   + " AUTHOR      varchar2(150)  not null,"
                                                                   + "constraint PK_TMP_SELECT primary key (SELECTION_ID)");
    }


    public void test_nominal() throws Exception {
        assertCase("nominal");
    }
}
