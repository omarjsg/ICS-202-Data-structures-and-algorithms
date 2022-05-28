import java.util.NoSuchElementException;

public class BinaryTreeDriver {
    public static void main(String args[]) {
        try {
            BinaryTree<Character> bTree = new BinaryTree<>();
            bTree.insert('D');
            bTree.insert('B');
            bTree.insert('F');
            bTree.insert('A');
            bTree.insert('C');
            bTree.insert('H');
            System.out.println(bTree.getPath('C'));
            System.out.println(bTree.getRightLeafCount());
            bTree.printTree();
            System.out.println(bTree.rangeCounter('A', 'D'));
            bTree.inorderTraversal();
            System.out.println("The successor of A is " + bTree.successor('A'));
            System.out.println("The predecessor of D is " + bTree.predecessor('D'));
            System.out.println("The successor of H is " + bTree.successor('H'));
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}