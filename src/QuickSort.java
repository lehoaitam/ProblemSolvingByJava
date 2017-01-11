/**
 * Created by lehoaitam on 1/10/17.
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {8,1,4,9,6,3,5,2,7,0};
        QuickSort(arr,0,arr.length-1);
    }
    public static int Partition(int[] arr, int l, int r){
        //choose pivot as the right most element
        int p = r;
        int i = l, j = r-1, temp;
        while(i < j){
            while(arr[i] < arr[p] && i < j)i++;
            while(arr[j] > arr[p] && i < j)j--;
            //swap arr[i], arr[j]
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
        return 0;
    }
    public static void QuickSort(int[] arr, int l, int r){
        int p = Partition(arr, l, r);
        QuickSort(arr,l,p-1);
        QuickSort(arr,p+1,r);
    }

}
