import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize once
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\n--- Performance Comparison ---");

        // 1️⃣ Two Pointer Approach
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(normalized);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // 2️⃣ Stack Approach
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(normalized);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // 3️⃣ Deque Approach
        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(normalized);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display results
        System.out.println("Two Pointer Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack Result      : " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Deque Result      : " + result3 + " | Time: " + time3 + " ns");

        sc.close();
    }

    // Two Pointer Method (Most Efficient)
    public static boolean twoPointerCheck(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack Method
    public static boolean stackCheck(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque Method
    public static boolean dequeCheck(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}