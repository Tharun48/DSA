// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        boolean isPrime[] = new boolean[100];
        int spf[] = new int[100];
        for(int i=2;i<100;i++) isPrime[i]=true;
        for(int i=0;i<100;i++) spf[i]=i;
        for(int i=2;i*i<=100;i++) {
            if(isPrime[i]) {
                for(int j=i*i;j<100;j+=i) {
                    if(isPrime[i]) {
                        spf[j]=i;
                    }
                    isPrime[j]=false;
                }
            }
        }
        // for(int i=0;i<100;i++) {
        //     if(isPrime[i]==true) System.out.println(i);
        // }
        System.out.println(Arrays.toString(spf));
    }
}
