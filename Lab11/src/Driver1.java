import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Integer choice = 0, n = 0;
        do {
            try {
                System.out.println("Insert the size of the hash table: ");
                n = scanner.nextInt();
                choice = 1;
            } catch (InputMismatchException ex) {
                System.out.println("Error: invalid input please write an integer value for the size of the table.");
                scanner.nextLine();
            }
        } while (choice != 1);
        Hashtable map = new Hashtable(n);
        do {
            try {
                System.out.println("1. Insertion\n2. Deletion\n3. Find\n4. Print\n5. Exit\nEnter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                case 1: {
                    System.out.println("Insert an element to insert it into the hash table: ");
                    int el = scanner.nextInt();
                    boolean inserted = map.insert(el);
                    if (inserted) {
                        System.out.println(el + " has been successfully inserted\n");
                    } else {
                        System.out.println("Could not insert " + el + ".");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Insert the element that will be deleted: ");
                    int el = scanner.nextInt();
                    boolean deleted = map.delete(el);
                    if (deleted) {
                        System.out.println(el + " has been successfully deleted\n");
                    } else {
                        System.out.println("Could not delete " + el + ".");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the element to be searched: ");
                    int el = scanner.nextInt();
                    boolean isPresent = map.find(el);
                    if (isPresent) {
                        System.out.println(el + " is present");
                    } else {
                        System.out.println(el + " is not present");
                    }
                    break;
                }
                case 4: {
                    System.out.println(map.toString());
                    break;
                }
                case 5: {
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice, please select a valid choice.");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Error: invalid input.");
                scanner.nextLine();
            }
        } while (choice != 5);
    }
}