package daoimpl;

import dao.DaoFactory;
import dao.EntityDao;
import models.Section;
import models.Staff;
import models.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MySqlDaoFactoryImpl implements DaoFactory<Connection> {
    private Map<Class, DaoCreator> creators;

    public MySqlDaoFactoryImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();

        creators.put(Section.class, new DaoCreator<Connection>() {
            @Override
            public EntityDao create(Connection connection) {
                return new SectionDao(connection);
            }
        });

        creators.put(Staff.class, new DaoCreator<Connection>() {
            @Override
            public EntityDao create(Connection connection) {
                return new StaffDao(connection);
            }
        });

        creators.put(Task.class, new DaoCreator<Connection>() {
            @Override
            public EntityDao create(Connection connection) {
                return new TaskDao(connection);
            }
        });
    }

    @Override
    public Connection getContext() {
        Connection connection = null;

        try {
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String pass = resource.getString("password");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public EntityDao getDao(Connection connection, Class dtoClass) {
        DaoCreator creator = creators.get(dtoClass);
        return creator.create(connection);
    }

    @Override
    public SectionDao getSectionDao(Connection connection) {
        return new SectionDao(connection);
    }

    @Override
    public StaffDao getStaffDao(Connection connection) {
        return new StaffDao(connection);
    }

    @Override
    public TaskDao getTaskDao(Connection connection) {
        return new TaskDao(connection);
    }
}
