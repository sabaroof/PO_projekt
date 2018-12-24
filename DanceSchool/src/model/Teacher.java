package model;

public class Teacher extends User {
    private String license;

    public String getLicense() { return license; }
    public void setLicense(String license) { this.license = license; }

    public Teacher(String n, String s){
        super(n, s);
    }
}
