public class OpenAddressHash<T> implements Hash<T> {

    private static class Node<T> {
        int key;
        T value;
        boolean isDeleted;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("(%d:%s)", key, value.toString());
        }
    }


    Node<T>[] hashTable;
    private Probing probing;

    public OpenAddressHash(int size, Probing probing) {
        this.hashTable = new Node[size];
        this.probing = probing;
    }

    @Override
    public void insert(int key, T value) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[probing.getHash(key, i, hashTable.length)] == null) {
                hashTable[probing.getHash(key, i, hashTable.length)] = new Node<>(key, value);
                return;
            }
        }
        System.out.println("Failed to insert this key (either hashtable is full or this probing algorithm is not able to find free bucket)!");
    }

    @Override
    public T search(int key) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[probing.getHash(key, i, hashTable.length)] != null
                    && hashTable[probing.getHash(key, i, hashTable.length)].key == key) {
                return hashTable[probing.getHash(key, i, hashTable.length)].value;
            }
        }
        System.out.println("Hashtable does not contain such key!");
        return null;
    }

    @Override
    public void delete(int key) {
        for (int i = 0; i < hashTable.length; i++) {

            if (hashTable[probing.getHash(key, i, hashTable.length)] != null
                    && hashTable[probing.getHash(key, i, hashTable.length)].key == key) {
                hashTable[probing.getHash(key, i, hashTable.length)] = null;
                return;
            }
        }
        System.out.println("Hashtable does not contain such key!");
    }

    @Override
    public void show() {
        System.out.println("[hash] -> (key:value)");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("[" + i + "] -> " + (hashTable[i] != null ? hashTable[i] : ""));
        }
    }

}
