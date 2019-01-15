package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
    private int price;

    private SimpleStringProperty nameGUI;
    private SimpleIntegerProperty priceGUI;

    public Lesson(String nameGUI, Integer priceGUI){
        this.nameGUI = new SimpleStringProperty(nameGUI);
        this.priceGUI = new SimpleIntegerProperty(priceGUI);
    }

    public String getNameGUI(){ return nameGUI.get(); }
    public Integer getPriceGUI(){ return priceGUI.get(); }

    public void setNameGUI(String nameGUI) { this.nameGUI = new SimpleStringProperty(nameGUI); }
    public void setPriceGUI(Integer priceGUI) { this.priceGUI = new SimpleIntegerProperty(priceGUI); }

    public String getName() { return name; }
    public String getDay() { return day; }
    public int getHour() { return hour; }
    public Teacher getTeacher() { return teacher; }
    public ArrayList<Student> getStudents() { return students; }
    public ArrayList getInfo() { return info; }
    public int getMaxStudents() { return maxStudents; }
    public int getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setDay(String day) { this.day = day; }
    public void setHour(int hour) { this.hour = hour; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }
    public void setStudents(ArrayList<Student> students) { this.students = students; }
    public void setInfo(ArrayList info) { this.info = info; }
    public void setMaxStudents(int maxStudents) { this.maxStudents = maxStudents; }
    public void setPrice(int price) { this.price = price; }

    public void createInfo(){
        ArrayList info = new ArrayList();
        info.add(this.name);
        info.add(this.day);
        info.add(this.hour);
        info.add(this.teacher);
        info.add(this.maxStudents);
        info.add(this.price);
        setInfo(info);
    }

    public Lesson(String name, String day, int hour, ArrayList students, int maxStudents, int price){
        this.name = name;
        this.day = day;
        this.hour = hour;
        this.students = students;
        this.maxStudents = maxStudents;
        this.price = price;
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
