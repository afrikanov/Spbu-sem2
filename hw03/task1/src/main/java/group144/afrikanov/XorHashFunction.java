package group144.afrikanov;

public class XorHashFunction implements HashFunction {

    /**
     * Method counts a hash function using the Xor technique
     * @param makeHash - starting string
     * @param mod - modulus
     * @return hash - result number
     */
    @Override
    public int hash(String makeHash, int mod) {
        int hash = 0;
        for (int i = 0; i < makeHash.length(); ++i) {
            hash = (hash ^ makeHash.charAt(i)) % mod;
        }
        return hash;
    }
}
