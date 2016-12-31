package Easy;

/**
 * Created by lehoaitam on 10/22/16.
 */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if(m == 0) return 0;
        if(n == 0) return -1;
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();

        //implement next map
        int[] next = new int[m];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < m -1){
            if(j == -1 || needleChars[i] == needleChars[j]){
                i++;
                j++;
                next[i] = j;
            }else
                j = next[j];
        }
        //main agorithm
        j = 0;
        i = 0;
        while(i < n){
            if(j < m && needleChars[j] != haystackChars[i]) j = next[j];
            else {
                i++;
                j++;
            }
            if(j == m)
                return i - j;
            if(j == -1){
                j = 0;
                i++;
            }
        }
        return -1;
    }
}
