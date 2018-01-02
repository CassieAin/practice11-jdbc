package simple_version;

import java.sql.*;

public class DatabaseService {
    static ResultSet rs = null;
    static Statement statement = null;
    static PreparedStatement preparedStatement = null;

    public static ResultSet selectTasks(Connection connection) throws SQLException {
        statement = connection.createStatement();
        String sql = "select TaskPK, Description, StaffFK from Task";
        rs = statement.executeQuery(sql);
        return rs;
    }

    public static ResultSet selectStaff(Connection connection) throws SQLException {
        String sql = "select StaffPK, StaffName, Surname, Position, SectionFK from Staff";
        rs = statement.executeQuery(sql);
        return rs;
    }

    public static int addTaskForStaff(Connection connection, int staffFK, String description) throws SQLException {
        String sql = "INSERT INTO Task (Description, StaffFK) VALUES (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, description);
        preparedStatement.setInt(2, staffFK);
        int rows = preparedStatement.executeUpdate();
        return rows;
    }

    public static int deleteStaff(Connection connection, int staffPK) throws SQLException {
        String sql = "DELETE FROM Staff WHERE StaffPK = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffPK);
        int rows = preparedStatement.executeUpdate();
        return rows;
    }

    public static ResultSet selectStaffBySections(Connection connection, String section) throws SQLException {
        String sql = "SELECT * FROM Staff st, Section s WHERE (s.SectionPK = st.SectionFK) AND (s.SectionName = ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, section);
        rs = preparedStatement.executeQuery();
        return rs;
    }

    public static ResultSet getTasksForStaff(Connection connection, int staffPK) throws SQLException {
        String sql = "SELECT t.Description FROM Task t, Staff s WHERE (t.StaffFK = s.StaffPK) AND (s.StaffPK = ?);";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffPK);
        rs = preparedStatement.executeQuery();
        return rs;
    }
}
