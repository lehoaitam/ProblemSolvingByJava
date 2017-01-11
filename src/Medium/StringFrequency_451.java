package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

/**
 * Created by lehoaitam on 1/8/17.
 */
public class StringFrequency_451 {
    public static class Node{
        public char ch;
        public int fre;
        public Node(){}
        public Node(char ch, int fre){
            this.ch = ch;
            this.fre = fre;
        }
    }
    public static void main(String[] args){
        System.out.print(frequencySort("ccaaabbbbd"));

    }
    public static String frequencySort(String s) {
        String result = "";
        char[] arrChrs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < arrChrs.length; i++){
            if(map.containsKey(arrChrs[i]))
                map.put(arrChrs[i],map.get(arrChrs[i]) + 1);
            else
                map.put(arrChrs[i],1);
        }
        Node[] arrNode = new Node[map.size()];
        int i = 0;
        for(Map.Entry entry: map.entrySet())
            arrNode[i++] = new Node((char)entry.getKey(), (int)entry.getValue());
        //build heap;
        BuildHeap(arrNode, arrNode.length);
        int n = arrNode.length;
        StringBuilder sb = new StringBuilder();

        for(i = 0; i < arrNode.length; i++){
            Node temp = ExtractMax(arrNode,n--);
            for(int j = 0; j < temp.fre; j++)
                result += temp.ch;
        }
        return result;
    }
    public static void Heapify(Node[] arr, int n, int i){
        int child = 2*i + 1;
        if(child < n){
            if(child+1 < n && arr[child+1].fre > arr[child].fre)
                child++;
            if(arr[child].fre > arr[i].fre){
                //swap child and current node
                Node temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
                //heapify next child;
                Heapify(arr, n, child);
            }
        }
    }
    public static void  BuildHeap(Node[] arr, int n){
        for(int i = (n>>1) - 1; i >= 0; i--)
            Heapify(arr, n, i);
    }
    public static Node ExtractMax(Node[] arr, int n){
        Node temp = arr[0];
        arr[0] = arr[n-1];
        Heapify(arr, n-1, 0);
        return temp;
    }
}
