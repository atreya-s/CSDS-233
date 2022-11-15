/* Class for Entry
 */ 
public class Entry {
    private String key;
    private int value;

// Initializing constructor
    Entry(String key, int value){
        this.key = key;
        this.value = value;
    }
// Getter and Setter methods
    public int setValue(int value){
        this.value = value;
        return value;
    }

   public String getKey(){
        return key;
    }
    
    public int getValue(){
        return value;
    }
}
