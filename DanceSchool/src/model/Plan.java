package model;

import javafx.css.SimpleStyleableObjectProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Plan {
    private ArrayList<Lesson> lessons;
    private HashMap<Lesson, String> nameMap;
    private Integer price;

    public void setLessons(ArrayList<Lesson> lessons){
        this.lessons = lessons;
    }
    public void setNameMap(HashMap<Lesson, String> nameMap) { this.nameMap = nameMap; }
    public void setPrice(Integer price) { this.price = price; }

    public ArrayList<Lesson> getLessons(){ return lessons; }
    public HashMap<Lesson, String> getNameMap() { return nameMap; }
    public Integer getPrice() { return price; }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        nameMap.put(lesson, lesson.getName());
        countPrice();
    }

    public void removeLesson(Lesson lesson){
        lessons.remove(lesson);
        nameMap.remove(lesson,lesson.getName());
        countPrice();
    }

    public void countPrice(){
        int tempPrice = 0;
        for(int i=0; i<lessons.size(); i++){
            tempPrice += lessons.get(i).getPrice();
        }
        setPrice(tempPrice);
    }

    public Plan(){
        ArrayList<Lesson> lessons = new ArrayList<>();
        HashMap<Lesson, String> nameMap = new HashMap<>();
        setLessons(lessons);
        setNameMap(nameMap);
        setPrice(0);
    }
}
