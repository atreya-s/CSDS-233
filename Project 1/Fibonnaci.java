/* Coding Part 1 CSDS 233 Project 1
Author: Atreya Sridharan (axs2220)
 * Resources: CSDS 233 Lecture Slides
 * Collaboraters: I want to thank Roshan Kern, Gengyu Liu and Wenbiao Li for their inputs and help with the ideas
 */ 
public class Fibonnaci{
    /** 
     * Fibonacci Iterative method
     * @param n Integer values
     * @return Integer value corresponding to fibonacci number
     * Example n = 5, returns 5th fibonacci number
     * runtime: O(n) as only one for-loop is used
     */
    public int fibonacciIterative(int n){
        if(n <= 0 ){
            throw new IllegalArgumentException();
        }
         int prevNumber = 0;
         int nextNumber = 1;
         int Nth; 
         for(int i = 2; i < n; i++){
             Nth = prevNumber + nextNumber;
            prevNumber = nextNumber;
            nextNumber = Nth; 

         }
        return nextNumber; 
    }
      /**
       * Fibonacci Recursive method
       * @param n Integer values
       * @return Integer value corresponding to fibonacci number
       * Runtime corresponds to O(2^n)
       */

    public int fibonacciRecursive(int n){
        if (n == 1){
            return 0; 
        }
        if (n == 2){
            return 1;
        }
        else{
            return fibonacciRecursive(n - 1) +fibonacciRecursive(n - 2);
        }
    }
     /**
      * Main Method for class
      * Recursive Fibonacci is exponential time
      * Iterative Fibonacci is linear time, hence it is called
      */
    public static void main(String[] args){
     Fibonnaci f1 = new Fibonnaci();
     System.out.println(f1.fibonacciIterative(4));
    }

}