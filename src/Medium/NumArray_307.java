package Medium;

/**
 * Created by lehoaitam on 10/26/16.
 */
public class NumArray_307 {

    private int[] T; // sum of segment
    private int[] from;
    private int[] to;
    private int startOfLeafIndex;
    public static void main(String[] args){
        int[] a = {12,4,3,5,1,9,15,2};
        NumArray_307 obj = new NumArray_307(a);
        obj.update(4,8);
        obj.update(4,1);
        obj.update(3,15);
        System.out.println(obj.sumRange(3,6));
    }

    public NumArray_307(int[] nums) {
        //initialize
        int n = nums.length;
        //find depth level
        int depth = 0;
        for(depth = 0; (1 << depth) < n; depth++);
        //alloc memories
        int numOfLeaves = 1 << depth;
        T = new int[(numOfLeaves << 1) - 1];
        from = new int[(numOfLeaves << 1) - 1];
        to = new int[(numOfLeaves << 1) - 1];
        //constructs leaves node
        startOfLeafIndex = numOfLeaves - 1;
        int j = startOfLeafIndex;
        for(int i = 0; i < n; i++){
            T[j] = nums[i];
            from[j] = i;
            to[j] = i;
            j++;
        }
        //constructs remain node
        for(int i = numOfLeaves - 2; i >= 0; i--){
            int leftNodeIndex = (i << 1) + 1;
            int rightNodeIndex = (i << 1) + 2;
            T[i] = T[leftNodeIndex] + T[rightNodeIndex];
            from[i] = Math.min(from[leftNodeIndex],from[rightNodeIndex]);
            to[i] = Math.max(to[leftNodeIndex],to[rightNodeIndex]);
        }

    }

    void update(int i, int val) {
        //update leaf node
        int j = startOfLeafIndex + i;
        T[j] = val;
        //change to root node
        while( j > 0){
            j = (j - 1) >> 1;
            //update sum value of current node
            T[j] = T[(j<<1) + 1] + T[(j<<1) + 2];
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(i,j,0);
    }
    private int sumRangeHelper(int i, int j,int k){
        int l = from[k];
        int r = to[k];
        // i<j<l<r or l<r<i<j
        if(j < l || i > r) return 0;
        if(i <= l && r <= j) return T[k];
        return sumRangeHelper(i,j,(k<<1)+1)+ sumRangeHelper(i,j,(k<<1)+2);
    }

}
