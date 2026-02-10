import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine();
        
        if (isPalindrome(str)) {
            System.out.println("\"" + str + "\" is a palindrome");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome");
        }
        
        in.close();
    }
    
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
