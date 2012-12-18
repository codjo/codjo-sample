package net.codjo.sample.server.broadcast;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import net.codjo.broadcast.common.Context;
import net.codjo.broadcast.server.selector.AbstractGenericSelector;
/**
*
*/
public class BookSelector extends AbstractGenericSelector {
    private static final String BASE_INSERT_QUERY = "insert into $selectionTable$ (SELECTION_ID, TITLE, AUTHOR) ";


    public BookSelector(int selectorId) {
        super(selectorId);
    }


    @Override
    protected void executeStaticSelector(Context context,
                                         Connection connection,
                                         String selectionTableName,
                                         Date broadcastDate,
                                         int selectorId) throws SQLException {
        createSelectionTable(connection, context.replaceVariables(selectionTableName));
        String selectorQuery = BASE_INSERT_QUERY
                               + " select SEQ_BROADCAST_SELECTION.nextval ,TITLE, AUTHOR from AP_BOOK";
        executeQueryWithVariables(context, connection, selectorQuery);
    }


    @Override
    protected void executeGenericSelector(Context context,
                                          Connection connection,
                                          String selectionTableName,
                                          Date broadcastDate,
                                          int selectorId) throws SQLException {
        createSelectionTable(connection, context.replaceVariables(selectionTableName));
        String selectorQuery = BASE_INSERT_QUERY + getSelectorQuery(connection, selectorId);
        executeQueryWithVariables(context, connection, selectorQuery);
    }


    protected void createSelectionTable(Connection connection, String tableName) throws SQLException {
        // TODO[Oracle Support] re-init de la sequence??
        createTempTable(connection, tableName,
                        " SELECTION_ID         numeric(18)   , "
                        + " TITLE      varchar(255)  not null,"
                        + " AUTHOR      varchar(150)  not null "
                        + ", constraint PK_SELEC_BOOK primary key (SELECTION_ID)");
    }
}
