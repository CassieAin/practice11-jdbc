package dao;

import daoimpl.SectionDao;
import daoimpl.StaffDao;
import daoimpl.TaskDao;

import java.sql.Connection;

public interface DaoFactory<Context>  {

    SectionDao getSectionDao(Connection connection);

    StaffDao getStaffDao(Connection connection);

    TaskDao getTaskDao(Connection connection);

    interface DaoCreator<Context> {
        EntityDao create(Context context);
    }

    Context getContext();

    EntityDao getDao(Context context, Class dtoClass);
}
