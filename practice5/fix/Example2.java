public class Example2
{
    public static void main(String[] args)
    {
        // error without init: variable i might not have been initialized

        // error when i init inside try: same error
        // because catch is different block, cant see i from try

        // why this error: try and catch are separate scopes
        // compiler not sure i was set before exception happened

        // output when try wraps whole loop:
        // 100/10=10
        // Couldnt calculate 10/0
        // stops here, other divisions not tried
        // because exception exits whole try block

        // fix: move try-catch inside for loop
        int i;
        int ratio;
        int[] numbers = {100, 10, 0, 5, 2, 8, 0, 30};

        for (i = 0; i < numbers.length - 1; i++)
        {
            try
            {
                ratio = numbers[i] / numbers[i + 1];
                System.out.println(numbers[i] + "/" + numbers[i + 1] + "=" + ratio);
            }
            catch (ArithmeticException ae)
            {
                System.out.println("Couldn't calculate " + numbers[i] + "/" + numbers[i + 1]);
            }
        }

        // now each division is separate, loop dont stop on error
    }
}
