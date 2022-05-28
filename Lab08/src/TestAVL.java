import java.io.*;
import java.util.*;

public class TestAVL {
   public static void main(String[] args) throws IOException {
      System.out.println("Exercise 2");
      int[] values = { 8, 14, 12, 18, 23, 20, 15, 13, 7, 16 };
      AVLTree<Integer> integers = new AVLTree<>();
      for (int v : values) {
         integers.insertAVL(v);
      }
      System.out.print("Breadth first traversal: ");
      integers.breadthFirst();
      System.out.println("\nYou are about to delete 3 elements from the tree.");
      Scanner scanner = new Scanner(System.in);
      for (int index = 1; index <= 3; index++) {
         System.out.printf("Kindly enter %d# element you want to delete: ", index);
         int toDelete = scanner.nextInt();
         integers.deleteAVL(toDelete);
      }
      System.out.print("Breadth first traversal: ");
      integers.breadthFirst();
      scanner.close();
      System.out.println("\nExercise 3");
      FileInputStream instream = new FileInputStream("sampletextfile.txt");
      Scanner scanner2 = new Scanner(instream);
      AVLTree<String> strings = new AVLTree<>();
      while (scanner2.hasNext()) {
         String str = scanner2.next();
         if (!str.equals(strings.search(str))) {
            strings.insertAVL(str);
         }
      }
      scanner2.close();
      instream.close();
      strings.inorder();
   }
}