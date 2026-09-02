import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Hello, since I am being nice here is the initial code.
        // Hope it helps!
    
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        int[] unsortedArr = new int[size];
        for (int i = 0; i < size; i++){
            System.out.printf("Enter element %d: ", i + 1);
            unsortedArr[i] = sc.nextInt();
        }
        
        int[] sortedArr = unsortedArr.clone();
        bubbleSort(sortedArr);
        
        System.out.print("Unsorted Array: ");
        printArray(unsortedArr);
        System.out.print("\nSorted Array: ");
        printArray(sortedArr);
    }
    
    public static void printArray(int[] array) {
        System.out.print(
            Arrays.toString(array)
            .replace(",", "")
            .replace("[", "")
            .replace("]", "")
        );
    }
    
    
    public static void bubbleSort(int[] array) {
        int size = array.length;
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int val = array[j];
                int nextVal = array[j + 1];
                
                if (val > nextVal) {
                    array[j] = nextVal;
                    array[j + 1] = val;
                }
            }
        }
    }
}