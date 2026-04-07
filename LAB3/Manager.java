import java.util.Date;
import java.util.Vector;

public class Manager extends Employee {
    private double bonus;
    private Vector<Employee> team;

    public Manager() {
        super();
        bonus = 0;
        team = new Vector<Employee>();
    }

    public Manager(String name, double salary, Date hireDate, String nationalInsuranceNumber, double bonus) {
        super(name, salary, hireDate, nationalInsuranceNumber);
        this.bonus = bonus;
        team = new Vector<Employee>();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Vector<Employee> getTeam() {
        return team;
    }

    public void addEmployee(Employee e) {
        team.add(e);
    }

    public void removeEmployee(Employee e) {
        team.remove(e);
    }

    public String toString() {
        return "Name: " + getName() + ", Salary: " + getSalary()
                + ", Bonus: " + bonus
                + ", Hire Date: " + getHireDate()
                + ", NIN: " + getNationalInsuranceNumber()
                + ", Team size: " + team.size();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Manager) {
            Manager other = (Manager) obj;
            return super.equals(obj) && bonus == other.bonus;
        }
        return false;
    }

    public int compareTo(Employee other) {
        int result = super.compareTo(other);
        if (result != 0) return result;
        if (other instanceof Manager) {
            Manager otherManager = (Manager) other;
            if (this.bonus > otherManager.bonus) return 1;
            if (this.bonus < otherManager.bonus) return -1;
        }
        return 0;
    }

    public Manager clone() {
        Manager copy = (Manager) super.clone();
        copy.team = new Vector<Employee>();
        for (int i = 0; i < team.size(); i++) {
            copy.team.add(team.get(i).clone());
        }
        return copy;
    }
}
