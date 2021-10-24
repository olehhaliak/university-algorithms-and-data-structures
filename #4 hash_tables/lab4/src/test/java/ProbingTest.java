import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbingTest {
    @Test
    void name() {
        Probing probing = Probing.DOUBLE;
        System.out.println(probing.getHash(2, 0, 5));
        System.out.println(probing.getHash(7, 0, 5));
        System.out.println(probing.getHash(15, 0, 5));
        System.out.println(probing.getHash(15, 1, 5));
        System.out.println(probing.getHash(15, 2, 5));
        System.out.println(probing.getHash(15, 10, 5));
    }
}