package library;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lehoaitam on 10/23/16.
 */
public class TrieNode1 {
    public Map<Character,TrieNode1> map;
    public boolean hasWord;
    public TrieNode1(){
        map = new HashMap<Character, TrieNode1>();
    }
}
