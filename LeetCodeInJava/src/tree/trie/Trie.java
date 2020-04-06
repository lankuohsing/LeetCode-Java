package tree.trie;

public class Trie {
    class TrieNode {
        char value;
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
        }

        public TrieNode(char value) {
            this.value = value;
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    private static int ALPHABET_SIZE = 26;
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode((char) 0);

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode;
        curNode = this.root;
        for (char letter : charArray) {
            if (curNode.children[letter - 'a'] != null) {
                curNode = curNode.children[letter - 'a'];

            } else {
                curNode.children[letter - 'a'] = new TrieNode(letter);
                curNode = curNode.children[letter - 'a'];
            }

        }
        curNode.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode curNode;
        curNode = this.root;
        for (char letter : charArray) {
            if (curNode.children[letter - 'a'] == null) {
                return false;
            } else {
                curNode = curNode.children[letter - 'a'];
            }
        }
        return curNode.isEnd;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode curNode;
        curNode = this.root;
        for (char letter : charArray) {
            if (curNode.children[letter - 'a'] == null) {
                return false;
            } else {
                curNode = curNode.children[letter - 'a'];
            }
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */