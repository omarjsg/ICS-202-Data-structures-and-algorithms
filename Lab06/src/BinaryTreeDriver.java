import java.util.NoSuchElementException;

public class BinaryTreeDriver {
    public static void main(String args[]) {
        BinaryTree<Integer> bTree = new BinaryTree<>();
        try {
            bTree.insert(1);
            bTree.insert(2);
            bTree.insert(3);
            bTree.insert(4);
            bTree.insert(5);
            bTree.insert(6);
            bTree.insert(7);
            bTree.insert(8);
            bTree.insert(9);
            bTree.insert(12);
            bTree.deleteByCopying(6);
            bTree.deleteByCopying(7);
            bTree.deleteByCopying(8);
            bTree.deleteByCopying(9);
            System.out.println("The number of nodes in the tree is " + bTree.count());
            System.out.println("The number of leaf nodes in the tree is " + bTree.countLeaves());
            System.out.println("he level of node with key 4 is " + bTree.getLevel(4));
            System.out.println("Trying to find the level of node with key 60 ...");
            System.out.println(bTree.getLevel(60));
        } catch (NoSuchElementException ex) {
            System.out.println(ex);
        }
        System.out.println("Preorder Traversal is:");
        bTree.preorderTraversal();
        System.out.println("\nInorder Traversal is:");
        bTree.inorderTraversal();
        System.out.println("\nBefore deleting key 3,  level order traversal of binary tree is: ");
        bTree.levelOrderTraversal();
        System.out.println("\nThe tree is: ");
        bTree.printTree();
        bTree.deleteByCopying(3);
        System.out.println("After deleting key 3, level order traversal of binary tree is: ");
        bTree.levelOrderTraversal();
        System.out.println("\nThe tree is: ");
        bTree.printTree();
    }
}