package Person_Address.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PreparedStatementUtil {

    public static boolean executePreparedStatement(String sql, Connection connection, List<String> parameters) throws SQLException {
        boolean correctFinish = false;
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                ps.setString(i + 1, parameters.get(i));
            }
            ps.executeUpdate();
            correctFinish = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return correctFinish;
    }
}