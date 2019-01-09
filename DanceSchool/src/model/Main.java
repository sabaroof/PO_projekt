package model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Student stud = new Student("Miłosz", "Sabadach");
        Student stud2 = new Student("Marcin", "Dobrucki");
        ArrayList studs = new ArrayList();
        Teacher teach = new Teacher("Agustin", "Egurrola");
        //Lesson taniec = new Lesson("Wtorek", 13, studs);

        System.out.println(stud.getName());
        //taniec.assignStudent(stud);
        //taniec.assignStudent(stud2);
        //taniec.assignTeacher(teach);
        //System.out.println(taniec.getStudents());
        //System.out.println(taniec.getTeacher());
    }
}
