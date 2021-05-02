package people.implement;

import people.connector.ConnectorCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public final class FinallyUtil {

    static void blockFinallyClose(Connection connection, Statement statement) {
        try {
            if (Objects.nonNull(connection)) {
                ConnectorCreator.closeConnection();
            }
            if (Objects.nonNull(statement)) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
