package Medium;

import library.TrieNode1;

/**
 * Created by lehoaitam on 10/23/16.
 */
public class Trie_208 {
    public static void main(String[] args){
        Trie_208 obj = new Trie_208();
        obj.insert("bad");
        System.out.println(obj.search("bad"));
    }
    private TrieNode1 root;

    public Trie_208() {
        root = new TrieNode1();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(word, false);
    }
    public boolean search(String word, boolean searchByPrefix) {
        if(word == null || "".equals(word)) return true;
        char[] chars = word.toCharArray();
        TrieNode1 node = root;
        for(char ch : chars){
            TrieNode1 child = node.map.get(ch);
            if(child == null) return false;
            node = child;
        }
        if(!searchByPrefix)
            return node.hasWord;
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(prefix, true);
    }
}
