package org.example;

public class Student extends Human {
    private String facultyName;
    Student(String lastName, String firstName, String patronymic, int age, String facultyName) {
        super(lastName, firstName, patronymic, age);
        this.facultyName = facultyName;
    }
    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
}
