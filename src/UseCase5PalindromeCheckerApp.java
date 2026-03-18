import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            char popped = stack.pop();
            if (input.charAt(i) != popped) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}