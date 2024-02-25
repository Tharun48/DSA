class HelloWorld {
    public static void main(String[] args) {
        boolean isPrime[] = new boolean[100];
        for(int i=2;i<100;i++) isPrime[i]=true;
        
        for(int i=2;i*i<=100;i++) {
            if(isPrime[i]) {
                for(int j=i*i;j<100;j+=i) {
                    isPrime[j]=false;
                }
            }
        }
        for(int i=0;i<100;i++) {
            if(isPrime[i]==true) System.out.println(i);
        }
    }
}
