package ds;

import java.lang.String;

public class LinkedList {

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data  = data;
    }
  };

  private Node head;

  public void add(Node newNode) {
    if(head == null) {
      head = newNode;
      return;
    }

    Node temp = head;
    while(temp.next != null) {
      temp = temp.next;
    }

    temp.next = newNode;
  }

  public void insertAt(int position, Node newNode) {
    if(head == null) {
      if(position != 0) {
        throw new IllegalArgumentException("Invalid index");
      } else {
        head = newNode;
        return;
      }
    } else if (position == 0) {
      // insertion at begining
      Node temp = head;
      head = newNode;
      head.next = temp;
    }

    Node temp = head;
    int index = 0;
    do {
      if(index == (position-1)) {
          newNode.next = temp.next;
          temp.next = newNode;
          return;
      }

      index++;
      temp = temp.next;

    } while (temp != null);
  }

  public void deleteAt(int index) {
    // delete head
    if(index == 0) {
      head = head.next;
    } else {
      Node temp = head;
      int position = 0;
      do {
        if (position == (index - 1)) {
          temp.next = temp.next.next;
        }

        temp = temp.next;
        position ++;
      } while (temp != null);
    }
  }

  public void prettyPrint() {
    if (head == null) {
      System.out.println("Linked list is empty");
    } else {
      Node temp = head;
      do {
        System.out.println("" + temp.data);
        temp = temp.next;
      } while(temp != null);
    }
  }

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    // list.add(new Node(1));
    // list.add(new Node(3));
    list.insertAt(0, new Node(1));
    list.insertAt(0, new Node(-1));
    list.insertAt(1, new Node(0));
    list.add(new Node(2));

    list.deleteAt(1);
    list.deleteAt(2);
    // -1021
    list.prettyPrint();
  }
}
