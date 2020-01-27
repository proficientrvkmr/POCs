package com.java.practice.ds;

import lombok.ToString;

public class RK_LinkedListImpl {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.printList();

        System.out.println("Reverse of List: ");
        linkedList.reverseList();
        linkedList.printList();

        System.out.println("Remove node from List: ");
        linkedList.removeNode(5);
        linkedList.removeNode(4);
        linkedList.printList();

        System.out.println("Add new nodes to List: ");
        linkedList.reverseList();
        linkedList.addNode(2);
        linkedList.addNode(1);
        linkedList.printList();

        System.out.println("Middle Node: ");
        System.out.println(linkedList.findMiddleNode().data);

        System.out.println("Check, Is list palindrome ? ");
        System.out.println(linkedList.isPalindrome() ? "Yes" : "No");

    }

    static class CustomLinkedList {
        Node head;
        Node left;

        public void addNode(int num) {
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                return;
            }

            Node prev = head;
            Node current = head;
            while (current != null) {
                prev = current;
                current = current.next;
            }
            prev.next = newNode;

        }

        public void removeNode(int num) {
            Node current = head;
            Node prev = head;

            if (head.data == num) {
                head = head.next;
                return;
            }

            while (current != null && current.data != num) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
        }

        public void printList() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data);
                node = node.next;

                if (node != null)
                    System.out.print(" -> ");
            }
            System.out.println();
        }

        public void reverseList() {
            Node current = head;
            Node prev = null, next;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            head = prev;
        }

        public boolean isPalindrome() {
//            return checkPalindrome(left, head);
            return isPalindromeUtil(head);
        }

        private boolean checkPalindrome(Node left, Node current) {

            Node right = current;
            while (right != null && right.next != null) {
                right = right.next;
            }

            if (left.data == right.data)
                return checkPalindrome(left.next, current.next);
            else
                return false;
        }

        public boolean isPalindromeUtil(Node right) {
            left = head;

            /* stop recursion when right becomes NULL */
            if (right == null)
                return true;

        /* If sub-list is not palindrome then no need to
           check for current left and right, return false */
            boolean isp = isPalindromeUtil(right.next);
            if (isp == false)
                return false;

            /* Check values at current left and right */
            boolean isp1 = (right.data == (left).data);

            /* Move left to next node */
            left = left.next;

            return isp1;
        }

        // This function will find middle element in linkedlist
        public Node findMiddleNode() {
            Node slowPointer, fastPointer;
            slowPointer = fastPointer = head;

            while (fastPointer != null) {
                fastPointer = fastPointer.next;
                if (fastPointer != null && fastPointer.next != null) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
            }

            return slowPointer;

        }

        @ToString
        class Node {
            int data;
            Node next;

            Node(int value) {
                this.data = value;
                next = null;
            }
        }
    }

}
