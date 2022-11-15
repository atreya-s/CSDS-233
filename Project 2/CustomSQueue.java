/* Question 2.b
 *Custom Class that uses Stack modified to act as queues 
 */
import java.util.*;

public class CustomSQueue{
    /* Creating two stacks that act as primary and secondary stacks, allowing for poll method to be efficient
     */
public static Stack<Integer> stack1= new Stack<Integer>();
public static Stack<Integer> stack2= new Stack<Integer>();

/*
 * Custom Constructor
 */
public CustomSQueue(Stack<Integer> s1, Stack<Integer> s2) {
    CustomSQueue.stack1 = s1;
    CustomSQueue.stack2 = s2;
}
/*
 * add() method from queue documentation
 */
public boolean add(int item) {
        stack1.push(item);
        return true;
    }

/*
 * poll() method from queue documentation
 */
 static int poll() throws IllegalArgumentException{
    if(stack1.isEmpty()){
        throw new IllegalArgumentException("Empty Queue");
    }
    while(!stack1.isEmpty()){
        stack2.push(stack1.pop());
    }
    int pop = stack2.pop();
    while( !stack2.isEmpty()){
        stack1.push(stack2.pop());    
    }
    return pop;
}

/*
 * Main method to test methods
 */
public static void main(String[] args) {
Stack<Integer> s = new Stack<Integer>();
s.push(5);	
s.push(6);
s.push(7);
s.push(8);
CustomSQueue sq1 = new CustomSQueue(stack2, stack1);
sq1.add(5);
sq1.add(6);
sq1.add(7);
sq1.add(8);
System.out.println(CustomSQueue.poll());
System.out.println(CustomSQueue.poll());
System.out.println(CustomSQueue.poll());
System.out.println(CustomSQueue.poll());
System.out.println(CustomSQueue.poll());

}
}

