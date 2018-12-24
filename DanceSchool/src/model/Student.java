package model;

public class Student extends User {
    private String level; //nie wiem co tu na razie dać

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public Student(String n, String s){
        super(n, s);
    }
}
