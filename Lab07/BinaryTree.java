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
      if (isEmpty()) {
         root = new BTNode<>(key);
      } else {
         insert(root, key);
      }
   }

   public BTNode insert(BTNode node, T key) {
      if (node == null)
         return new BTNode(key);
      if (node.data.compareTo(key) > 0)
         node.left = insert(node.left, key);
      else
         node.right = insert(node.right, key);
      return node;
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

   public String getPath(T t1) {
      return root.data == null ? "The tree is empty." : getPath(t1, root);
   }

   private String getPath(T t1, BTNode node) {
      return node == null ? ""
            : node.data.equals(t1) ? "" + node.data
                  : node.data.compareTo(t1) > 0 ? node.data + " " + getPath(t1, node.left)
                        : node.data + " " + getPath(t1, node.right);
   }

   public int getRightLeafCount() {
      int count = 0;
      for (BTNode node = root; node != null; node = node.right) {
         count++;
      }
      return count;
   }

   public int rangeCounter(T t1, T t2) {
      return root == null ? 0 : rangeCounter(t1, t2, root);
   }

   private int rangeCounter(T t1, T t2, BTNode node) {
      if (node == null) {
         return 0;
      } else {
         if (node.right == null && node.left == null) {
            return node.data.compareTo(t1) > 0 && node.data.compareTo(t2) < 0 ? 1 : 0;
         } else {
            return node.data.compareTo(t1) > 0 && node.data.compareTo(t2) < 0
                  ? 1 + rangeCounter(t1, t2, node.left) + rangeCounter(t1, t2, node.right)
                  : rangeCounter(t1, t2, node.left) + rangeCounter(t1, t2, node.right);
         }
      }
   }

   public T successor(T t1) {
      BTNode suc = findSuccessor(root, null, t1);
      if (suc != null) {
         return (T) suc.data;
      } else {
         throw new NoSuchElementException("The successor of node " + t1 + " doesn't exist.");
      }
   }

   private BTNode findSuccessor(BTNode node, BTNode suc, T key) {
      if (node == null) {
         return suc;
      }
      if (node.data == key) {
         if (node.right != null) {
            return minNode(node.right);
         }
      } else if (node.data.compareTo(key) > 0) {
         suc = node;
         return findSuccessor(node.left, suc, key);
      } else {
         return findSuccessor(node.right, suc, key);
      }
      return suc;
   }

   public T predecessor(T t1) {
      BTNode pred = findPredecessor(root, null, t1);
      if (pred != null) {
         return (T) pred.data;
      } else {
         throw new NoSuchElementException("The predecessor of node " + t1 + " doesn't exist.");
      }
   }

   private BTNode findPredecessor(BTNode node, BTNode prec, T key) {
      if (node == null) {
         return prec;
      }
      if (node.data == key) {
         if (node.left != null) {
            return maxNode(node.left);
         }
      } else if (node.data.compareTo(key) > 0) {
         return findPredecessor(node.left, prec, key);
      } else {
         prec = node;
         return findPredecessor(node.right, prec, key);
      }
      return prec;
   }

   private BTNode minNode(BTNode node) {
      return node.left == null ? node : minNode(node.left);
   }

   private BTNode maxNode(BTNode node) {
      return node.right == null ? node : maxNode(node.left);
   }

   public BTNode findNode(BTNode node, T key) {
      if (node.right == null && node.left == null) {
         return node;
      } else {
         return key.equals(node.data) ? node
               : node.data.compareTo(key) > 0 ? findNode(node.left, key) : findNode(node.right, key);
      }
   }

}