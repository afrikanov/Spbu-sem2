package group144.afrikanov;

public class MultiplyHashFunction implements HashFunction {

    /**
     * Method counts a hash function using the multiplication technique
     * @param makeHash - starting string
     * @param mod - modulus
     * @return hash - result number
     */
    @Override
    public int hash(String makeHash, int mod) {
        int hash = 1;
        for (char item : makeHash.toCharArray()) {
            hash = (hash * item) % mod;
        }
        return hash;
    }
}
