import java.util.*;

public class UseCase12PalindromeCheckerApp {
    interface PalindromeStrategy {
        boolean check(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Stack<Character> stack = new Stack<>();
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }
            for (char ch : input.toCharArray()) {
                if (ch != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }
    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char ch : input.toCharArray()) {
                deque.add(ch);
            }
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }
    static class PalindromeChecker {
        public boolean checkPalindrome(String input, PalindromeStrategy strategy) {
            return strategy.check(input);
        }
    }

    public static void main(String[] args) {

        String input = "madam";

        PalindromeChecker checker = new PalindromeChecker();

        // Create both strategies
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        // Run Stack Strategy
        boolean result1 = checker.checkPalindrome(input, stackStrategy);
        System.out.println("Using StackStrategy:");
        printResult(input, result1);

        // Run Deque Strategy
        boolean result2 = checker.checkPalindrome(input, dequeStrategy);
        System.out.println("\nUsing DequeStrategy:");
        printResult(input, result2);
    }

    // Helper method
    public static void printResult(String input, boolean result) {
        if (result) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}