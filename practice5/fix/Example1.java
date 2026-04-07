public class Example1
{
    public static void main(String[] args)
    {
        int denominator, numerator, ratio;
        numerator   = 5;
        denominator = 0;

        // output was: The answer is: 2 and Done.

        // error: java.lang.ArithmeticException: / by zero

        // why runtime: compiler only checks syntax, not values

        // empty catch block: no error, java allows it

        try
        {
            ratio = numerator / denominator;
            System.out.println("The answer is: " + ratio);
        }
        catch (ArithmeticException ae)
        {
            // output: Divide by 0.
            System.out.println("Divide by 0.");

            // output with printstacktrace:
            // Divide by 0.
            // java.lang.ArithmeticException: / by zero
            // app still worked ok
            ae.printStackTrace();
        }

        System.out.println("Done."); // Don't move this line
    }
}
