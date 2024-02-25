class Node{
    Node trie[];
    boolean flag;
    Node() {
        trie = new Node[26];
        flag=false;
    }
    boolean containsChar(int n) {
        return trie[n]!=null;
    }
    
    void addChar(int a) {
        trie[a]=new Node();
    }
    Node getNext(int a) {
        return trie[a];
    }
    void setEnd() {
        flag=true;
    }
    boolean isEnd() {
        return flag==true;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        int n = word.length();
        Node cur = root;
        for(int i=0;i<n;i++) {
            int a = word.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                cur.addChar(a);
            }
            cur = cur.getNext(a);
        }
        cur.setEnd();
    }
    
    public boolean search(String word) {
        Node cur = root;
        int n = word.length();
        for(int i=0;i<n;i++) {
            int a = word.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                return false;
            }
            cur = cur.getNext(a);
        }
        return cur.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        int n = prefix.length();
        for(int i=0;i<n;i++) {
            int a = prefix.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                return false;
            }
            cur = cur.getNext(a);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
