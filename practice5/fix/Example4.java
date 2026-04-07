import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
        // StringTokenizer splits string into parts by delimiter
        // example: new StringTokenizer("hello world", " ", false) -> "hello", "world"

        // 3 parameters: string, delimiters, returnDelims(true/false)
        // example: new StringTokenizer("5.3+9.2", "+", true) -> "5.3", "+", "9.2"

        // input 5.3+9.2 -> Result: 14.5

        // input 5.3+ -> Invalid syntax
        // NoSuchElementException, no third token

        // input 5.3+a -> One or more operands is not a number
        // NumberFormatException, parseDouble("a") fails

        Scanner in = new Scanner(System.in);

        // added loop to handle multiple expressions
        while (in.hasNextLine())
        {
            String line = in.nextLine().trim();
            if (line.isEmpty()) break;

            // added -, *, / to delimiters
            StringTokenizer tokenizer = new StringTokenizer(line, "+-*/", true);

            try
            {
                String leftString  = tokenizer.nextToken();
                String operator    = tokenizer.nextToken();
                String rightString = tokenizer.nextToken();

                double leftOperand, rightOperand, result;

                // nested try-catch to know which operand is wrong
                try
                {
                    leftOperand = Double.parseDouble(leftString);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Left operand is not a number: " + leftString);
                    continue;
                }

                try
                {
                    rightOperand = Double.parseDouble(rightString);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Right operand is not a number: " + rightString);
                    continue;
                }

                if (operator.equals("+"))
                    result = leftOperand + rightOperand;
                else if (operator.equals("-"))
                    result = leftOperand - rightOperand;
                else if (operator.equals("*"))
                    result = leftOperand * rightOperand;
                else if (operator.equals("/"))
                {
                    if (rightOperand == 0)
                    {
                        System.out.println("Division by zero");
                        continue;
                    }
                    result = leftOperand / rightOperand;
                }
                else
                {
                    System.out.println("Unknown operator: " + operator);
                    continue;
                }

                System.out.println("Result: " + result);
            }
            catch (NoSuchElementException nsee)
            {
                System.out.println("Invalid syntax");
            }
        }
    }
}
