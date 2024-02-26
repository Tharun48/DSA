import java.util.*;
class HelloWorld {
    private static boolean[] seive(int n) {
        boolean isPrime[] = new boolean[n+1];
        for(int i=2;i<=n;i++) isPrime[i]=true;
        for(int i=2;i*i<=n;i++) {
            if(isPrime[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    if(isPrime[j]) {
                        isPrime[j]=false;
                    }
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        int l=100;
        int r=200;
        r = (int)Math.sqrt(r);
        boolean isPrime[] = seive(r);
        // System.out.println(Arrays.toString(isPrime));
        boolean segSieve[] = new boolean[r-l+1];
        Arrays.fill(segSieve,true);
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=2;i*i<=r;i++) {
            if(isPrime[i]) {
                int firstMultiple = (l/i) * i;
                if(firstMultiple<l) firstMultiple += i;
                for(int k=Math.max(i*i,firstMultiple);k<=r;k+=i) {
                    if(segSieve[k-l]) {
                        segSieve[k-l]=false;
                    }
                }
            }
        }
        for(int i=0;i<segSieve.length;i++) {
            if(segSieve[i]) primeNumbers.add(i+l);
        }
        System.out.println(primeNumbers);
    }
}
