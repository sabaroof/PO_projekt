package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GradesModel{
    private SimpleStringProperty nazwa;
    private SimpleIntegerProperty ocena;

    public GradesModel(String nazwa, Integer ocena){
        this.nazwa = new SimpleStringProperty(nazwa);
        this.ocena = new SimpleIntegerProperty(ocena);
    }

    public String getNazwa(){ return nazwa.get(); }
    public Integer getOcena(){ return ocena.get(); }

    public void setNazwa(String nazwa) { this.nazwa = new SimpleStringProperty(nazwa); }
    public void setOcena(Integer ocena) { this.ocena = new SimpleIntegerProperty(ocena); }
}