package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static group144.afrikanov.LazyFactory.createAsynchronousCalculationLazy;
import static group144.afrikanov.LazyFactory.createSynchronousCalculationLazy;
import static org.junit.jupiter.api.Assertions.*;

class LazyFactoryTest {

    @Test
    void createSynchronizedLazyCommonTest() {
        Lazy<Integer> lazy = createSynchronousCalculationLazy(() -> 10);
        assertEquals(Integer.valueOf(10), lazy.get());
        lazy.get();
        assertEquals(Integer.valueOf(10), lazy.get());
    }

    @Test
    void createAsynchronousLazyCommonTest() {
        Lazy<Character> lazy = createAsynchronousCalculationLazy(() -> '1');
        assertEquals((Character)'1', lazy.get());
        lazy.get();
        assertEquals((Character)'1', lazy.get());
    }

    @Test
    void raceTest() throws InterruptedException {
        int[] called = {0};
        Lazy<Integer> lazy = createSynchronousCalculationLazy(() -> {
            ++called[0];
            return null;
        });
        int threadsAmount = (int)1e3;
        Thread[] threads = new Thread[threadsAmount];
        for (int i = 0; i < threadsAmount; ++i) {
            threads[i] = new Thread(() -> {
                assertNull(lazy.get());
            });
        }
        for (int i = 0; i < threadsAmount; ++i) {
            threads[i].start();
        }
        for (int i = 0; i < threadsAmount; ++i) {
            threads[i].join();
        }
        assertFalse(called[0] > 1);
    }
}
