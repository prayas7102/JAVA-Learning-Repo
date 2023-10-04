// Implement a doubly linked list with functions insert, delete and print and 
// find whether a given number is there or not. [Doubly LL] 

// # input: DLL 1<->2<->3<->4, x=4
// # output: “YES”

// # input: DLL 1<->2<->3<->4, x=5
// # output: “NO”

public class Main {
    static Node head = null;

    static void DeleteNode(Node nodetoBeDeleted) {
        if (nodetoBeDeleted == head) {
            head = nodetoBeDeleted.next;
            return;
        }
        if (nodetoBeDeleted == null) {
            Node del = nodetoBeDeleted.prev;
            del.next = null;
            return;
        }
        System.out.println(nodetoBeDeleted.prev);
        Node del = nodetoBeDeleted.prev;
        System.out.println(del.data);
        del.next = nodetoBeDeleted.next;
    }

    static void InsertNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev=newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    static void PrintList() {
        Node NewHead = head;
        System.out.println("Print linked list");
        while (NewHead != null) {
            System.out.print(NewHead.data + " ");
            NewHead = NewHead.next;
        }
    }

     int FindNode(int val) {
        int i = 1;
        Node NewHead = head;
        boolean found = false;
        while (NewHead != null) {
            if (NewHead.data == val) {
                found = true;
                break;
            }
            i++;
            NewHead = NewHead.next;
        }
        if (found)
            return i;
        return -1;
    }

    public static void main(String[] args) {
        InsertNode(2);
        InsertNode(9);
        InsertNode(5);
        InsertNode(8);
        PrintList();
        System.out.print("\n");
        System.out.println("Node numbered 5 is at position: " + FindNode(5));
        DeleteNode(head.next.next); // 9 numbered node
        PrintList();
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}