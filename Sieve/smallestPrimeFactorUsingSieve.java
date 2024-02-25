class Seive {
    boolean isPrime[];
    int spf[];
    Seive() {
        isPrime = new boolean[100001];
        spf = new int[100001];
        for(int i=2;i<=100000;i++) {
            isPrime[i]=true;
        }
        for(int i=0;i<=100000;i++) {
            spf[i]=i;
        }
    }
    void createSeive(){
        for(int i=2;i*i<=100000;i++) {
            if(isPrime[i]) {
                for(int j=i*i;j<=100000;j+=i) {
                    if(isPrime[j]) {
                        spf[j]=i;
                    }
                    isPrime[j]=false;
                }
            }
        }
    }
}
