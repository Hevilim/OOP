package practice2;

public class Student {
    
    private String name;
    private int id;
    private String major;
    
    public Student(String name, int id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }
    
    public Student(String name, int id) {
        this(name, id, "Undeclared");
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    @Override
    public String toString() {
        return "Student " + name + " (ID: " + id + ", Major: " + major + ")";
    }
}