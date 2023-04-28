package Linkedlist;

public class LinkedList {
          public static class Node {
                    int data;
                    Node next;

                    public Node(int data) {
                              this.data = data;
                              this.next = null;
                    }
          }

          public static Node head;
          public static Node tail;
          public int size;

          // no need of static keyword bcoz we call function from an object in main()

          public void addFirst(int data) { // O(1)
                    // step-1 create new node
                    Node newNode = new Node(data);
                    size++;
                    if (head == null) {
                              // if no linked list
                              head = tail = newNode;
                              return;
                    }
                    // step-2 newNode = next
                    newNode.next = head;
                    // step-3 head=newNode
                    head = newNode;
          }

          public void addLast(int data) { // O(1)
                    // step-1 create new node
                    Node newNode = new Node(data);
                    size++;
                    if (head == null) {
                              head = tail = newNode;
                    }
                    // step-2 make tail pointing to new node
                    tail.next = newNode;
                    // step-3 make last node as tail
                    tail = newNode;
          }

          public void print() { // O(n)
                    if (head == null) {
                              System.out.println("Linked List is Empty");
                              return;
                    }
                    Node temp = head;
                    while (temp != null) {
                              System.out.print(temp.data + "->");
                              temp = temp.next;
                    }
                    System.out.println("null");
          }

          public void addidx(int index, int data) { // O(n)
                    if (index == 0) {
                              addFirst(data);
                              return;
                    }
                    Node newNode = new Node(data);
                    size++;
                    int i = 0;
                    Node temp = head;
                    // move to i-th node
                    while (i < index - 1) {
                              temp = temp.next;
                              i++;
                    }
                    newNode.next = temp.next;
                    temp.next = newNode;
          }

          public void deleteFirst() { // O(1)
                    if (size == 0) {
                              System.out.println("Linked List is Empty");
                              return;
                    } else if (size == 1) {
                              head = tail = null;
                              size = 0;
                    }
                    size--;
                    head = head.next;
          }

          public void deleteLast() { // O(n)
                    if (size == 0) {
                              System.out.println("Linked List is Empty");
                              return;
                    } else if (size == 1) {
                              head = tail = null;
                              size = 0;
                    }
                    int c = 0;
                    Node prev = head;
                    while (c < size - 2) {
                              prev = prev.next;
                              c++;
                    }
                    prev.next = null;
                    tail = prev;
                    size--;
          }

          public int search(int key) { // O(n)
                    int c = 0;
                    Node temp = head;
                    while (temp != null) {
                              if (temp.data == key) {
                                        return c;
                              }
                              temp = temp.next;
                              c++;
                    }
                    return -1;
          }

          public int helper(Node head, int key) {
                    if (head == null) {
                              return -1;
                    }
                    if (head.data == key) {
                              return 0;
                    }
                    int idx = helper(head.next, key);
                    if (idx == -1) {
                              return -1;
                    }
                    return idx + 1;
          }

          public int recsearch(int key) { // O(n)
                    return helper(head, key);
          }

          public void reverse() { // O(n)
                    Node prev = null;
                    Node curr = tail = head;
                    Node next;
                    while (curr != null) {
                              next = curr.next;
                              curr.next = prev;
                              prev = curr;
                              curr = next;
                    }
                    head = prev;
          }

          public static void main(String[] args) {
                    LinkedList ll = new LinkedList();
                    ll.print();
                    ll.addFirst(2);
                    ll.addFirst(1);
                    ll.addLast(4);
                    ll.addLast(5);
                    ll.print();
                    ll.addidx(2, 3);// 1->2->3->4->5
                    ll.print();
                    // ll.reverse();
                    // ll.print();
                    System.out.println(ll.size);
                    System.out.println(ll.search(3));
                    System.out.println(ll.recsearch(3));
                    System.out.println(ll.recsearch(5));
                    ll.print();
                    ll.deleteFirst();
                    ll.print();
                    ll.deleteLast();
                    ll.print();

          }
}
