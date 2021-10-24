import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Choose hashtable implementation:");
        System.out.println("1)Open adressed");
        System.out.println("2)Chained");
        switch (scn.next()) {
            case "1":
                openAddressDemo();
                break;
            case "2":
                chainedDemo();
                break;
            default:
                System.out.println("Wrong input, exiting...");
        }
    }

    public static void chainedDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of buckets:");
        int countOfBuckets = scanner.nextInt();
        System.out.println("Which hash algorithm to use:");
        System.out.println("1) Division");
        System.out.println("2) Multiplication");
        HashFunction function = null;
        boolean proceed = false;
        while (!proceed) {
            switch (scanner.next()) {
                case "1":
                    function = new HashFunction.DivisionHashFunction();
                    proceed = true;
                    break;
                case "2":
                    function = new HashFunction.MultiplicationHashFunction();
                    proceed = true;
                    break;
                default:
                    System.out.println("Wrong input, try again...");
            }
        }
        Hash<Integer> hash = new ChainedHash<>(countOfBuckets, function);
        demo(hash);
    }

    public static void openAddressDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of buckets:");
        int countOfBuckets = scanner.nextInt();
        System.out.println("Which probing algorithm to use:");
        System.out.println("1) Linear");
        System.out.println("2) Quadratic");
        System.out.println("3) Double");
        Probing probing = null;
        boolean proceed = false;
        while (!proceed) {
            switch (scanner.next()) {
                case "1":
                    probing = Probing.LINEAR;
                    proceed = true;
                    break;
                case "2":
                    probing = Probing.QUADRATIC;
                    proceed = true;
                    break;
                case "3":
                    probing = Probing.DOUBLE;
                    proceed = true;
                    break;
                default:
                    System.out.println("Wrong input, try again...");
            }
        }
        Hash<Integer> hash = new OpenAddressHash<>(countOfBuckets, probing);
        demo(hash);
    }

    public static void demo(Hash<Integer> hash) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("Choose option:");
            System.out.println("1)Insert");
            System.out.println("2)Delete");
            System.out.println("3)Find by key");
            System.out.println("q)Exit");
            System.out.print(">> ");
            switch (scn.next()) {
                case "1":
                    System.out.println("Enter key and value, separated by space(e.g [1 15]):");
                    hash.insert(scn.nextInt(), scn.nextInt());
                    break;
                case "2":
                    System.out.println("enter key of element to delete:");
                    hash.delete(scn.nextInt());
                    break;
                case "3":
                    System.out.println("enter key of element to find:");
                    Integer value = hash.search(scn.nextInt());
                    System.out.println(value != null ? "Value is : " + value : "Value was not found");
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input, try again...");
            }
            hash.show();
        }
    }


}
