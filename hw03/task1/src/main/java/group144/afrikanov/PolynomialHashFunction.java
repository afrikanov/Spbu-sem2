package group144.afrikanov;

public class PolynomialHashFunction implements HashFunction {

    /**
     * Method counts a hash function using the polynomial technique
     * @param makeHash - starting string
     * @param mod - modulus
     * @return hash - result number
     */
    @Override
    public int hash(String makeHash, int mod) {
        final int multiplier = 59;
        int hash = 0;
        for (int i = 0; i < makeHash.length(); ++i) {
            hash = (hash * multiplier + makeHash.charAt(i)) % mod;
        }
        return hash;
    }
}
