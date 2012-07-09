package net.codjo.sample.server.broadcast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import net.codjo.broadcast.common.computed.AbstractComputedField;
import net.codjo.broadcast.common.computed.ComputedContext;
/**
 *
 */
public class ComputedPublicationDate extends AbstractComputedField {

    public ComputedPublicationDate() {
        super("COMPUTED_PUBLICATION", Types.VARCHAR, "COMPUTED_PUBLICATION varchar(4)");
    }


    public void compute(ComputedContext computedContext, Connection connection) throws SQLException {
        String query = "update "
                       + "(select " + computedContext.getComputedTableName() + "." + getName()
                       + " as fieldToBeUpdated, extract(year from PUBLICATION_YEAR) as my_year "
                       + " from (" + computedContext.joinToBroadcastTable() + ")"
                       + ")"
                       + " set fieldToBeUpdated = my_year";
        PreparedStatement statement = connection.prepareStatement(computedContext.replaceVariables(query));
        try {
            statement.executeUpdate();
        }
        finally {
            statement.close();
        }
    }
}


