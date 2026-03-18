import java.util.*;

public class UseCase13PalindromeCheckerApp {
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
    static class TwoPointerStrategy implements PalindromeStrategy {
        public boolean check(String input) {
            int start = 0;
            int end = input.length() - 1;
            while (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
    public static void testPerformance(String name, PalindromeStrategy strategy, String input) {
        long startTime = System.nanoTime();
        boolean result = strategy.check(input);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(name + " Result: " + result);
        System.out.println(name + " Time: " + duration + " ns");
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Palindrome Performance Comparison\n");
        testPerformance("Stack Strategy", new StackStrategy(), input);
        testPerformance("Deque Strategy", new DequeStrategy(), input);
        testPerformance("Two Pointer Strategy", new TwoPointerStrategy(), input);
    }
}