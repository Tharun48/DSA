class Node{
    Node trie[];
    Node() {
        trie = new Node[2];
    }
    boolean containsKey(int a) {
        return trie[a]!=null;
    }
    void put(int a) {
        trie[a]=new Node();
    }
    Node getNext(int a) {
        return trie[a];
    }
}
class Trie{
    Node root;
    Trie() {
        root = new Node();
    }
    void insert(int a) {
        Node node = root;
        // System.out.println(a);
        for(int i=31;i>=0;i--) {
            int bit = (a >> i) & 1; 
            if(!node.containsKey(bit))
                node.put(bit);
            node = node.getNext(bit);
        }
    }
    int getMax(int a) {
        Node node=root;
        
        int num=0;
        for(int i=31;i>=0;i--) {
            int bit = (a >> i) & 1; 
            if(node.containsKey(1-bit)) {
                num = num + (1<<i);
                node = node.getNext(1-bit);
            }
            else {
                node = node.getNext(bit);
            }
        }
        return num;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        Trie root = new Trie();
        for(int i=0;i<n;i++) {
            root.insert(nums[i]);
        }

        int ans=Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            ans = Math.max(ans,root.getMax(nums[i]));
        }
        //System.out.println(root.root.trie[0]);
        return ans;
    }
}
