package model;

import java.util.ArrayList;

public class Lesson {
    private String day;
    private int hour;
    private Teacher teacher;
    private ArrayList students;
    private int maxStudents;

    public Teacher getTeacher() { return teacher; }
    public ArrayList getStudents() { return students; }

    public Lesson(String day, int hour, ArrayList students){
        this.day = day;
        this.hour = hour;
        this.students = students;
    }

    public void assignTeacher(Teacher t){ this.teacher = t; }
    public void assignStudent(Student s){ students.add(s); }
    public void removeStudent(Student s){ students.remove(s); }
}
