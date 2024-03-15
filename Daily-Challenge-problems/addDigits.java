class Solution {
    public int addDigits(int num) {
        int sum = num;
        while(sum>=10) {
            sum = getNum(sum);
        }
        return sum;
    }
    int getNum(int num) {
        int sum = 0;
        while(num>0) {
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
}
//Follow up can be done in O(1) runtime 
//related to divisibility test of 9
int addDigits(int num) {
    if(num==0)
        return 0;
    else if(num%9==0)
        return 9;
    else
        return num%9;
}
