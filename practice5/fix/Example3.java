public class Example3
{
    public static void main(String[] args)
    {
        int   i;
        int[] data = {50, 320, 97, 12, 2000};

        // original code used exception to stop loop, thats bad
        // exception is not for flow control

        // fix: just use data.length in loop condition
        // no try-catch needed
        for (i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }
        System.out.println("Done");

        // changed: i < 10 to i < data.length
        // removed try-catch
        // output is same but code is correct now
    }
}
