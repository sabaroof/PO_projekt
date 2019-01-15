package model;

public class LoggedUser {
    private static LoggedUser ourInstance = new LoggedUser();

    public static LoggedUser getInstance() {
        return ourInstance;
    }

    private Student student;
    public Student getStudent() { return student; }

    private Teacher teacher;

    private LoggedUser(){
        Plan emptyPlan = new Plan();
        Student loggedStudent = new Student("Empty", "Empty", emptyPlan);
        this.student = loggedStudent;
    }

    public void init(String name, String surname){
        getStudent().setName(name);
        getStudent().setSurname(surname);
    }

}
