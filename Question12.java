public class BinaryTree {
    static void preorder(Tree root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Tree root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void inorder(Tree root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree node1 = new Tree(2);
        Tree node2 = new Tree(3);
        Tree node3 = new Tree(4);
        Tree node4 = new Tree(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.print("Preorder ");
        preorder(root);
        System.out.print("\n");

        System.out.print("Inorder ");
        inorder(root);
        System.out.print("\n");

        System.out.print("Postorder ");
        postorder(root);
    }
}

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int val) {
        data = val;
        left = null;
        right = null;
    }
}