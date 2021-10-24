import java.util.LinkedList;
import java.util.Objects;

public class ChainedHash<T> implements Hash<T> {
    private final Node<T> NONE = new Node<>(-1, null);
    private static final int DEFAULT_SIZE = 4;
    private static final HashFunction DEFAULT_HASH_FUNCTION = new HashFunction.MultiplicationHashFunction();

    private LinkedList<Node<T>>[] hashTable;
    private HashFunction hashFunction;

    public ChainedHash(int bucketCount, HashFunction hashFunction) {
        hashTable = new LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            hashTable[i] = new LinkedList<>();
        }
        this.hashFunction = hashFunction;
    }

    public ChainedHash() {
        this(DEFAULT_SIZE, DEFAULT_HASH_FUNCTION);
    }

    @Override
    public void insert(int key, T value) {
        LinkedList<Node<T>> bucket = hashTable[getHash(key)];
        if (bucket.stream().noneMatch(e -> e.key == key)) {
            bucket.add(new Node<>(key, value));
        } else {
            System.out.println("Hashtable already contain this key!");
        }
    }

    @Override
    public T search(int key) {
        return findNode(key).value;
    }

    private Node<T> findNode(int key){
        return getBucketForKey(key).stream().filter(n -> n.key == key).findFirst().orElse(NONE);
    }

    private LinkedList<Node<T>> getBucketForKey(int key){
       return hashTable[getHash(key)];
    }

    @Override
    public void delete(int key) {
        getBucketForKey(key).remove(findNode(key));
    }

    @Override
    public void show() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print("[" + i + "] : ");
            hashTable[i].forEach(n -> System.out.printf("-> (%d:%s)", n.key, n.value.toString()));
            System.out.println("");
        }
    }

    private static class Node<T> {
        int key;
        T value;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

    }

    private int getHash(int key) {
        return hashFunction.getHash(key, hashTable.length);
    }
}
