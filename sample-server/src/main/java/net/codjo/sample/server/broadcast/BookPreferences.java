package net.codjo.sample.server.broadcast;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import net.codjo.broadcast.common.PostBroadcaster;
import net.codjo.broadcast.common.Preferences;
import net.codjo.broadcast.common.Selector;
import net.codjo.broadcast.common.computed.ComputedField;
/**
 *
 */
public class BookPreferences extends Preferences {
    public static final String FAMILY = "BOOKS";


    public BookPreferences() {
        super(FAMILY,
              "AP_BOOK",
              "$dbApplicationUser$.TMP_ALL_BOOK_SEL",
              "$dbApplicationUser$.TMP_BOOK_COMPUTE");
    }


    @Override
    public PostBroadcaster buildPostBroadcaster(Connection con, BigDecimal fileId,
                                                BigDecimal contentId, BigDecimal sectionId) {
        return null;
    }


    @Override
    protected ComputedField[] initComputedFields() {
        return new ComputedField[]{new ComputedPublicationDate()};
    }


    @Override
    protected void initJoinKeys() {
        addJoinKeys(INNER_JOIN, getComputedTableName(), getSelectionTableName(),
                    new String[][]{
                          {"SELECTION_ID", "SELECTION_ID", "="}
                    });
        addJoinKeys(RIGHT_JOIN, "AP_BOOK", getSelectionTableName(),
                    new String[][]{
                          {"TITLE", "TITLE", "="},
                          {"AUTHOR", "AUTHOR", "="}
                    });
    }


    @Override
    public Selector buildSelector(Connection con, BigDecimal contentID,
                                  BigDecimal sectionID, BigDecimal selectionID)
          throws SQLException {
        return new BookSelector(selectionID.intValue());
    }
}
