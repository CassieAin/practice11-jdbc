package models;

public class Staff {
    private int StaffPK;
    private String StaffName;
    private String Surname;
    private String Position;
    private int SectionFK;

    public Staff() {
    }

    public Staff(int staffPK, String staffName, String surname, String position, int sectionFK) {
        StaffPK = staffPK;
        StaffName = staffName;
        Surname = surname;
        Position = position;
        SectionFK = sectionFK;
    }

    public int getStaffPK() {
        return StaffPK;
    }

    public void setStaffPK(int staffPK) {
        StaffPK = staffPK;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getSectionFK() {
        return SectionFK;
    }

    public void setSectionFK(int sectionFK) {
        SectionFK = sectionFK;
    }

    @Override
    public String toString() {
        return "StaffPK=" + StaffPK +
                ", StaffName='" + StaffName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Position='" + Position + '\'' +
                ", SectionFK=" + SectionFK;
    }
}
