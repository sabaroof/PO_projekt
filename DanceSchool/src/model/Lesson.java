package model;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Lesson {
    private String name;
    private String day;
    private int hour;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList info;
    private int maxStudents;

    public String getName() { return name; }
    public String getDay() { return day; }
    public int getHour() { return hour; }
    public Teacher getTeacher() { return teacher; }
    public ArrayList<Student> getStudents() { return students; }
    public ArrayList getInfo() { return info; }
    public int getMaxStudents() { return maxStudents; }

    public void setInfo(ArrayList info){
        this.info = info;
    }

    public void createInfo(){
        ArrayList info = new ArrayList();
        info.add(this.name);
        info.add(this.day);
        info.add(this.hour);
        info.add(this.teacher);
        info.add(this.maxStudents);
        setInfo(info);
    }

    public Lesson(String name, String day, int hour, ArrayList students, int maxStudents){
        this.name = name;
        this.day = day;
        this.hour = hour;
        this.students = students;
        this.maxStudents = maxStudents;
        createInfo();
    }

    public void assignTeacher(Teacher t){ this.teacher = t; }
    public void removeStudent(Student s){ students.remove(s); }

    public void assignStudent(Student s){
        if(students.size()<maxStudents){
            students.add(s);
        }else{
            //tu pop-up jakiś trzeba dać
        }
    }
}
