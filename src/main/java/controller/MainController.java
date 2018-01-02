package controller;

import dao.EntityDao;
import daoimpl.MySqlDaoFactoryImpl;
import daoimpl.SectionDao;
import daoimpl.StaffDao;
import daoimpl.TaskDao;
import models.*;
import view.DataDisplay;

import java.util.List;

public class MainController {
    private MySqlDaoFactoryImpl factory;
    private SectionDao sectionDao;
    private StaffDao staffDao;
    private TaskDao taskDao;
    private DataDisplay display;


    public MainController() {
        factory = new MySqlDaoFactoryImpl();
        sectionDao = factory.getSectionDao(factory.getContext());
        staffDao = factory.getStaffDao(factory.getContext());
        taskDao = factory.getTaskDao(factory.getContext());
        display = new DataDisplay();
    }

    public void run() {
        getAllTasks();
        getTasksByStuff(3);
        addTask();
        getAllTasks();

        getAllStaff();
        getStaffBySection("development");
        deleteStaff(9);
        getAllStaff();
    }

    public void getAllTasks() {
        List<Task> allTasks = taskDao.getAll();
        display.displayTasks(allTasks);
    }

    public void getTasksByStuff(int key) {
        List<Task> tasks = taskDao.getTaskByStaff(key);
        display.displayTasksByStaff(tasks);
    }

    public void getAllStaff() {
        List<Staff> allStaff = staffDao.getAll();
        display.displayStaff(allStaff);
    }

    public void getStaffBySection(String section) {
        List<Staff> staff = staffDao.getStaffBySection(section);
        display.displayStaffBySection(staff, section);
    }

    public void deleteStaff(int key) {
        int rows = staffDao.delete(key);
        display.displayDeletedStaff(rows);
    }

    public void addTask() {
        Task task = new Task(15, "test2", 6);
        int rows = taskDao.create(task);
        display.displayAddedTask(rows);
    }
}
