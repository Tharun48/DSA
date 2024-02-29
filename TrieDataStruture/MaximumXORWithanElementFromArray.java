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
                num = num | (1<<i);
                node = node.getNext(1-bit);
            }
            else {
                node = node.getNext(bit);
            }
        }
        return num;
    }
    boolean isEmpty(){
        if(root.trie[0]!=null || root.trie[1]!=null) return true;
        return false;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] q) {
        int n = nums.length;
        Trie root = new Trie();
        Arrays.sort(nums);
        int qu[][] = new int[q.length][3];
        for(int i=0;i<q.length;i++) {
            qu[i][0]=i;
            qu[i][1]=q[i][0];
            qu[i][2]=q[i][1];
        }
        Arrays.sort(qu,(a,b)->a[2]-b[2]);
        System.out.println(Arrays.deepToString(q));
        int k=0;
        int ans[] = new int[q.length];
        for(int i=0;i<q.length;i++) {
            int in = qu[i][0];
            int x = qu[i][1];
            int m = qu[i][2];
            System.out.println("x = " + x);
            System.out.println("m = " + m);
            while(k<nums.length && nums[k]<=m) {
                root.insert(nums[k]);
                k++;
            }
            boolean flag=false;
            if(!root.isEmpty())  flag=true;
            if(flag) {
                ans[in]=-1;
            }
            else ans[in]=root.getMax(x);
        }
        return ans;
    }
}
