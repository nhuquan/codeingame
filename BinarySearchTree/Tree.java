import java.util.*;

class Tree {
  class Node {
    int value;
    Node left;
    Node right;
    Node(int val) {
      this.value = val;
      this.left = this.right = null;
    }
  }

  Node root;

  Tree() {
    this.root = null;
  }

  void insert(int n) {
    root = insertRec(root,n);
  }

  Node insertRec(Node root, int key) {
      if (root == null) {
        root = new Node(key);
        return root;
      }
      if (root.value > key)
        root.left = insertRec(root.left,key);
      else if (root.value < key)
        root.right = insertRec(root.right, key);
      return  root;
  }

  void printInorder() {
    printInorder(root);
  }
  void printInorder(Node root) {
    if (root != null) {
      printInorder(root.left);
      System.out.println(root.value);
      printInorder(root.right);
    }
  }
  Node find(int n) {
    return find(root, n);
  }
  Node find(Node node, int n) {
      if (node == null)
        return null;
      if (node.value == n)
        return node;
      if (node.value > n)
        return find(node.left, n);
      if (node.value < n)
        return find(node.right, n);

      return null;
  }

  Node findIterative(int n) {
    return findIterative(root, n);
  }

  Node findIterative(Node node, int n) {
      Node x = node;
      while (x != null) {
        if (x.value == n)
          return x;
        if (x.value < n ) {
          if (x.right != null)
            x = x.right;
          else return null;
        }
        if (x.value > n) {
          if (x.left != null)
            x = x.left;
          else return null;
        }
      }
      return null;
  }
  public static void main(String[] args) {
      Tree t = new Tree();

      t.insert(50);
      t.insert(30);
      t.insert(20);
      t.insert(40);
      t.insert(70);
      t.insert(80);
      t.printInorder();

      int n = 90;
      Node result = t.findIterative(n);
      if (result == null)
        System.out.println("not found");
      else  System.out.println("found node "  + result.value);
  }

}
