import practice2.Student;
import java.util.ArrayList;
import java.util.HashMap;

public class GradeBook {
    
    private Course course;
    private ArrayList<Student> students;
    private HashMap<Integer, Double> grades;
    
    public GradeBook(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    
    public GradeBook(Course course, ArrayList<Student> students) {
        this.course = course;
        this.students = students;
        this.grades = new HashMap<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void addGrade(int studentId, double grade) {
        grades.put(studentId, grade);
    }
    
    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course.getName() + " " + 
                         course.getDescription() + "!");
    }
    
    public void displayGradeReport() {
        System.out.println("\nPlease, input grades for students:\n");
        
        for (Student student : students) {
            Double grade = grades.get(student.getId());
            if (grade != null) {
                System.out.println("Student " + student.getName() + ": " + 
                                 String.format("%.0f", grade));
            }
        }
        
        double average = determineClassAverage();
        System.out.println("\nClass average is " + String.format("%.2f", average) + 
                         ". " + getLowestGradeInfo() + ".");
        System.out.println(getHighestGradeInfo() + ".");
        
        System.out.println("\nGrades distribution:");
        outputBarChart();
    }
    
    public double determineClassAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    private String getLowestGradeInfo() {
        if (grades.isEmpty()) {
            return "No grades available";
        }
        
        double lowest = Double.MAX_VALUE;
        int studentId = -1;
        
        for (int id : grades.keySet()) {
            double grade = grades.get(id);
            if (grade < lowest) {
                lowest = grade;
                studentId = id;
            }
        }
        
        Student student = findStudentById(studentId);
        return "Lowest grade is " + String.format("%.0f", lowest) + 
               " (" + student.getName() + ", id: " + studentId + ")";
    }
    
    private String getHighestGradeInfo() {
        if (grades.isEmpty()) {
            return "No grades available";
        }
        
        double highest = Double.MIN_VALUE;
        int studentId = -1;
        
        for (int id : grades.keySet()) {
            double grade = grades.get(id);
            if (grade > highest) {
                highest = grade;
                studentId = id;
            }
        }
        
        Student student = findStudentById(studentId);
        return "Highest grade is " + String.format("%.0f", highest) + 
               " (" + student.getName() + ", id:" + studentId + ")";
    }
    
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    public void outputBarChart() {
        int[] distribution = new int[11];
        
        for (double grade : grades.values()) {
            int index = (int) grade / 10;
            if (index == 10) index = 9;
            distribution[index]++;
            if (grade == 100) {
                distribution[10]++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.print("90-99: ");
            } else {
                System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            }
            
            for (int j = 0; j < distribution[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.print("100: ");
        for (int j = 0; j < distribution[10]; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public Course getCourse() {
        return course;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    @Override
    public String toString() {
        return "GradeBook for " + course.getName() + " with " + students.size() + " students";
    }
}