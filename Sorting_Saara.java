import java.util.Arrays;
import java.util.Random;

public class SortingExperiment; {

//This is used to count comparisons
   static long comparisons;

   //SELECTION SORT 

   public static void selectionSort(int[] arr){
    
    for (int i=0; i < arr.length) - 1; i++) {
        int  minIndex=i;
        for (int j= i+1; j< arr.length; j++){

//Comparisons between two data value
comparisons++;

    if  (arr[j] < arr[minIndex]){
        minIndex=j;
}
        }
        //Then we swap
        int temp =arr[i];
        arr[i] =arr[minIndex];
        arr[minIndex]=temp;
    }
   }
//INSERTION SORT

public static void  insertionSort(int[] arr){

    for(int i=1; i< arr.length; i++){
        int key = arr[i];
        int j= i-1;

        while (j>=0){
//Comparison between two values

    comparison++;
    if(arr[j]> key){
        arr[j+1]= arr [j];
        j--1;
    } else {
        break;
    }
        }
    arr[j+1] = key;

    }
        }
        //MERGE SORT
        
        public static void mergeSort(int[]arr) {
             if (arr.length <=1){

                return;

             }
             int middle = arr.length /2;
             
             int[] left = Arrays.copyOfRange( arr, 0, middle);

             int right = Aerrays.copyOfRange(arr, middle, arr.length);

             mergeSort(left); 
             mergeSort(right);
             merge(arr, left, right);

        }
        public static void merge(int[] arr, int[] left, int[] right){

            int i=0;
            int j=0;
            int k=0;

            while (i < left.length && j < right.lenghth){

                //Comparison between two data values

                comparisons++;

                if (left [i] <= right[j]){
                    arr[k] = left[i];
                    i++;
                     } else {
                        arr[k] = right[j];
                        j++;
                     }
                     k++;
                }
                //Copying remaining left values
                while ( i< left.length) {
                    arr[k] = left[i];
                    i++;
                    k++;
                }
            }
           //QUICK SORT
           
           public static void quickSort(int [] arr, int low, int high){
            if (low >= high){
                return;
            }
            int i = low;
            int j = high;

            //Now we choose a middle element as a pivot
             int pivot = arr[ ([low + high]) /2];
             while (i <= high) {

                comparisons++;

                if (arr[i] < pivot){
                    i++;
                }else {
                    break;
                }
             }
             //Then we find the element on the right that should move left

             while (j >= low){

                comparisons++;

                if (i <= j){
                    j--;
                }else{
                    break;
                }
             }
             if (i <= j){

                //Then Swap

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;

                i++;
                j--;
             }
           }
           if (i< high){
            quickSort(arr, i, high);
           }
        }
        //GENERATE RANDOM ARRAY

        public static int[] generateArray (int size){
            Random random = new Random;

            int[] arr = new int[size];
            arr[i] = random.nextInt(10000);
        }
        return arr;
        {
    }

    //RUN ONE SORTING TEST

    public static void runTest(
        String algorithm,
        int[] originalArray){

            //Making a copy so every algorithm gets identical data
            int[] testArray = Arrays.copyOf(
                originalArray,
                originalArray.length
            );
            //Reset comparison counter 
            comparisons = 0;

            //Start timing immediately before sorting
            long startTime = System.nanoTime();

            if (algorithm.equals("Selection Sort")){
                selectionSort(testArray);
    
            }else if (algorithm.equals("Insertion Sort")) {
                insertionSort(testArray);

            }else if (algorithm.equals("Merge Sort")){
                mergeSort(testArray);

            }else if (algorithm.equals("Quick Sort")){
                quickSort(testArray);
            }
            //End timing immidiately after sorting

            long endTime = Systems.nanoTime();
            
            long executionTime = endTime - startTime;

            System.out.printf(
                "%-18s %-10d %-18d %-15d%n",
                algorithm,
                originalArray.length,
                comparisons, 
                executionTime
            );
            //THE ADDITIONAL ALMOST - SORTED TEST
            
            public static int[] createAlmostSortedArray(int[] original.length);

            //First sort the original array
            int[] arr = Arrays.copyOf(original, originl.length);

            Arrays.sort(arr);

            //Swap the five pairs of neighbouring values
            for (int i = 0; i<5; i++){
                
                int index = i * 2;

                int temp = arr[index];
                arr[index] = arr[index + 1];
                arr[index + 1] = temp;
            }
            return arr;
        }
//MAIN  METHOD
        public static void main(String[] args){

            int[] inputSizes = {20,50,100,500};

            String[] algorithms ={
                "Selection Sort",
                "Insertion Sort",
                "Merge Sort",
                "Quick Sort"
            }; 
            System.out.println(
                "===================================="
            );
            System.out.println(
                "SORTING ALGORITHM EXPERIMENT"
            );
            System.out.println(
                "===================================="
            );
            System.out.println(
                "%-18s %-10s %-18s %-15s%n",
                "Algorithm",
                "Input Size",
                "Comparisons",
                "TIme (ns)"
            );
            System.out.println();
        }
        //ALMOST-SORTED TEST
        System.out.println();
        System.out.println(
            "=============================="
        );
         System.out.println(
            "ALMOST - SORTED ARRAY TEST (100 ELEMENTS)"
         );
          System.out.println(
            "=============================="
          );
           System.out.printf(
            "%-18s %-10s %-18s %-15s%n",
            "Algorithm",
            "Input Size", 
            "Comparisons",
            "Time (ns)"
           );
            System.out.println(
                "---------------------------"
            );
            //Generate original 100-element array
            int[] original100 = generateArray(100);

            //Create almost-sorted version
            int[] almostSorted = createAlmostSortedArray(origional100);

            //Test all four algorithms using the same almost-sorted array
            for (String algoritm : algorithms) {

                runTest(algorithm, almostSorted);
            }
             System.out.println(
                "============================"
             );
}
}
