/* Question 2.a
 * Custom Class that allows Queues to act as stacks
 */
import java.util.*;
import java.util.LinkedList;

public class CustomQStack {
    static Queue<Integer> queue1 = new LinkedList<Integer>();
    public int size;

    /*
     * Constructor for the class
     */
    public CustomQStack(Queue<Integer> q1) {
        CustomQStack.queue1 = q1;
        size = q1.size();
    }
/*
 * Method to check for empty queue
 */
    public static boolean isEmpty(){
     if(queue1 == null){
        return true;
     }
     else{
        return false;
     }
    }
/*
 * pop() method which throws error in case the stack is empty
 */
    public int pop() throws IllegalArgumentException{
        if(queue1.isEmpty()){
         throw new IllegalArgumentException("Stack is empty");
        }
            int temp = queue1.remove();
            return temp;

        }
/*
 * push() method which throws error in case the stack is full and cannot take more
 */
    public void push(int num) throws IllegalStateException{
        if(!queue1.isEmpty()){
            throw new IllegalStateException("Full Stack");
        }
       int size = queue1.size();
       int i;
       queue1.add(num);
        for(i = 0; i <= size - 1; i++){
            int temp = queue1.remove();
            queue1.add(temp);
        }
        
    }
/*
 * Main method to test methods in the CustomQStack class
 */
    public static void main(String[] args) {
        CustomQStack qs1 = new CustomQStack(queue1);
        qs1.push(5);
        qs1.push(6);
        qs1.push(7);
        qs1.push(8);
        System.out.println(qs1.pop());

        
    }
}
