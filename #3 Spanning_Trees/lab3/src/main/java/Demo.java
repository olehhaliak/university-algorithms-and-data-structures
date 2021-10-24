import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter edges of graph in the following format: \"[source] [destination] [weight]\"");
        System.out.println("enter \"S\" to stop entering new edges");
        Graph graph = new Graph();
        try {
            while (true) {
                System.out.print(">>");
                graph.addEdge(scn.nextInt(), scn.nextInt(), scn.nextInt());
            }
        } catch (Exception e) {
        }
        System.out.println("your graph:");
        graph.print();
        while (true) {
            scn = new Scanner(System.in);
            System.out.println("Choose algorithm to build a spanning tree");
            System.out.println("1)Kruskal`s");
            System.out.println("2)Prim`s");
            switch (scn.next()) {
                case "1":
                    graph.kruskal();
                    System.out.println("your graph after Kruskal`s algorithm :");
                    graph.print();
                    System.exit(0);
                    break;
                case "2":
                    graph.prim();
                    System.out.println("your graph after Prim`s algorithm :");
                    graph.print();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong option,try again");
            }
        }
    }
}
