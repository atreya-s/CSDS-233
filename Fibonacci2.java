import java.util.*;
/* Coding Part 2 CSDS 233 Project 1
Author: Atreya Sridharan (axs2220)
 * Resources: CSDS 233 Lecture Slides, Java (Array) Documentation
 * Collaboraters: I want to thank Roshan Kern, Gengyu Liu and Wenbiao Li for their inputs and help with the ideas
 */ 
public class Fibonacci2 {
   static int [] nums = {0, 1, 1, 2, 3, 5, 8, 13, 21} ;
   public static int[] addFibonacci(int item){
      nums[0] = 0;
      nums[1] = 1;
      int i;
      int [] temp = new int[nums.length+1];
      for(i = 0; i < nums.length; i++){
         temp[i] = nums[i];
         temp[i+1] = item; 

      }
      return temp;
      
   }

   public static int[] removeFibonacci(int item){
    int [] temp = new int[nums.length - 1];  
    for (int i = 0, j =0; i < nums.length; i++){
      if(nums[i] == item){
         continue;
      }
      else{
         temp[j++] = nums[i];
      }
    }
    return temp;
    }

    public static boolean ifContains(int item){
      for(int i = 0; i < nums.length; i++){
         if(nums[i] == item){
            return true; 
         }
      }
        return false; 
    }

    public static int grab(){ 
      int rand = new Random().nextInt(nums.length) ; 
      return nums[rand] ; 
    }

    public static int numItems(){
      int [] temp = new int[nums.length];
      int i;
      int j = 0; 
      for(i = 0; i < nums.length - 1;i++){
         if(nums[i] != nums[i + 1]){
          temp[j++] = nums[i] ; 
         }
      }
      temp[j++] = nums[i];
      for(i = 0; i < nums.length; i++){
         nums[i] = temp[i] ;
      }
      return j;
    }

    public static void main(String[] args) {
      System.out.println(Arrays.toString(addFibonacci(34))); 
      System.out.println(Arrays.toString(removeFibonacci(5)));
      System.out.println(ifContains(6));
      System.out.println(grab());
      System.out.println(((numItems())));
    }
        
    }
   

