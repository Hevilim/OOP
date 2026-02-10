import practice2.Student;
import java.util.Scanner;

public class Problem4 {
    
    public static void main(String[] args) {
        Course cs101 = new Course("CS101", "Object-oriented Programming and Design", 
                                  3, "None");
        
        GradeBook gradeBook = new GradeBook(cs101);
        
        gradeBook.addStudent(new Student("A", 1, "CS"));
        gradeBook.addStudent(new Student("B", 4, "CS"));
        gradeBook.addStudent(new Student("C", 23, "CS"));
        gradeBook.addStudent(new Student("D", 87, "CS"));
        gradeBook.addStudent(new Student("E", 45, "CS"));
        gradeBook.addStudent(new Student("F", 67, "CS"));
        gradeBook.addStudent(new Student("G", 12, "CS"));
        gradeBook.addStudent(new Student("H", 56, "CS"));
        gradeBook.addStudent(new Student("I", 34, "CS"));
        gradeBook.addStudent(new Student("J", 78, "CS"));
        
        gradeBook.displayMessage();
        
        Scanner scanner = new Scanner(System.in);
        
        for (Student student : gradeBook.getStudents()) {
            System.out.print("Enter grade for Student " + student.getName() + ": ");
            double grade = scanner.nextDouble();
            gradeBook.addGrade(student.getId(), grade);
        }
        
        gradeBook.displayGradeReport();
        
        scanner.close();
    }
}

//java -cp ..:. Problem4