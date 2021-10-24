import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BtreeDemo {
    public static void main(String[] args) {
        BinaryTree<Integer> btree = fillBtree();
        System.out.println("Your tree:");
        btree.print();
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Choose option:");
            System.out.println("1) Insert new val");
            System.out.println("2) Delete val");
            System.out.println("3) Get successor");
            System.out.println("4) Get predecessor");
            System.out.println("5) Check if contains value");
            System.out.println("q) Exit");
            System.out.print(">> ");
            String input = scn.next();

            switch (input) {
                case "1":
                    System.out.println("Enter val to insert:");
                    btree.insert(scn.nextInt());
                    break;
                case "2":
                    System.out.println("Enter val to delete:");
                    btree.delete(scn.nextInt());
                    break;
                case "3":
                    System.out.println("Enter val, successor of which to find:");
                    System.out.println("Successor : "+btree.getSuccessor(scn.nextInt()));
                    break;
                case "4":
                    System.out.println("Enter val, predecessor of which to find:");
                    System.out.println("Predecessor is : "+btree.getPredecessor(scn.nextInt()));
                    break;
                case "5":
                    System.out.println("Enter val to search for:");
                    System.out.println(btree.contains(scn.nextInt())?"yes, btree contains this value":"no,btree doesn`t conain this value");
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println("Bad input, try again");
            }
            System.out.println("BTree:");
            btree.print();
            System.out.println("-----------------------------");
        }
    }

    private static BinaryTree<Integer> fillBtree() {
        System.out.println("Enter values to be inserted in binary tree, separated by space:");
        List<Integer> vals = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        Arrays.stream(scn.nextLine().trim().split(" ")).forEach(V->vals.add(Integer.parseInt(V)));
        return new BinaryTreeImpl<Integer>(vals);
    }
}
