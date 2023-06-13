public class CircularLL {
    static boolean CheckLoop(Node head) {
        Node iterator = head;
        while (iterator != null && iterator != head) {
            iterator = iterator.ptr;
        }
        return iterator == head;
    }

    static int LengthOfLinkedList(Node head) {
        if (head == null)
            return 0;
        if (head.ptr == null)
            return 1;
        Node iterator = head.ptr;
        int len = 1;
        while (iterator != head) {
            len++;
            iterator = iterator.ptr;
        }
        return len;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(2);
        Node four = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = one;
        if (CheckLoop(one)) {
            System.out.println("YES " + LengthOfLinkedList(one));
        } else
            System.out.println("NO -1");
    }
}

class Node {
    int data;
    Node ptr;

    Node(int val) {
        data = val;
        ptr = null;
    }
}