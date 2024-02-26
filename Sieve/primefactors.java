// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int n =1000;
        int spf[] = new int[n+1];
        for(int i=0;i<1001;i++) spf[i]=i;
        
        for(int i=2;i*i<=n;i++) {
            if(spf[i]==i) {
                for(int j=i*i;j<=n;j+=i) {
                    if(spf[j]>i) {
                        spf[j]=i;
                    }  
                }
            }
        }
        
        int num=772;
        while(num!=1) {
            System.out.println(spf[num]);
            num=num/spf[num];
        }
    }
}
