// Check if a linked list is palindrome or not. [Singly LL] 
// # Input: 1->2->3->2->1
// # Output: “YES”

// # input: 5->4->3->2->1
// # Output: “NO” 

import java.util.*;

public class Main {
    static boolean CheckPalindrome(Node head) {
        Node comparator = head, itrlength = head;
        boolean palintrue = true;
        int n = 0, i = 0;

        while (itrlength != null) {
            n++;
            itrlength = itrlength.ptr;
        }
        int[] stack = new int[n];

        while (head != null) {
            stack[i] = head.data;
            i++;
            head = head.ptr;
        }
        i--;
        while (comparator != null) {
            if (stack[i] != comparator.data) {
                palintrue = false;
                break;
            }
            i--;
            comparator = comparator.ptr;
        }
        return palintrue;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(2);
        Node four = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        System.out.println(CheckPalindrome(one));
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