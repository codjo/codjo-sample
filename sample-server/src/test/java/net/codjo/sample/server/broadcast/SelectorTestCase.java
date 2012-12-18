package net.codjo.sample.server.broadcast;
import java.sql.Connection;
import java.sql.Date;
import net.codjo.broadcast.common.Context;
import net.codjo.broadcast.common.Selector;
import net.codjo.tokio.TokioTestCase;
import org.junit.Ignore;
/**
 *
 */
@Ignore
public class SelectorTestCase extends TokioTestCase {

    public void assertProceed(Selector selector,
                              final String tempTableName,
                              String storyName) throws Exception {
        assertProceed(selector, tempTableName, storyName, new Context(), null);
    }


    public void assertProceed(Selector selector,
                              final String tempTableName,
                              String storyName,
                              final Context context, final Date today) throws Exception {
        final Connection connection = tokioFixture.getConnection();
        TransactionManager transactionManager = new TransactionManager(connection);
        try {
            tokioFixture.insertInputInDb(storyName);
            selector.proceed(context, connection, tempTableName, today);
            tokioFixture.assertAllOutputs(storyName);
        }
        catch (Exception ex) {
            transactionManager.rollback(connection);
            throw ex;
        }
        finally {
            transactionManager.release(connection);
        }
    }
}
