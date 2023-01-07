
/** CSDS 233 Assignment 5, Author: Atreya Sridharan (axs2220)
 * Documents used: Java Oracle documentation, and lecture slides
 * I would like to thank the TA's Rohan Singh and Ritvik Kasarla for their help during this project
 */
public class Sort{
    
    // Main method in order to test sorting methods before benchmarking
    public static void main(String[] args) {
         Sort s1 = new Sort();
       int[] array = s1.generateRandomArray(10);
       System.out.println("Unsorted");
       printArray(array);
       
       s1.bubbleSort(array);
       System.out.println("Sorted");
       printArray(array);
       s1.readCommands("commands.txt");
    
        
    }
       // Insertion Sort method
    static void insertionSort(int[] array){
      for (int i = 1; i < array.length; i++){
          int currentValue = array[i];

          int j = i -1; 
          while(j >= 0 && array[j] > currentValue){
              array[j+1] =array[j]; 
              j-- ; 

          }
          array[j+1] = currentValue;
      }
    }
        // Bubble Sort method
    static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
// Helper method "Swap" for other sorting methods 
    public static final void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//Method to print array
static void printArray(int[] array){
    for(int i = 0; i < array.length; i++){
        System.out.println(array[i]);
    }
}

// Shell Sort method
 static void shellSort(int[] array){
   int incr = array.length;
   for(int i = incr/2; i > 0; i /= 2){
    for(int j = i; j < incr; j += 1){
        int temp = array[i];
        int k;
        for(k = j; k >= i && array[k-i] > temp; k-= i){
            array[k] = array[k - i];
        }
        array[k] = temp;
    }
   }
}

// quickSort calling helper method recursively 
static void quickSort(int[] array){
    myQuickSort(array, 0, array.length -1);
}

//Helper method for quicksort that does the sorting 
static int myQuickSort(int[] arr, int low, int high){
    int pivot = arr[high];
    int i = (low - 1) ;

    for(int j = low; j <= high; j++){
        if( arr[j] < pivot){
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return (i + 1);
}

// Helper method for mergeSort
  static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
    int i = leftStart;  
    int j = rightStart; 
    int k = leftStart; 
    while (i  <= leftEnd && j <= rightEnd) {
    if (arr[i] <= arr[j]) 
                { 
                    temp[k] = arr[i]; 
                    i++; 
                } 
                else
                { 
                    temp[k] = arr[j]; 
                    j++; 
                } 
                k++; }
     
    while (i <= leftEnd) 
            { 
                temp[k] = arr[i]; 
                i++; 
                k++; 
            } 
    
     for (i = leftStart; i <= rightEnd; i++){
       arr[i] = temp[i];
     }

}
// Merge sort method
 static void mergeSort(int[] arr) {
    int[] temp = new int[arr.length];
    myMergeSort(arr, temp, 0, arr.length - 1);
    }


    static void myMergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end ) // base case
        return;
        int middle = (start + end)/2; // The splitting step
        // Sort first and second halves 
                    myMergeSort (arr, temp, start, middle); 
                    myMergeSort (arr , temp, middle+1, end); 
          
                    // Merge the sorted halves 
                    merge(arr, temp, start, middle, middle+1, end); 
    }

    //UpgradedQuick Sort method as defined in the assignment document 
    static void upgradedQuickSort(int[] input, int d, int k){
        myUpgradedquickSort(input, 0, input.length - 1, d,k);

    }

    //Helper method that does the sorting, while being called recursively by the upgraded quick sort method
    static void myUpgradedquickSort(int[] input, int first, int last, int d, int k){
        int depth = 0;
        if( depth >= d){
            mergeSort(input);
           }
        if(input.length < k){
            insertionSort(input);
           }
        if( first < last){
            int splitter = partition(input, first, last);
            depth++;
            myUpgradedquickSort(input, first, splitter, d, k);
            myUpgradedquickSort(input, splitter + 1, last, d, k);
        }

    }

    //Helper method for mergeSort
    static int partition(int [] arr, int start, int high){
        int temp[] = new int [(high - start) + 1];
        int piv = arr[high];
        int ind = 0;

    for(int i = start; i <= high; i++ ){
        if(arr[i] < piv){
            temp[ind++] = arr[i];
        }
    }
        int pos = ind;
        temp[ind++] = piv;
        for(int i = start; i <= high; i++ ){
            if(arr[i] > piv){
                temp[ind++] = arr[i];
            }
        }
        for (int i = start; i <= high; ++i) {
            arr[i] = temp[i - start];
        }
        return pos;
    }

    // Method to generate new arrays
   int[] generateRandomArray(int n){
           int arr[] = new int[n];
            Random rand = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = rand.nextInt();
        }
        return arr;
        }

    // Method to read and execute command from text file
   void readCommands(String filepath){
        try {
            // File path 
            File myObj = new File("/Users/atreyasridharan/Downloads/commands.txt");
            Scanner scan1 = new Scanner(myObj);
            while(scan1.hasNextLine()){
                String data = scan1.nextLine();
                // Treating each line as a string, and splitting it
                String [] arrStr = data.split(":");
                String arry = arrStr[1];
              
                System.out.println(arry);
                arry = arry.substring(2,arry.length()-1);
                System.out.println(arry);

                String[] digits = arry.split(",");

                //Creating new array with respect to split in ","
                int[] array = new int[digits.length];
                for(int i = 0; i < digits.length; i++){
                    array[i] = Integer.parseInt(digits[i]);
                }

                int sum =0;
                for(int j =0; j < array.length; j++){
                    sum += array[j];
                }
                System.out.println(sum);

                // If string is found, sorting method is called. 
                if(arrStr[0].equals("insertionSort")){
                    insertionSort(array);
                    printArray(array);
                }

                if(arrStr[0].equals("bubbleSort")){
                    bubbleSort(array);
                    printArray(array);
                }

                if(arrStr[0].equals("shellSort")){
                    shellSort(array);
                    printArray(array);
                }

                if(arrStr[0].equals("quickSort")){
                    quickSort(array);
                    printArray(array);
                }

                if(arrStr[0].equals("mergeSort")){
                    mergeSort(array);
                    printArray(array);
                }

                if(arrStr[0].equals("upgradedQuickSort")){
                    upgradedQuickSort(array, sum, sum);
                }
            }
        } 
        catch (FileNotFoundException e) {
           System.out.println("File not read");
            e.printStackTrace();
        }

        
    }
    
}