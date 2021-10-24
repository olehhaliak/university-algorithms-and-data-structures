public class HeapPrinter {
    public static void printHeap(int[] heap) {
        int currentIndex = 0;
        int height = getHeight(heap.length);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < (int)Math.pow(2,i)&&currentIndex<heap.length; j++) {
                printSpaces(height,i);
                if(j>0){
                    System.out.print("   ");
                }
                System.out.printf("%-3d",heap[currentIndex++]);
                printSpaces(height,i);
            }
            System.out.println();
        }
    }

    private static void printSpaces(int height,int currentLevel) {
        for (int j = 0; j < (Math.pow(2,height-currentLevel)*2)-3 ; j++) {
            System.out.print(" ");
        }
    }

    public static int getHeight(int length) {
        int height = 0;
        while (length - ((int) Math.pow(2, height)) >= 0) {
            height++;
        }
        return height;
    }
}
