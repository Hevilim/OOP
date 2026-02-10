import java.util.Scanner;

public class Analyzer {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Data data = new Data();

		int num;
		for (;;) {
			System.out.println("Enter number (Q to quit): ");
			String input = in.next();

			if (input.equalsIgnoreCase("Q")) break;	

			try {
 	   		double val = Double.parseDouble(input);
      	data.addVal(val);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number or Q to quit.");
    	}
		}

		System.out.println("Average = " + data.getAvg());
		System.out.println("Maximum = " + data.getMax());

		in.close();	
	}
}

class Data {

	private double sum, max;
	private int cnt;

	Data() {
		this.sum = this.max = 0.0;
		this.cnt = 0;
	}

	void addVal(double val) {
		sum += val;
		cnt++;
		if (cnt == 1 || val > max) max = val;	
	}

	double getAvg() {
		if (cnt == 0) return 0.0;
		return sum / cnt;
	}

	double getMax() {
		return max;
	}
}

