import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<? super T>> {
   BTNode root;

   public BinaryTree() {
      root = null;
   }

   public void purge() {
      root = null;
   }

   public boolean isEmpty() {
      return root == null;
   }

   public void insert(T key) {
      if (root == null) {
         root = new BTNode(key);
         return;
      }
      BTNode temp;
      Queue<BTNode> q = new LinkedList<BTNode>();
      q.add(root);

      // Do level order traversal until we find the first empty left or right child.
      while (!q.isEmpty()) {
         temp = q.poll();

         if (temp.left == null) {
            temp.left = new BTNode(key);
            break;
         } else
            q.add(temp.left);

         if (temp.right == null) {
            temp.right = new BTNode(key);
            break;
         } else
            q.add(temp.right);
      }
   }

   public void insertRight(T key, BTNode node) {
      if (node == null) {
         throw new IllegalArgumentException("Node entered is not found.");
      } else {
         node.right = new BTNode(key);
      }
   }

   public void insertLeft(T key, BTNode node) {
      if (node == null) {
         throw new IllegalArgumentException("Node entered is not found.");
      } else {
         node.left = new BTNode(key);
      }
   }

   public void deleteByCopying(T data) {
      if (root == null)
         throw new UnsupportedOperationException("Tree is empty!");
      else if (root.left == null && root.right == null) {
         if (root.data.equals(data))
            root = null;
         else
            throw new NoSuchElementException(data + " not in the tree.");
         return;
      }

      Queue<BTNode> queue = new LinkedList<BTNode>();
      queue.add(root);
      BTNode keyNode = null;
      BTNode currentNode = null;
      BTNode parentNode = root;
      boolean found = false;
      while (!queue.isEmpty()) {
         currentNode = queue.poll();

         if (currentNode.data.equals(data)) {
            if (!found) {
               keyNode = currentNode;
               found = true;
            }
         }

         if (currentNode.left != null) {
            queue.add(currentNode.left);
            parentNode = currentNode;
         }
         if (currentNode.right != null) {
            queue.add(currentNode.right);
            parentNode = currentNode;
         }
      }

      if (!found)
         throw new NoSuchElementException(data + " not in tree.");

      while (!queue.isEmpty()) {
         currentNode = queue.poll();
         System.out.print(currentNode.data + "  ");
         if (currentNode.left != null) {
            queue.add(currentNode.left);
            parentNode = currentNode;
         }
         if (currentNode.right != null) {
            queue.add(currentNode.right);
            parentNode = currentNode;
         }
      }

      keyNode.data = currentNode.data;
      if (parentNode.left == currentNode)
         parentNode.left = null;
      else if (parentNode.right == currentNode)
         parentNode.right = null;
   }

   public void levelOrderTraversal() { // BreadthFirstTraversal
      levelOrderTraversal(root);
   }

   private void levelOrderTraversal(BTNode root) {
      if (root == null)
         return;
      Queue<BTNode> queue = new LinkedList<BTNode>();
      BTNode node = root;
      queue.add(node);
      while (!queue.isEmpty()) {
         node = queue.poll();
         System.out.print(node.data + "  ");
         if (node.left != null)
            queue.add(node.left);
         if (node.right != null)
            queue.add(node.right);
      }
   }

   public void inorderTraversal() {
      inorderTraversal(root);
   }

   protected void inorderTraversal(BTNode node) {
      if (node == null)
         return;

      inorderTraversal(node.left);
      System.out.print(node.data + " ");
      inorderTraversal(node.right);
   }

   public void postorderTraversal() {
      postorderTraversal(root);
   }

   private void postorderTraversal(BTNode node) {
      if (node == null)
         return;

      postorderTraversal(node.left);
      postorderTraversal(node.right);

      System.out.print(node.data + " ");
   }

   public void preorderTraversal() {
      preorderTraversal(root);
   }

   private void preorderTraversal(BTNode node) {
      if (node == null)
         return;

      System.out.print(node.data + " ");

      preorderTraversal(node.left);
      preorderTraversal(node.right);
   }

   public boolean search(T key) {
      if (root == null)
         return false;
      Queue<BTNode> queue = new LinkedList<BTNode>();
      BTNode node = root;
      queue.add(node);
      while (!queue.isEmpty()) {
         node = queue.poll();
         if (key.equals(node.data))
            return true;
         if (node.left != null)
            queue.add(node.left);
         if (node.right != null)
            queue.add(node.right);
      }
      return false;
   }

   public void printTree() {
      printTree(root, "", true);
   }

   // Print the tree
   private void printTree(BTNode currPtr, String indent, boolean last) {
      if (currPtr != null) {
         System.out.print(indent);
         if (last) {
            System.out.print("R----");
            indent += "   ";
         } else {
            System.out.print("L----");
            indent += "|  ";
         }
         System.out.println(currPtr.data);
         printTree(currPtr.left, indent, false);
         printTree(currPtr.right, indent, true);
      }
   }

   public boolean isLeaf(BTNode node) {
      return node == null ? false : node.right == null && node.left == null ? true : false;
   }

   public int count() {
      return root == null ? 0 : count(root);
   }

   private int count(BTNode node) {
      return node == null ? 0 : 1 + count(node.right) + count(node.left);
   }

   public int countLeaves() {
      return root == null ? 0 : countLeaves(root);
   }

   private int countLeaves(BTNode node) {
      return isLeaf(node) ? 1 : node == null ? 0 : countLeaves(node.right) + countLeaves(node.left);
   }

   public int getLevel(T data) throws NoSuchElementException {
      if (root == null) {
         throw new IllegalArgumentException("Binary tree is empty.");
      } else if (search(data)) {
         return getLevel(data, root, 0);
      } else {
         throw new NoSuchElementException("Key not in tree");
      }
   }

   private int getLevel(T data, BTNode node, int level) {
      if (node == null) {
         return 0;
      } else if (isLeaf(node)) {
         return node.data.equals(data) ? level : 0;
      } else {
         return node.data.equals(data) ? level
               : getLevel(data, node.right, level + 1) + getLevel(data, node.left, level + 1);
      }
   }
}