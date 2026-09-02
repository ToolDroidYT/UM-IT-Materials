
package searchandsort;

import java.util.Arrays;

public class SortingAlgorithm_2ndTerm {
    static void BubbleSort(int array[]){
         int size = array.length;
         int temp;
         
         for(int i = 0; i<size-1; i++){
             for(int j = 0; j<size - i - 1; j++){
                if(array[j] > array[j+1]){
                 temp = array[j];
                 array[j] = array[j+1];
                 array[j+1] = temp; 
               }
             
             }              
            }
         }   
    
    static void InsertionSort(int array[]){
        int size = array.length;
        int key;        
        
        for(int step = 1; step < size; step++){
            key = array[step];
            int j = step - 1;  
            while(j >= 0 && key < array[j]){
                array[j+1] = array[j];
                --j;
            }
            array[j+1] = key;                                         
        }
    }
    
    static void SelectionSort(int array[]){
        int size = array.length;
        
        for (int step = 0; step < size - 1; step++){
            int min_i = step;
            for(int i = step + 1; i<size; i++){
                if(array[i]<array[min_i]){
                min_i = i;
                }              
            }
            int temp = array[step];
            array[step] = array[min_i];
            array[min_i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] Data = {-2, 25, 4, 100, -1};

        
        System.out.println("Original Data: " + Arrays.toString(Data)); 
      
        BubbleSort(Data);
        System.out.println("Sorted String(Bubble Sort): " + Arrays.toString(Data));
        
        Data = new int[]{-1, -2, -3, 5, -4};
        System.out.println("\nOriginal Data: " + Arrays.toString(Data)); 
        InsertionSort(Data);
        System.out.println("Sorted String(Insertion Sort): " + Arrays.toString(Data));
        
        Data = new int[]{99, 45, -1, -10, 0};
        System.out.println("\nOriginal Data: " + Arrays.toString(Data)); 
        SelectionSort(Data);
        System.out.println("Sorted String(Selection Sort): " + Arrays.toString(Data));
        
        System.out.println(0>-1);
    }
    
}
