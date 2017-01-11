package library;

/**
 * Created by lehoaitam on 1/8/17.
 */
public class Heap {
    public static void buildHeap(int[] arr){
        for(int i = arr.length/2-1; i >= 0; i--)
            downHeap(arr,arr.length,i);
    }
    public static void downHeap(int[] arr,int n, int element){
        int maxChild = element * 2 + 1;
        //check if element is leaf or not
        if(maxChild < arr.length){
            if(maxChild + 1 < arr.length && arr[maxChild + 1] > arr[maxChild])
                maxChild = maxChild + 1;
            if(arr[maxChild] > arr[element]){
                //swap child and element
                int temp = arr[maxChild];
                arr[maxChild] = arr[element];
                arr[element] = temp;
                //downHeap maxChild;
                downHeap(arr, n, maxChild);
            }
        }
    }
    public static int extractMax(int[] arr, int n){
        int temp = arr[0];
        arr[0] = arr[n-1];
        downHeap(arr,n-1,0);
        return temp;
    }
    public static void PrintArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        int[] arr = {3,2,1,5,6,4};
        buildHeap(arr);
        int k = 2;
        int n = arr.length;
        for(int i = 0; i < k-1; i++)
            extractMax(arr, n--);

        System.out.println(arr[0]);

    }
}
