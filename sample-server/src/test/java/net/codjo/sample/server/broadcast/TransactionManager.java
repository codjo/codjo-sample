package net.codjo.sample.server.broadcast;
import java.sql.Connection;
import java.sql.SQLException;
import net.codjo.database.common.api.DatabaseFactory;
import org.apache.log4j.Logger;
/**
*
*/
class TransactionManager {
    private boolean previousAutoCommitMode;
    private boolean hasToChangeAutoCommit;
    private final Logger APP = Logger.getLogger(SelectorTestCase.class);


    TransactionManager(Connection connection) throws SQLException {
        previousAutoCommitMode = connection.getAutoCommit();
        hasToChangeAutoCommit = hasToChangeAutoCommit();
        if (hasToChangeAutoCommit) {
            APP.debug("changing autocommit mode to false");
            connection.setAutoCommit(false);
        }
    }


    private boolean hasToChangeAutoCommit() {
        return new DatabaseFactory().getDatabaseQueryHelper().hasDeleteRowStrategyOnTemporaryTable();
    }


    void release(Connection connection) throws SQLException {
        if (hasToChangeAutoCommit) {
            APP.debug("restoring autocommit to:" + previousAutoCommitMode);
            if (connection != null) {
                connection.setAutoCommit(previousAutoCommitMode);
            }
        }
    }


    public void commit(Connection connection) throws SQLException {
        if (hasToChangeAutoCommit && !connection.getAutoCommit()) {
            APP.debug("Commiting datas");
            connection.commit();
        }
    }


    public void rollback(Connection connection) throws SQLException {
        if (hasToChangeAutoCommit && !connection.getAutoCommit()) {
            APP.debug("Rollbacking datas");
            connection.rollback();
        }
    }
}
