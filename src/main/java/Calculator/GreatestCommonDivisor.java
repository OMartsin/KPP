package Calculator;

import java.math.BigInteger;

public class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static BigInteger gcd(BigInteger A, BigInteger B) {
        if (B.equals(BigInteger.valueOf(0))) {
            return A;
        } else {
            return gcd(B, A.remainder(B));
        }
    }
}
