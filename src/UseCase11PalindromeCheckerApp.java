public class UseCase11PalindromeCheckerApp {
    static class PalindromeChecker {
        public boolean checkPalindrome(String input) {
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
    public static void main(String[] args) {
        String input = "madam";
        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);
        if (result) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}