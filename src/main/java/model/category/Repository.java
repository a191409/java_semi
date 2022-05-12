package model.category;

import lib.mysql.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Repository extends Client {
    public static void insert(Category category) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into categories (name, created_at, updated_at) values (?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

}
