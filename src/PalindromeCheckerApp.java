import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        boolean isPalindrome = true;
        for (int i = 0; i < inputString.length(); i++) {

            char poppedChar = stack.pop();

            if (inputString.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }
        sc.close();
    }
}