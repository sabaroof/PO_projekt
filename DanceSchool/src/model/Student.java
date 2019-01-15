package model;

public class Student extends User {
    private String level; //nie wiem co tu na razie dać
    private Plan plan;

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public Plan getPlan() { return  plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    public Student(String n, String s, Plan p){
        super(n, s);
        this.plan = p;
    }

    public void createStudent(String name, String surname) {
        setName(name);
        setSurname(surname);
        Plan emptyPlan = new Plan();
        setPlan(emptyPlan);
    }
}
