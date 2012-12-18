package net.codjo.sample.server.broadcast;
import net.codjo.broadcast.common.Context;
import org.junit.Test;
/**
 *
 */
public class BookSelectorTest extends SelectorTestCase {
    private static final String TEMP_TABLE = "TMP_TEMP_TABLE";


    @Test
    public void test_proceed() throws Exception {
        assertProceed(new BookSelector(0), TEMP_TABLE, "bookSelector", new Context(), null);
        assertProceed(new BookSelector(0), TEMP_TABLE, "bookSelector");
    }
}
