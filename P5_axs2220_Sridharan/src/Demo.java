/*
 * Demo class to do benchmarking
 */
public class Demo {
    public static void main(String[] args) {
        // Initializing Object
        Sort sort = new Sort();
        // Initializing array of different sizes
       int [] size = new int[] {10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
       // Initializing objects for timing
       long start, gap, finish;

       //Creating for-loop, for array to different sizes 
       for(int i = 0; i < size.length; i++){
        int input = size[i];
        // array with random inputs
        int[] randArr = sort.generateRandomArray(input);
        // sorting method used to pre sort new array
         Arrays.sort(randArr);
         // Initialzing new array pre sorted and reverse sorted
         int[] tempArr = new int[randArr.length];
         for(int j = 0; j < tempArr.length; j++){
            tempArr[j] = randArr[j];
         }
         // method called with different arrays with nanotime measure
        start = System.nanoTime();
        Sort.insertionSort(randArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);

        start = System.nanoTime();
        Sort.bubbleSort(tempArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);

        start = System.nanoTime();
        Sort.shellSort(tempArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);

        start = System.nanoTime();
        Sort.quickSort(tempArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);

        start = System.nanoTime();
        Sort.mergeSort(tempArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);

        start = System.nanoTime();
        Arrays.sort(tempArr);
        finish = System.nanoTime();
        gap = finish - start;
        System.out.println("Time" +" " +gap);
    }

}
}
    
    


