/* Assignment 4 CSDS 233 Author: Atreya Sridharan (axs2220)
 * Sources: Lecture slides, Java Oracle Documentation
 * I want to thank my TAs for helping, along with Siddharth Balakrishnan and Donovan Wu for help with ideas to approach the project
 */
import java.util.*;

public class HashTableList  {

// Initializing Variables, creatinng an array list of linkedlist in order to implement seperate chaining easily
private LinkedList<Entry>[] hashTable;
private int tableSize;
// Deciding 0.75 to be the ideal load factor for the table
private double loadFactor = 0.75;

// Initializing Constructor
public HashTableList(int size){
tableSize = size;
hashTable = new LinkedList[size];
for(int i = 0; i < hashTable.length; i++){
    hashTable[i] = new LinkedList<Entry>();
}
}
// Creating hash function for the table
public int hashCode(String key){
      int hash1 = Math.abs(key.hashCode()) % tableSize;
      return hash1;
}
// Put method to allow for insertion into hash table
public void put(String key, int value){ 
    int index = hashCode(key);
    Entry input = new Entry(key, value); 
    hashTable[index].add(input);
  }
// boolean search method that traverses through the table in order to check for exisitng key
// returns true if present, else false
public boolean search(String element){
    int index = hashCode(element);
    for( int j = 0; j<hashTable[index].size(); j++){
       if(hashTable[index].get(j).getKey().equals(element)){
          hashTable[index].get(j).setValue(hashTable[index].get(j).getValue()+1);
          return true;
       }
 } 
 return false;
}
/**
 * Checking for if the hash table needs to be resized
 * if yes, the table doubles in size as per the instruction
 */
 public boolean reSizecheck(){
    double iteration = 0.0;
    for(int i = 0; i < hashTable.length; i++){
        for(int j = 0; j < hashTable[i].size(); j++){
            if(hashTable[i].get(j) != null){
                iteration = iteration + 1.0;
            }
        }
    }
        if((iteration + 1) / tableSize > loadFactor){
            tableSize = tableSize * 2;
            hashTable = new LinkedList[tableSize];
            for(int i = 0; i < tableSize; i++){
             hashTable[i] = new LinkedList<Entry>();
            }
            return true;
        }
        else{
            return false;
        }
}
 // method to print out the hash table   
    public void printTable(){
        for(int i = 0; i < hashTable.length; i++){
            for(int j = 0; j < hashTable[i].size(); j++){
              System.out.println(hashTable[i].get(j).getKey() + " " + hashTable[i].get(j).getValue());
            }
        }
    }
    
 



}
       
    
        


    




