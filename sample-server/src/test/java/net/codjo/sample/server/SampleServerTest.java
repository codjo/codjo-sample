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
        jdbc.executeUpdate("insert into REF_AUTHOR (AUTHOR, BIOGRAPHY) values ('john', '1522-1689')");
        jdbc.executeUpdate("insert into AP_BOOK (TITLE, AUTHOR) values ('database for you', 'my dear')");

        jdbc.assertContent(table("REF_AUTHOR"),
                           new String[][]{
                                 {"my dear", "1522-1689"},
                                 {"john", "1522-1689"}
                           });
    }


    @Test
    public void test_truncateTable_withConstraint() throws Exception {
        jdbc.create(table("AP_TABLE"), "  TITLE   varchar(255)  not null,"
                                       + "AUTHOR  varchar(150)  not null");
        jdbc.create(table("REF_TABLE"), "  AUTHOR      varchar(150)  not null,"
                                        + "BIOGRAPHY   varchar(300)  null");

        jdbc.executeUpdate("alter table REF_TABLE add (constraint X1_REF_TABLE unique (AUTHOR))");
        jdbc.executeUpdate("alter table AP_TABLE    add (constraint X1_AP_TABLE    unique (TITLE, AUTHOR))");
        jdbc.executeUpdate("alter table AP_TABLE add constraint FK_TABLE"
                           + " foreign key (AUTHOR) references REF_TABLE (AUTHOR)");

        jdbc.executeUpdate("insert into REF_TABLE (AUTHOR, BIOGRAPHY) values ('my dear', '1522-1689')");
        jdbc.executeUpdate("insert into REF_TABLE (AUTHOR, BIOGRAPHY) values ('john'   , '1522-1689')");
        jdbc.executeUpdate("insert into AP_TABLE (TITLE, AUTHOR) values ('database for you', 'my dear')");

        jdbc.assertContent(table("REF_TABLE"),
                           new String[][]{
                                 {"my dear", "1522-1689"},
                                 {"john", "1522-1689"}
                           });

        jdbc.deleteAllTables();

        jdbc.util().spool(table("REF_TABLE"));

        jdbc.assertIsEmpty(table("REF_TABLE"));
        jdbc.assertIsEmpty(table("AP_TABLE"));
    }


    @Test
    public void test_doDeleteOk() throws Exception {
        jdbc.deleteAllTables();
        jdbc.executeUpdate("insert into REF_AUTHOR (AUTHOR, BIOGRAPHY) values ('mikado', '1900-1989')");
        jdbc.deleteAllTables();
        jdbc.assertIsEmpty(table("REF_AUTHOR"));
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
