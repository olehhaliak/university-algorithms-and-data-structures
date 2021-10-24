@FunctionalInterface
public interface HashFunction {

    /**
     * @param value       - value, hash of which will be calculated
     * @param bucketCount - size of hashtable array
     * @return hash
     */
    int getHash(int value, int bucketCount);

    class DivisionHashFunction implements HashFunction {
        @Override
        public int getHash(int value, int bucketCount) {
            return value % bucketCount;
        }
    }

    class MultiplicationHashFunction implements HashFunction {
        //Golden ratio
        private static final float A = 0.6180339887F;

        @Override
        public int getHash(int value, int bucketCount) {
            return (int) (bucketCount *  ((value * A) % 1.));
        }
    }
}
