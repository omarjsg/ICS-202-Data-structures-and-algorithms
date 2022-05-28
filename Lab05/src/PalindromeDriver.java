import java.util.InputMismatchException;
import java.util.Scanner;

public class PalindromeDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a String: ");
            String s = scanner.nextLine();
            SLL<Character> str = new SLL<>();
            for (int index = 0; index < s.length(); index++) {
                str.addToTail(s.charAt(index));
            }
            if (findPalindrome(str)) {
                System.out.println("The String \"" + s + "\" is a palindrome.");
            } else {
                System.out.println("The String \"" + s + "\" is not a palindrome.");
            }
            scanner.close();
        }catch (InputMismatchException ex){
            System.out.println("Error: invalid input.");
        }

    }

    private static boolean findPalindrome(SLL<Character> str) {
        if(str.head == str.tail || str.isEmpty()){
            return true;
        } else {
            if(str.head.info.equals(str.tail.info)){
                str.deleteFromHead();
                str.deleteFromTail();
                return findPalindrome(str);
            } else {
                return false;
            }
        }
    }
}
