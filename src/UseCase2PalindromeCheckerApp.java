public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "madam";
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        if (input.equals(reversed)) {
            System.out.println("The given string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The given string \"" + input + "\" is NOT a Palindrome.");
        }
    }
}