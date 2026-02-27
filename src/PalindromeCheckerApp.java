import java.util.Scanner;
import java.util.Stack;

// Palindrome Service Class
class PalindromeChecker {
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }
        for (int i = 0; i < normalized.length(); i++) {
            char popped = stack.pop();
            if (normalized.charAt(i) != popped) {
                return false;
            }
        }

        return true;
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        sc.close();
    }
}