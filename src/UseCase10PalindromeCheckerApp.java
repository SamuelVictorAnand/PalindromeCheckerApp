public class UseCase10PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "Madam";
        input = input.toLowerCase();
        input = input.replaceAll(" ", "");
        int start = 0;
        int end = input.length() - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }
    }
}