public abstract class Probing {
    public static final Probing LINEAR = new LinearProbing();
    public static final Probing QUADRATIC = new QuadraticProbing();
    public static final Probing DOUBLE = new DoubleProbing();
    /**
     * @param key
     * @param i
     * @param size
     * @return hash of the key on a given iteration i
     */
    abstract int getHash(int key, int i, int size);

    private static class LinearProbing extends Probing {
        HashFunction hash = new HashFunction.MultiplicationHashFunction();

        @Override
        int getHash(int key, int i, int size) {
            return (hash.getHash(key, size) + i) % size;
        }
    }

    private static class QuadraticProbing extends Probing {
        HashFunction hash = new HashFunction.MultiplicationHashFunction();

        @Override
        int getHash(int key, int i, int size) {
            return (hash.getHash(key, size) + i * i + i) % size;
        }
    }

    private static class DoubleProbing extends Probing {
        HashFunction hash1 = new HashFunction.DivisionHashFunction();
        HashFunction hash2 = new HashFunction.MultiplicationHashFunction();

        @Override
        int getHash(int key, int i, int size) {
            return (hash1.getHash(key, size) + i * hash2.getHash(key, size)) % size;
        }
    }

}