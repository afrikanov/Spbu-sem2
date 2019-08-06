package group144.afrikanov;

/**
 * Interface realizes lazy calculation method
 * @param <T> - type of calculated object
 */
public interface Lazy<T> {

    /**
     * Method calculates the answer if it hasn't called earlier and puts already calculated value otherwise
     * @return calculated answer
     */
    T get();
}
