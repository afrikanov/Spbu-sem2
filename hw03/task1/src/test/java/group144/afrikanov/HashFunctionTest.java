package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashFunctionTest {

    private final int SIZE = (int)1e5 + 7;

    @Test
    void testPolynomialHash() {
        HashFunction hashPolynomial = new PolynomialHashFunction();
        assertEquals(2941, hashPolynomial.hash("12", SIZE));
    }

    @Test
    void testXorHash() {
        HashFunction hashPolynomial = new XorHashFunction();
        assertEquals(3, hashPolynomial.hash("9785", SIZE));
    }

    @Test
    void testMultiplyHash() {
        HashFunction hashPolynomial = new MultiplyHashFunction();
        assertEquals(41031, hashPolynomial.hash("abc", SIZE));
    }
}