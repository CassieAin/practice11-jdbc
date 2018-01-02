package view;

import simple_version.DatabaseService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDisplay<T> {

    private void displayResultSet(List<T> objects) {
        for (T object : objects) {
            DataLogging.logData(object + "");
        }
    }

    public void displayTasks(List<T> objects) {
        DataLogging.logData("All tasks:");
        displayResultSet(objects);
    }

    public void displayStaff(List<T> objects) {
        DataLogging.logData("All staff:");
        displayResultSet(objects);
    }

    public void displayStaffBySection(List<T> objects, String section) {
        DataLogging.logData("Staff from the: " + section + " section");
        displayResultSet(objects);
    }

    public void displayTasksByStaff(List<T> objects) {
        DataLogging.logData("Tasks for the staff member: ");
        displayResultSet(objects);
    }

    public void displayDeletedStaff(int rows) {
        if (rows > 0) {
            DataLogging.logData("Staff was successfully deleted. Rows affected: " + rows);
        } else {
            DataLogging.logData("Something went wrong. Staff record was not deleted. Rows affected: " + rows);
        }
    }

    public void displayAddedTask(int rows) {
        if (rows > 0) {
            DataLogging.logData("Task was successfully added. Rows affected: " + rows);
        } else {
            DataLogging.logData("Something went wrong. Task record was not added. Rows affected: " + rows);
        }
    }
}
