package Medium;

import library.TrieNode1;

import java.util.Iterator;

/**
 * Created by lehoaitam on 10/23/16.
 */
public class WordDictionary_211 {

    TrieNode1 root = new TrieNode1();

    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        TrieNode1 node = root;
        //add each character of string into trienode
        for(char ch : chars){
            TrieNode1 child = node.map.get(ch);
            if(child == null){
                child = new TrieNode1();
                node.map.put(ch,child);
            }
            //go to next level
            node = child;
        }
        node.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || "".equals(word)) return true;
        return search(word,root);
    }

    public boolean search(String word, TrieNode1 node) {
        if (word.length() < 1) return node != null && node.hasWord;
        char[] chars = word.toCharArray();
        if (chars[0] != '.') {
            TrieNode1 child = node.map.get(chars[0]);
            if (child != null) return search(word.substring(1), child);
            return false;
        } else {
            for (TrieNode1 child : node.map.values()) {
                if (search(word.substring(1), child)) return true;
            }
            return false;
        }
    }
}
