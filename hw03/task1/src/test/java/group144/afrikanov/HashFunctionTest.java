package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashFunctionTest {

    private final int SIZE = (int)1e5 + 7;

    @Test
    void testPolynomialHash() {
        HashFunction hashPolynomial = new PolynomialHashFunction();
        assertEquals(hashPolynomial.hash("12", SIZE), 2941);
    }

    @Test
    void testXorHash() {
        HashFunction hashPolynomial = new XorHashFunction();
        assertEquals(hashPolynomial.hash("9785", SIZE), 3);
    }

    @Test
    void testMultiplyHash() {
        HashFunction hashPolynomial = new MultiplyHashFunction();
        assertEquals(hashPolynomial.hash("abc", SIZE), 41031);
    }
}