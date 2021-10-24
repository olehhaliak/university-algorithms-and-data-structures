import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainedHashTest {
    @Test
    void show() {
        ChainedHash<Integer> hash = new ChainedHash<>();
        hash.show();
    }

    @Test
    void insert() {
        ChainedHash<Integer> hash = new ChainedHash<Integer>();
        for (int i = 0; i < 22; i++) {
            hash.insert(i, i);
        }
        hash.show();
    }

    @Test
    void insertTest_DivisionHashFunc() {
        ChainedHash<Integer> hash = new ChainedHash<>(4, new HashFunction.DivisionHashFunction());
        for (int i = 0; i < 22; i += 4) {
            hash.insert(i, i);
        }
        hash.show();
    }

    @Test
    void searchTest() {
        ChainedHash<Integer> hash = new ChainedHash<>(4, new HashFunction.DivisionHashFunction());
        for (int i = 0; i < 22; i++) {
            hash.insert(i, i);
        }
        for (int i = 0; i < 22; i++) {
            assertEquals(i,hash.search(i));
        }
    }

    @Test
    void deleteTest() {
        ChainedHash<Integer> hash = new ChainedHash<>(4, new HashFunction.DivisionHashFunction());
        for (int i = 0; i < 22; i++) {
            hash.insert(i, i);
        }
        hash.show();
        hash.delete(1);
        hash.delete(2);
        hash.delete(3);
        System.out.println("Removed keys: 1, 2, 3");
        hash.show();
    }

}