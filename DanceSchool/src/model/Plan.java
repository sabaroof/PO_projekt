package model;

import javafx.css.SimpleStyleableObjectProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Plan {
    private ArrayList<Lesson> lessons;
    private HashMap<Lesson, String> nameMap;

    public void setLessons(ArrayList<Lesson> lessons){
        this.lessons = lessons;
    }

    public void setNameMap(HashMap<Lesson, String> nameMap) {
        this.nameMap = nameMap;
    }

    public ArrayList<Lesson> getLessons(){ return lessons; }
    public HashMap<Lesson, String> getNameMap() { return nameMap; }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        nameMap.put(lesson, lesson.getName());
    }

    public void removeLesson(Lesson lesson){
        lessons.remove(lesson);
        nameMap.remove(lesson,lesson.getName());
    }

    public Plan(){
        ArrayList<Lesson> lessons = new ArrayList<>();
        HashMap<Lesson, String> nameMap = new HashMap<>();
        setLessons(lessons);
        setNameMap(nameMap);
    }
}
