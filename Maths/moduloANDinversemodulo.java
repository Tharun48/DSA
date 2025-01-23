class Solution {
    int mod = 1000000007;
    int[] fact, invFact;
    // Precompute factorials and modular inverses
    public void precomputeFactorials(int n) {
        fact = new int[n + 1];
        invFact = new int[n + 1];
        fact[0] = 1;
        // Compute factorials modulo mod
        for (int i = 1; i <= n; i++) {
            fact[i] = (int)((1L * fact[i - 1] * i) % mod);
        }
        // Compute modular inverses using Fermat's Little Theorem
        //modular inverse is calculated using the binary exponential
        invFact[n] = modularExponentiation(fact[n], mod - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (int)((1L * invFact[i + 1] * (i + 1)) % mod);
        }
    }
    // Modular exponentiation: x^y % mod
    public int modularExponentiation(int x, int y) {
        long result = 1, base = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            y >>= 1;
        }
        return (int)result;
    }
}
