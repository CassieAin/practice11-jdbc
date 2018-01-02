package daoimpl;

import dao.AbstractEntityDao;
import models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao extends AbstractEntityDao<Task> {

    public TaskDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT TaskPK, Description, StaffFK FROM Task";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Task WHERE TaskPK = ?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Task(Description, StaffFK) VALUES \n" +
                "(?, ?)";
    }

    public String getTasksByStaffQuery(){
        return "SELECT t.TaskPK, t.Description, t.StaffFK FROM Task t, Staff s WHERE (t.StaffFK = s.StaffPK) AND (s.StaffPK = ?)";
    }

    @Override
    protected List<Task> parseResultSet(ResultSet rs) {
        List<Task> tasks = new ArrayList<>();
        try {
            while(rs.next()){
                Task task = new Task();
                task.setTaskPK(rs.getInt("TaskPK"));
                task.setDescription(rs.getString("Description"));
                task.setStaffFk(rs.getInt("StaffFK"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Task object) {
        try {
            preparedStatement.setString(1, object.getDescription());
            preparedStatement.setInt(2, object.getStaffFk());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int create(Task object) {
        return insertObject(object);
    }

    public List<Task> getTaskByStaff(int StaffPK) {
        return getByStaff(StaffPK, getTasksByStaffQuery());
    }

//    public int createTaskForStaff(String description, int staffFK) throws SQLException {
//        String sql = "INSERT INTO Task (Description, StaffFK) VALUES (?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, description);
//        preparedStatement.setInt(2, staffFK);
//        int rows = preparedStatement.executeUpdate();
//        return rows;
//    }
}
