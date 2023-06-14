// // Queue class implementation
// // Given a binary tree, print level order traversal using queue. 
// // Implement your own queue. [Queue] 
// // # input: 1->left 2, 1->right 3, 2->left4, 2->right5, 3->left 6, 3->right7
// // # output:  1 2 3 4 5 6 7

public class LevelOrderTraversalWithArrayQueue {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        System.out.print("Level order traversal: ");
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(Tree root) {
        if (root == null) {
            return;
        }

        Queue queue = new Queue(100);

        // Enqueue the root Tree to initiate the while loop below
        queue.enqueue(root);

        // Level order traversal
        while (!queue.isEmpty()) {
            Tree current = queue.dequeue();
            System.out.print(current.data + " ");

            // Enqueue the left child and right child 
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }
}

// Binary Tree implementation
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

class Queue {
  // queue implemented in form of array of Tree data type
    Tree[] queueArray;
    int front;
    int rear;
    int maxSize;
    int size;

    Queue(int size) {
      // By setting max size we can limit the size of queue
      // the size is adjustable (100 in this case)
        maxSize = size;
        queueArray = new Tree[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(Tree TreeNode) {
        if (size == maxSize) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = TreeNode;
        size++;
    }

    Tree dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }
        Tree TreeNode = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        return TreeNode;
    }

    boolean isEmpty() {
        return (size == 0);
    }
}
