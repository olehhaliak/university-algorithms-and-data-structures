import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Graph {

    public Set<Integer> vertexes = new HashSet<>();
    public List<Edge> edges = new ArrayList<>();

    public static class Edge implements Comparable<Edge> {
        int v1, v2, weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public boolean connectedTo(int vertex) {
            return v1 == vertex || v2 == vertex;
        }

        public boolean connectedToAny(Iterable<Integer> vertexes) {
            for (Integer v : vertexes) {
                if (connectedTo(v)) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }

        @Override
        public String toString() {
            return v1 + " - " + v2 + ", weight: " + weight;
        }
    }

    public void addEdge(int v1,int v2,int weight){
        vertexes.add(v1);
        vertexes.add(v2);
        edges.add(new Edge(v1,v2,weight));
    }
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.vertexes.add(0);
        graph.vertexes.add(1);
        graph.vertexes.add(2);
        graph.vertexes.add(3);
        graph.vertexes.add(4);
        graph.edges.add(new Edge(0, 1, 5));
        graph.edges.add(new Edge(1, 4, 7));
        graph.edges.add(new Edge(4, 3, 8));
        graph.edges.add(new Edge(3, 0, 3));
        graph.edges.add(new Edge(2, 0, 4));
        graph.edges.add(new Edge(2, 1, 2));
        graph.edges.add(new Edge(2, 3, 3));
        graph.edges.add(new Edge(2, 4, 4));
        graph.print();
        graph.prim();
        System.out.println("-----------------");
        graph.print();
    }

    private boolean vertexesConnected(Set<Set<Integer>> vertexes, Integer v1, Integer v2) {
        return vertexes.stream().anyMatch(v -> v.containsAll(Set.of(v1, v2)));
    }

    private void merge(Map<Set<Integer>, Set<Integer>> vertexes, Integer v1, Integer v2) {
        Set<Integer> v1Set = vertexes.keySet().stream().filter(s -> s.contains(v1)).findFirst().get();
        Set<Integer> v2Set = vertexes.keySet().stream().filter(s -> s.contains(v2)).findFirst().get();
        vertexes.remove(v2Set);
        vertexes.remove(v1Set);
        Set<Integer> mergedSet = new HashSet<>();
        mergedSet.addAll(v1Set);
        mergedSet.addAll(v2Set);
        vertexes.put(mergedSet, mergedSet);
    }

    public void kruskal() {
        int totalVertexes = vertexes.size();
        Map<Set<Integer>, Set<Integer>> connectedVertexes = new HashMap<>();
        for (Integer vertex : vertexes) {
            Set<Integer> set = Set.of(vertex);
            connectedVertexes.put(set, set);
        }

        List<Edge> spanningTreeEdges = new ArrayList<>();

        for (Edge edge : edges.stream().sorted().collect(Collectors.toList())) {
            if (vertexesConnected(connectedVertexes.keySet(), edge.v1, edge.v2)) {
                continue;
            }
            spanningTreeEdges.add(edge);
            merge(connectedVertexes, edge.v1, edge.v2);
            if (connectedVertexes.size() == totalVertexes) {
                break;
            }
        }
        edges = spanningTreeEdges;
    }

    public void prim() {
        List<Edge> spanningTreeEdges = new ArrayList<>();
        Set<Integer> visitedVertexes = new HashSet<>();
        Set<Integer> notVisitedVertexes = new HashSet<>(vertexes);
        visitedVertexes.add(vertexes.stream().findFirst().get());
        notVisitedVertexes.remove(vertexes.stream().findFirst().get());
        for (int i = 0; i < vertexes.size() - 1; i++) {
            Edge e =edges.stream()
                    .filter(edge -> edge.connectedToAny(visitedVertexes))
                    .filter(edge -> edge.connectedToAny(notVisitedVertexes))
                    .sorted()
                    .findFirst().get();
            visitedVertexes.add(e.v1);
            visitedVertexes.add(e.v2);
            notVisitedVertexes.remove(e.v1);
            notVisitedVertexes.remove(e.v2);
            spanningTreeEdges.add(e);
        }
        edges = spanningTreeEdges;
    }

    public void print() {
        edges.stream().forEach(System.out::println);
    }
}