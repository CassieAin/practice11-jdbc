package models;

public class Task {
    private int TaskPK;
    private String Description;
    private int StaffFk;

    public Task() {
    }

    public Task(int taskPK, String description, int staffFk) {
        TaskPK = taskPK;
        Description = description;
        StaffFk = staffFk;
    }

    public int getTaskPK() {
        return TaskPK;
    }

    public void setTaskPK(int taskPK) {
        TaskPK = taskPK;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStaffFk() {
        return StaffFk;
    }

    public void setStaffFk(int staffFk) {
        StaffFk = staffFk;
    }

    @Override
    public String toString() {
        return "TaskPK=" + TaskPK +
                ", Description='" + Description + '\'' +
                ", StaffFk=" + StaffFk;
    }
}
