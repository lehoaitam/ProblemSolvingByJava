package Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lehoaitam on 1/7/17.
 */
public class WordBreak {
    public static void main(String[] agrs){
        String s = "leetcode";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));

    }
    public static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                String temp = s.substring(j,i);
                if(f[j] && wordDict.contains(temp)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
