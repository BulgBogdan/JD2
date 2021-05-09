package Person_Address.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ResultSetUtil {

    public static <T> T executeResultSet(String sql, Connection connection, T t) throws SQLException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                int count = 1;
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(t, rs.getObject(count));
                    count++;
                }
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(rs))
                rs.close();
            if (Objects.nonNull(statement))
                statement.close();
        }
        return t;
    }

    public static <T> List<T> executeResultSetList(String sql, Connection connection, T t) throws SQLException {
        List<T> list = new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            while (rs.next()) {
                int count = 1;
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(t, rs.getObject(count));
                    count++;
                }
                list.add(t);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(rs))
                rs.close();
            if (Objects.nonNull(statement))
                statement.close();
        }
        return list;
    }
}