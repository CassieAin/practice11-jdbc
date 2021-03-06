package simple_version;

import view.DataLogging;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayData {

    private static void displayResultSet5(ResultSet rs, String string1, String string2, String string3, String string4, String string5) throws SQLException {
        List<String> results = new ArrayList<>();
        while (rs.next()) {
            DataLogging.logData(rs.getString(string1) + "," + rs.getString(string2)
                    + ", " + rs.getString(string3) + ", " + rs.getString(string4)
                    + ", " + rs.getString(string5));
        }
    }

    private static void displayResultSet4(ResultSet rs, String string1, String string2, String string3, String string4) throws SQLException {
        while (rs.next()) {
            DataLogging.logData(rs.getString(string1) + "," + rs.getString(string2)
                    + ", " + rs.getString(string3) + ", " + rs.getString(string4));
        }
    }

    private static void displayResultSet3(ResultSet rs, String string1, String string2, String string3) throws SQLException {
        while (rs.next()) {
            DataLogging.logData(rs.getString(string1) + "," + rs.getString(string2) + ", " + rs.getString(string3));
        }
    }

    private static void displayResultSet2(ResultSet rs, String string1, String string2) throws SQLException {
        while (rs.next()) {
            DataLogging.logData(rs.getString(string1) + "," + rs.getString(string2));
        }
    }

    private static void displayResultSet(ResultSet rs, String string1) throws SQLException {
        while (rs.next()) {
            DataLogging.logData(rs.getString(string1));
        }
    }

    public static void displayAllTasks(Connection connection) throws SQLException {
        DataLogging.logData("\nTasks: ");
        ResultSet rs = DatabaseService.selectTasks(connection);
        displayResultSet3(rs, "TaskPK", "Description", "StaffFK");
    }

    public static void displayStaff(Connection connection) throws SQLException {
        DataLogging.logData("\nStaff: ");
        ResultSet rs = DatabaseService.selectStaff(connection);
        displayResultSet5(rs, "StaffPK", "StaffName", "Surname", "Position", "SectionFK");
    }

    public static void displayTaskAdded(Connection connection, int staffFK, String description) throws SQLException {
        int rowsNumber = DatabaseService.addTaskForStaff(connection, staffFK, description);
        DataLogging.logData("Rows affected after task insertion: " + rowsNumber);
    }

    public static void displayStaffDeleted(Connection connection, int staffPK) throws SQLException {
        int rowsNumber = DatabaseService.deleteStaff(connection, staffPK);
        DataLogging.logData("Rows affected after staff being deleted: " + rowsNumber);
    }

    public static void displayStaffBySections(Connection connection, String section) throws SQLException {
        DataLogging.logData("\nStaff from the " + section + " section: ");
        ResultSet rs = DatabaseService.selectStaffBySections(connection, section);
        displayResultSet5(rs, "StaffPK", "StaffName", "Surname", "Position", "SectionFK");
    }

    public static void displayTasksForStaff(Connection connection, int staffPK) throws SQLException {
        DataLogging.logData("\nTasks for the " + staffPK + " staff member: ");
        ResultSet rs = DatabaseService.getTasksForStaff(connection, staffPK);
        displayResultSet(rs, "t.Description");
    }
}
