package daoimpl;

import dao.AbstractEntityDao;
import models.Section;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDao extends AbstractEntityDao<Section> {

    public SectionDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Section";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Section WHERE SectionPK = ?";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Section(SectionName, PhoneNumber) VALUES (?, ?)";
    }

    @Override
    protected List<Section> parseResultSet(ResultSet rs) {
        List<Section> sections = new ArrayList<Section>();
        try {
            while (rs.next()) {
                Section section = new Section();
                section.setSectionPK(rs.getInt("SectionPK"));
                section.setSectionName(rs.getString("SectionName"));
                section.setPhoneNumber(rs.getString("PhoneNumber"));
                sections.add(section);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sections;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Section object) {
        try {
            preparedStatement.setString(1, object.getSectionName());
            preparedStatement.setString(2, object.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int create(Section object) {
        return insertObject(object);
    }
}
