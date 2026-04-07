import java.util.Comparator;
import java.util.Date;

public class Employee extends Person implements Comparable<Employee>, Cloneable {
    private double salary;
    private Date hireDate;
    private String nationalInsuranceNumber;

    public Employee() {
        super();
        salary = 0;
        hireDate = new Date();
        nationalInsuranceNumber = "";
    }

    public Employee(String name, double salary, Date hireDate, String nationalInsuranceNumber) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String toString() {
        return "Name: " + getName() + ", Salary: " + salary
                + ", Hire Date: " + hireDate
                + ", NIN: " + nationalInsuranceNumber;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee other = (Employee) obj;
            return getName().equals(other.getName())
                    && salary == other.salary
                    && nationalInsuranceNumber.equals(other.nationalInsuranceNumber);
        }
        return false;
    }

    public int compareTo(Employee other) {
        if (this.salary > other.salary) return 1;
        if (this.salary < other.salary) return -1;
        return 0;
    }

    public static Comparator<Employee> getNameComparator() {
        return new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
    }

    public static Comparator<Employee> getHireDateComparator() {
        return new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e1.hireDate.compareTo(e2.hireDate);
            }
        };
    }

    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.hireDate = new Date(hireDate.getTime());
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
