import java.util.Scanner;

public class Problem3 {

    private static Scanner in;
    
    public static void main(String[] args) {
        int hour, minute, second, n;
        
        in = new Scanner(System.in);
		System.out.println("Enter hours: ");
        n = in.nextInt();
        hour = validInput(n, 24);
        System.out.println("Enter minutes: ");
        n = in.nextInt();
        minute = validInput(n, 60);
        System.out.println("Enter seconds: ");
        n = in.nextInt();
        second = validInput(n, 60);
       
        Time t = new Time(hour, minute, second);
		printResult(t);
		
		System.out.println("Enter hours: ");
		n = in.nextInt();
		hour = validInput(n, 24);
		System.out.println("Enter minutes: ");
		n = in.nextInt();
		minute = validInput(n, 60);
		System.out.println("Enter second: ");
		n = in.nextInt();
		second = validInput(n, 60);
		
		Time t2 = new Time(hour, minute, second);
		t.add(t2);
		printResult(t);
	}
    
    private static int validInput(int n, int max) {

		for (;;) {
        	if (n >= 0 && n < max) break;

            System.out.println("Invalid input\nTry again: ");
            n = in.nextInt();
        }
        return n;
    }

	private static void printResult(Time t) {

		System.out.println(t.toUniversal());
		System.out.println(t.toStandard());
	}
}

public class Time {

	private int hour, minute, second;
    
    Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public String toUniversal() {
        
		StringBuilder r = new StringBuilder();
        
		correction(hour, r);
        r.append(":");
		correction(minute, r);
        r.append(":");
		correction(second, r);
        
        return r.toString();
    }

	public String toStandard() {

		StringBuilder r = new StringBuilder();
		
		String period;
		if (hour <= 12) period = " AM";
		else {
			period = " PM";
			hour %= 12;
		}

		
		correction(hour, r);
		r.append(":");
		correction(minute, r);
		r.append(":");
		correction(second, r);
		r.append(period);

		return r.toString();
	}

	public void correction(int n, StringBuilder r) {

		if (n < 10) r.append(0);
		r.append(n);
	}

	public void add(Time other) {
	    this.second += other.second;
    	this.minute += other.minute;
    	this.hour += other.hour;
    
    	if (this.second >= 60) {
        	this.minute += this.second / 60;
        	this.second %= 60;
    	}
    	if (this.minute >= 60) {
    	    this.hour += this.minute / 60;
        	this.minute %= 60;
    	}
	}
}
