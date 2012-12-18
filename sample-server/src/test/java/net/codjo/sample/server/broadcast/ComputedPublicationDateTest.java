package net.codjo.sample.server.broadcast;
import java.sql.Connection;
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
        String userName = tokio.getConnection().getMetaData().getUserName();
        context.putParameter("dbApplicationUser", userName);
    }


    /**
     * TODO a remonter dans ComputedFieldTestCase
     * @param storyName
     * @throws SQLException
     */
    @Override
    protected void assertCase(String storyName) throws SQLException {
        final Connection connection = tokio.getConnection();
        TransactionManager transactionManager = new TransactionManager(connection);
        try {
            createSelectionTable();
            createComputedTable();

            tokio.insertInputInDb(storyName);

            computedField.compute(computedContext, tokio.getConnection());

            tokio.assertAllOutputs(storyName);
        }
        catch (Exception ex) {
            transactionManager.rollback(connection);
            throw new SQLException(ex);
        }
        finally {
            transactionManager.release(connection);
        }
    }


    /**
     * TODO rendre multibase et remonter dans ComputedFieldTestCase
     * NB : dommage de ne pas recuperer la méthode de creation de table de ComputedFieldGenerator
     */
    private void createComputedTable() {
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


    /**
     * TODO remarque : ca serait pas mal d'utiliser createSelectionTable de BookSelector
     * @throws SQLException
     */
    @Override
    protected void createSelectionTable() throws SQLException {
        final String selectionTableName = context.replaceVariables(preferences.getSelectionTableName());
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
