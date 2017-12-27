package utils;

import view.DataDisplay;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = JDBCConnection.getConnection();
            DataDisplay.displayAllTasks(connection);

            DataDisplay.displayStaff(connection);
            DataDisplay.displayStaffBySections(connection, "development");
            DataDisplay.displayStaffBySections(connection, "management");
            DataDisplay.displayTasksForStaff(connection, 2);
            DataDisplay.displayStaffDeleted(connection, 9);
            DataDisplay.displayTaskAdded(connection, 5, "task 7");
        } catch (Exception E) {
            System.out.println("JDBC Driver error");
        }
    }
}
