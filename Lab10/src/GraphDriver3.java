import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3), Edge.getEdge(1, 0), Edge.getEdge(1, 2), Edge.getEdge(1, 4),
                Edge.getEdge(2, 7), Edge.getEdge(3, 4), Edge.getEdge(3, 5), Edge.getEdge(4, 3), Edge.getEdge(4, 6),
                Edge.getEdge(5, 6), Edge.getEdge(6, 7));
        // Number of nodes in the graph (labelled from 0 to N-1)
        int numverOfVertices = 8;
        Graph3 graph = new Graph3(edges, numverOfVertices);
        System.out.print("Enter the source vertex [0 - " + (numverOfVertices - 1) + "]: ");
        int source = scanner.nextInt();
        System.out.print("Enter the destination vertex [0 - " + (numverOfVertices - 1) + "]: ");
        int distenation = scanner.nextInt();
        if (graph.isReachable(source, distenation)) {
            System.out.println("Path exists from vertex " + source + " vertex " + distenation);
        } else {
            System.out.println("No path exists from vertex " + source + " vertex " + distenation);
        }

    }
}