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
        jdbc.delete(table("REF_AUTHOR"));
        jdbc.executeUpdate("insert into REF_AUTHOR (AUTHOR, BIOGRAPHY) values ('my dear', '1522-1689')");
        jdbc.executeUpdate("insert into AP_BOOK (TITLE, AUTHOR) values ('database for you', 'my dear')");
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
