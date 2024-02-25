import java.util.* ;
import java.io.*; 
class Node{
    Node trie[];
    int sw; //startwith
    int ew; //endwith
    Node() {
        trie = new Node[26];
        sw=0;
        ew=0;
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
    
    void increaseStartWith() {
        sw++;
    }
    void increaseEndWith() {
        ew++;
    }
    int getEndWith() {
        return ew;
    }
    int getStartWith() {
        return sw;
    }
    void decreaseEndWith() {
        ew--;
    }
    void decreaseStartWith(){
        sw--;
    }
}
public class Trie {
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
            cur.increaseStartWith();
        }
        cur.increaseEndWith();
    }

    public int countWordsEqualTo(String word) {
        int n = word.length();
        Node cur = root;
        for(int i=0;i<n;i++) {
            int a = word.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                return 0;
            }
            cur = cur.getNext(a);
        }
        return cur.getEndWith();
    }

    public int countWordsStartingWith(String word) {
        int n = word.length();
        Node cur = root;
        for(int i=0;i<n;i++) {
            int a = word.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                return 0;
            }
            cur = cur.getNext(a);
        }
        return cur.getStartWith();
    }

    public void erase(String word) {
        int n = word.length();
        Node cur = root;
        for(int i=0;i<n;i++) {
            int a = word.charAt(i)-'a';
            if(!cur.containsChar(a)) {
                return ;
            }
            else {
                cur = cur.getNext(a);
                cur.decreaseStartWith();
            }
        }
        cur.decreaseEndWith();
    }

}
