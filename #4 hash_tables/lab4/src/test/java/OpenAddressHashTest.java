import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenAddressHashTest {
    @Test
    void show() {
        OpenAddressHash<Integer> hash = new OpenAddressHash<>(5, Probing.LINEAR);
        hash.show();
    }

    @Test
    void insert() {
        OpenAddressHash<Integer> hash = new OpenAddressHash<>(5, Probing.DOUBLE);
        hash.insert(1,2);
        hash.insert(6,7);
        hash.insert(11,15);
        hash.insert(16,15);
        hash.insert(21,15);
        hash.insert(26,15);
        hash.show();
    }

    @Test
    void delete() {
        OpenAddressHash<Integer> hash = new OpenAddressHash<>(5, Probing.DOUBLE);
        hash.insert(1,2);
        hash.insert(6,7);
        hash.insert(11,15);
        hash.insert(16,15);
        hash.insert(21,15);
        System.out.println("before deletion:");
        hash.show();
        hash.delete(6);
        hash.delete(21);
        System.out.println("after deletion 6 and 21:");
        hash.show();
    }

    @Test
    void search() {
        OpenAddressHash<Integer> hash = new OpenAddressHash<>(5, Probing.QUADRATIC);
        hash.insert(1,2);
        hash.insert(6,7);
        hash.insert(11,2048);
        hash.insert(16,15);
        hash.insert(21,15);
        hash.show();
        System.out.println("value for key 11 is:" +hash.search(11));
    }
}