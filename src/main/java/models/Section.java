package models;

public class Section {
    private int sectionPK;
    private String SectionName;
    private String PhoneNumber;

    public Section() {
    }

    public Section(int sectionPK, String sectionName, String phoneNumber) {
        this.sectionPK = sectionPK;
        SectionName = sectionName;
        PhoneNumber = phoneNumber;
    }

    public int getSectionPK() {
        return sectionPK;
    }

    public void setSectionPK(int sectionPK) {
        this.sectionPK = sectionPK;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String sectionName) {
        SectionName = sectionName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "sectionPK=" + sectionPK +
                ", SectionName='" + SectionName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'';
    }
}
