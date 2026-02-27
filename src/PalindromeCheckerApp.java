import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty()) {

            char fromStack = stack.pop();
            char fromQueue = queue.remove();

            if (fromStack != fromQueue) {
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