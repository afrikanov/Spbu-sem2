package group144.afrikanov;

import java.util.function.Supplier;

/** Class creates lazy objects of 2 types */
public class LazyFactory {

    /**
     * Method creates a lazy object with asynchronous calculation
     * @param supplier - a supplier that brings an answer
     * @param <T> - a type of the answer
     * @return counted value
     */
    public static <T> Lazy<T> createAsynchronousCalculationLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private T value;
            private boolean isCounted;

            @Override
            public T get() {
                if (isCounted) {
                    return value;
                }
                isCounted = true;
                value = supplier.get();
                return value;
            }
        };
    }

    /**
     * Method creates a lazy object with synchronous calculation
     * @param supplier - a supplier that brings an answer
     * @param <T> - a type of the answer
     * @return counted value
     */
    public static <T> Lazy<T> createSynchronousCalculationLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private volatile T value;
            private volatile boolean isCounted;

            @Override
            public synchronized T get() {
                if (isCounted) {
                    return value;
                }
                isCounted = true;
                value = supplier.get();
                return value;
            }
        };
    }
}
