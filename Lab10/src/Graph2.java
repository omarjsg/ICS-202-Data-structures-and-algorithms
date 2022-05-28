import java.util.*; 

class Graph2 {
        int numVertices; 
        LinkedList<String>[] adjacencyList;
        String[] labels;
        public Graph2 (int numVertices, String[] labels) {
            this.numVertices = numVertices; 
            adjacencyList = new LinkedList[numVertices]; 
            for (int i = 0; i < adjacencyList.length; i++){
                adjacencyList[i] = new LinkedList<String>(); 
                }
            this.labels = labels;
        }

        //To add a directed edge to graph 
        void addDirectedEdge(int v, int w)  { 

            adjacencyList[v].add(labels[w]); // Add w to v�s list.
        }

         //To add undirected edge to graph 
        void addUndirectedEdge(int v, int w) {          
            adjacencyList[v].add(labels[w]); 
            adjacencyList[w].add(labels[v]);                
        } 
        void displayGraph(){
           for (int i = 0; i < adjacencyList.length; i++){  
               System.out.println(i + " ----> " + adjacencyList[i]);
               System.out.println(); 
            } 
       } 
   }

