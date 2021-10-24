import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashFunctionsTest {
    @Test
    void divisionHashTest() {
        HashFunction hashFunction = new HashFunction.DivisionHashFunction();
        assertEquals(1, hashFunction.getHash(1, 10));
        assertEquals(1, hashFunction.getHash(11, 10));
    }

    @Test
    void multiplicationHashTest() {
        HashFunction hashFunction = new HashFunction.MultiplicationHashFunction();
        assertEquals(3, hashFunction.getHash(7, 10));
        assertEquals(5, hashFunction.getHash(9, 10));
    }

    @Test
    void multiplicationHash_first50() {
        HashFunction hashFunction = new HashFunction.DivisionHashFunction();
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : " + hashFunction.getHash(i, 5));
        }
    }
}
