package module5.dsa2.trees.day37_38.bst;

import java.util.Arrays;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int arr[] = {3,5,8,9,4,6,7,1,2,5};
        System.out.println("Adding these to BST: "+ Arrays.toString(arr));
        BSTNode root = new BSTNode(5);

        for(int num : arr) {
            bst.insert(root, num);
        }
        System.out.println("Printing InOrder Traversal");

        bst.printInorder(root);
        System.out.println();

        int deleteNum = 6;
        System.out.println("Deleting "+deleteNum);
        bst.deleteBST(root, deleteNum);
        System.out.println("Printing InOrder Traversal");

        bst.printInorder(root);
        System.out.println("\nPrinting PreOrder Traversal");

        bst.printPreOrder(root);


    }

    BSTNode deleteBST(BSTNode root, int val) {
        if(root == null) return root;
        if(val < root.val) {
            root.left = deleteBST(root.left, val);
        } else if(val < root.val) {
            root.right = deleteBST(root.right, val);
        } else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left!=null && root.right==null)
                return root.left;
            else if(root.right!=null && root.left==null)
                return root.right;
            else {// both nodes present
                int maxOfLeft = max(root.left);
                root.val = maxOfLeft;
                root.left = deleteBST(root.left, maxOfLeft);
            }
        }
        return root;
    }

    int min(BSTNode root) {
        BSTNode curr = root;
        while(curr.left !=null)
            curr = curr.left;
        return curr.val;
    }

    int max(BSTNode root) {
        BSTNode curr = root;
        while(curr.right !=null)
            curr = curr.right;
        return curr.val;
    }

    static void printInorder(BSTNode root) {
        if(root == null)
            return;
        else {

            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
            //System.out.println();
        }
    }

    void printPreOrder(BSTNode root) {
        if(root == null)
            return;
        else {

            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
            //System.out.println();
        }
    }

    public static BSTNode insert(BSTNode root, int val) {
        if(root == null) {
            root = new BSTNode(val);
            return root;
        } else {
            if(root.val >= val) {
                // add the node on left side
                root.left =  insert(root.left, val);
            } else {
                // ad the node on right side
                root.right = insert(root.right, val);
            }
            return root;
        }
    }


    static class BSTNode {
        int val;
        BSTNode left;
        BSTNode right;

        public BSTNode(int v) {
            this.val = v;
        }
    }

}

