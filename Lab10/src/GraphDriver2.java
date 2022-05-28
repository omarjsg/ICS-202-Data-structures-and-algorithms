
public class GraphDriver2 {     
    // Driver program to test methods of graph class 
    public static void main(String[] args)  { 
        // Total 5 vertices in graph 
        String[] labels = {"A","B","C","D","E"};
        Graph2 graph = new Graph2(5, labels);
        graph.addDirectedEdge(1, 0); 
        graph.addDirectedEdge(0, 2); 
        graph.addDirectedEdge(2, 1); 
        graph.addDirectedEdge(0, 3); 
        graph.addDirectedEdge(1, 4); 
        System.out.println("The directed graph is:  "); 
        graph.displayGraph(); 
        Graph2 graph2 = new Graph2(5, labels);
        graph2.addUndirectedEdge(1, 0); 
        graph2.addUndirectedEdge(0, 2); 
        graph2.addUndirectedEdge(2, 1); 
        graph2.addUndirectedEdge(0, 3); 
        graph2.addUndirectedEdge(1, 4); 
        System.out.println("The undirected graph is:  "); 
        graph2.displayGraph(); 
    } 
} 
