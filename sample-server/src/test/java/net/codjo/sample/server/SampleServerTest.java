package net.codjo.sample.server;
import net.codjo.database.common.api.JdbcFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.codjo.database.common.api.structure.SqlTable.table;
/**
 *
 */
public class SampleServerTest {
    private JdbcFixture jdbc = JdbcFixture.newFixture();


    @Test
    public void test_doStuffInBd() throws Exception {
        jdbc.delete(table("AP_BOOK"));
        jdbc.executeUpdate("insert into AP_BOOK (TITLE, AUTHOR) values ('database for you', '')");
    }


    @Before
    public void setUp() throws Exception {
        jdbc.doSetUp();
    }


    @After
    public void tearDown() throws Exception {
        jdbc.doTearDown();
    }
}
