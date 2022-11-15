/* Assigment 2, CSDS 233 
 * Author: Atreya Sridharan
 * I want to thank my TA's: Gengyu Liu and Wenbiao Li, along with Roshan Kern for helping me with the ideas
 * Documentations used: Java Oracle Docs, Lecture Slides
 */

 /*
  * Creating Custom LinkedList Class that allows for LinkedList to be reversed
  */
public class Reverse{

    /*
     * Creating Node class, with objects required for my methods to run
     * Constructor to allow user to determine input
     */
    public static class Node{
        int input;
        Node next;
        public Node(int input){
            this.input= input;
        }
    }
    Node head;

    /*
     * Add Node method, allowing node to be added starting from the head
     */
    public void addNode(int input){
        Node newNode = new Node(input);
        if(head  == null){
          head = newNode;
          return;
        }
        Node tempNode = head;
        while(tempNode.next != null){
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;

    }
    /*
     * Reverse Method that allows LinkedList to be reversed
     */
    public void reverseList(){
        Node point = head;
        Node prev = null;
        Node curr = null;
        while(point != null){
            curr = point;
            point = point.next;
            curr.next = prev;
            prev = curr;
            head = curr;
        }

    }
/*
 * As the return type of the methods are void, a print method is required to print the list
 */
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.input);
            temp = temp.next;
        }
    }
/*
 * Main Method to test the methods of the Reverse Class
 */
    public static void main(String[] args) {
        Reverse r1 = new Reverse();
        r1.addNode(1);
        r1.addNode(2);
        r1.addNode(3);
        r1.printList();   
        r1.reverseList();
        r1.printList();
    }
 

}