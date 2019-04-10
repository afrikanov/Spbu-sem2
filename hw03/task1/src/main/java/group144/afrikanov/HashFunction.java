package group144.afrikanov;

public interface HashFunction {

    /**
     * Method, which counts a hash of the string
     * @param makeHash - starting string
     * @param mod - modulus
     * @return hash - result number
     */
    int hash(String makeHash, int mod);
}
