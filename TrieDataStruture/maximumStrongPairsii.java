class Node{
    Node trie[];
    int countofbits[];
    Node(){
        trie = new Node[2];
        countofbits = new int[2];
    }
    boolean contains(int bit) {
        return countofbits[bit]>0;
    }
    void put(int bit){
        trie[bit]=new Node();
    }
    void increaseCountOfBits(int bit) {
        countofbits[bit]++;
    }
    Node getNext(int bit){
        return trie[bit];
    }
    void decreaseCountOfBits(int bit) {
        countofbits[bit]--;
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    void insert(int n) {
        Node cur=root;
        for(int i=20;i>=0;i--) {
            int bit = ((n>>i) & 1);
            if(!cur.contains(bit)) {
                cur.put(bit);
            }
            cur.increaseCountOfBits(bit);
            cur=cur.getNext(bit);
        }
    }
    void delete(int n) {
        Node cur=root;
        for(int i=20;i>=0;i--) {
            int bit = ((n>>i) & 1);
            cur.decreaseCountOfBits(bit);
            cur=cur.getNext(bit);
        }
    }
    int getMax(int n) {
        Node cur=root;
        int xor=0;
        for(int i=20;i>=0;i--) {
            int bit = ((n>>i) & 1);
            if(cur.contains(1-bit)) {
                xor = ((1-bit)<<i) | xor;
                cur = cur.getNext(1-bit);
            }
            else {
                xor = (bit<<i) | xor;
                cur = cur.getNext(bit);
            }
        }
        return xor;
    }
}
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Trie trie = new Trie();
        int end=0;
        int start=0;
        int ans=0;
        while(end<n) {
            trie.insert(nums[end]);
            while(nums[end]>2*nums[start]) {
                trie.delete(nums[start]);
                start++;
            }
            int val  = trie.getMax(nums[end]);
            ans = Math.max(ans,nums[end]^val);
            end++;
        }
        return ans;
    }
}
