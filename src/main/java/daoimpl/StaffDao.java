package daoimpl;

import dao.AbstractEntityDao;
import models.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao extends AbstractEntityDao<Staff> {

    public StaffDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Staff";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Staff WHERE StaffPK = ?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Staff(StaffName, Surname, Position, SectionFK) VALUES \n" +
                "(?, ?, ?, ?)";
    }

    public String getStaffByDepartment(){
        return "SELECT * FROM Staff st, Section s WHERE (s.SectionPK = st.SectionFK) AND (s.SectionName = ?)";
    }

    @Override
    protected List<Staff> parseResultSet(ResultSet rs) {
        List<Staff> workers = new ArrayList<>();
        try {
            while(rs.next()){
                Staff staff = new Staff();
                staff.setStaffPK(rs.getInt("StaffPK"));
                staff.setStaffName(rs.getString("StaffName"));
                staff.setSurname(rs.getString("Surname"));
                staff.setPosition(rs.getString("Position"));
                staff.setSectionFK(rs.getInt("SectionFK"));
                workers.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Staff object) {
        try {
            preparedStatement.setString(1, object.getStaffName());
            preparedStatement.setString(2, object.getSurname());
            preparedStatement.setString(3, object.getPosition());
            preparedStatement.setInt(4, object.getSectionFK());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Staff> getStaffBySection(String department) {
        return getBySection(department, getStaffByDepartment());
    }

    @Override
    public int create(Staff object) {
        return insertObject(object);
    }
}
