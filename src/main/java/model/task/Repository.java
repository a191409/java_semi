package model.task;

import lib.mysql.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Repository extends Client {
    public static void insert(Task task) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into tasks (name, description, `limit`, did_it, created_at, updated_at, user_id, category_id) values (?, ?, ?, ?, ?, ?, ?, ?)";

            connection = create();

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, task.getLimit());
            stmt.setBoolean(4, task.getDidIt());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);
            stmt.setInt(7, task.getUserId());
            stmt.setInt(8, task.getCategoryId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
