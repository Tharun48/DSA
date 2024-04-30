class Solution {
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        // int freq[] = new int[10];   
        int bitmasking[] = new int[1025];
        bitmasking[0]=1;
        int totalXor = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int pow = 1;
        for(int i=0;i<10;i++) {
            list.add(pow);
            pow = pow*2;
        }
        // total = a^b;
        // total^b = a;
        long ans=0;
        // System.out.println(list);
        for(int i=0;i<n;i++) {
            int val = word.charAt(i)-'a';
            // System.out.println(Arrays.toString(freq));
            totalXor = totalXor^(1<<val);
            // ans += bitmasking[totalXor];
            for(int a : list ) {
                int b = totalXor^a;
                ans += bitmasking[b];
            }
            bitmasking[totalXor]++;
        }
        return ans;
    }
}
