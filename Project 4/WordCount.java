/*
 * WordCount class containing the wordCount method
 */
public class WordCount {
    /**
     * Method that takes  a  string  as  an  input  and  prints  out  all  the  words 
       encountered in that input, along with their number of occurrences.
     */
    public static void wordCount(String input, HashTableList words){
        String[] split = input.split("\\P{Alpha}+"); 
        for(int i = 0; i < split.length; i++){ 
           split[i] = split[i].toLowerCase();
           if(words.search(split[i]) == false){
              if(words.reSizecheck() == true){
                 i = 0; 
              }
              words.put(split[i],1);
              words.printTable();
              System.out.println();
           }
      }
     //Main method with test cases, to ensure the chaining is working
     }
     public static void main(String args[]){
        HashTableList words = new HashTableList(5); 
        wordCount("I like chiptole, like not tacobell but chpiotle ", words);    
     }
     

    }

