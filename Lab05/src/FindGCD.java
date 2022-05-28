import java.util.InputMismatchException;
import java.util.Scanner;

public class FindGCD {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        try {
            System.out.println("Enter the first integer: ");
            int n1 = kb.nextInt();
            System.out.println("Enter the second integer: ");
            int n2 = kb.nextInt();
            System.out.printf("The G.C.D of %d and %d is %d", n1, n2, GCD(n1, n2));
            kb.close();
        } catch (InputMismatchException ex){
            System.out.println("Error: invalid input.");
        }
    }

    private static int GCD(int n, int m) {
        if(m != 0){
            return GCD(m, n % m);
        } else {
            return n;
        }
    }
}
