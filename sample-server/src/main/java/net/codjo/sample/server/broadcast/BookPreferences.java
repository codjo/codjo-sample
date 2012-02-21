package net.codjo.sample.server.broadcast;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import net.codjo.broadcast.common.Context;
import net.codjo.broadcast.common.PostBroadcaster;
import net.codjo.broadcast.common.Preferences;
import net.codjo.broadcast.common.Selector;
import net.codjo.broadcast.common.computed.ComputedField;
import net.codjo.broadcast.server.selector.AbstractGenericSelector;
/**
 *
 */
public class BookPreferences extends Preferences {
    public static final String FAMILY = "BOOK";


    public BookPreferences() {
        super(FAMILY, "AP_BOOK", "#ALL_BOOK_SEL", "#COMPUTED_TAB");
    }


    @Override
    public PostBroadcaster buildPostBroadcaster(Connection con, BigDecimal fileId,
                                                BigDecimal contentId, BigDecimal sectionId) {
        return null;
    }


    @Override
    protected ComputedField[] initComputedFields() {
        return new ComputedField[0];  // Todo
    }


    @Override
    protected void initJoinKeys() {
        // Todo
    }


    @Override
    public Selector buildSelector(Connection con, BigDecimal contentID,
                                  BigDecimal sectionID, BigDecimal selectionID)
          throws SQLException {
        return new BookSelector(selectionID.intValue());
    }


    public static class BookSelector extends AbstractGenericSelector {
        private static final String BASE_INSERT_QUERY = "insert into $selectionTable$ (TITLE, AUTHOR, BROADCAST_DATE)";


        public BookSelector(int selectorId) {
            super(selectorId);
        }


        @Override
        protected void executeStaticSelector(Context context,
                                             Connection connection,
                                             String selectionTableName,
                                             Date broadcastDate,
                                             int selectorId) throws SQLException {
            createSelectionTable(connection, selectionTableName);
            executeUpdate(connection, loadQuery("ZeStaticSelector", context));
        }


        @Override
        protected void executeGenericSelector(Context context,
                                              Connection connection,
                                              String selectionTableName,
                                              Date broadcastDate,
                                              int selectorId) throws SQLException {
            createSelectionTable(connection, selectionTableName);
            String selectorQuery = BASE_INSERT_QUERY + getSelectorQuery(connection, selectorId);
            executeQueryWithVariables(context, connection, selectorQuery);
        }


        private void createSelectionTable(Connection connection, String tableName) throws SQLException {
            createTempTable(connection, tableName,
                            " TITLE      varchar(255)  not null,"
                            + " AUTHOR      varchar(150)  not null,"
                            + " BROADCAST_DATE timestamp null, ");
        }
    }
}
