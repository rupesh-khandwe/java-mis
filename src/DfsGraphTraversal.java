import java.util.*;
/*
Complexity Analysis:
Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Space Complexity :O(V).
Since an extra visited array is needed of size V.
 */
public class DfsGraphTraversal {
    private int vertex;
    private LinkedList<Integer>[] adjcent;

    DfsGraphTraversal(int v) {
        this.vertex = v;
        adjcent = new LinkedList[v];
        for (int i = 0; i < this.vertex; i++)
            adjcent[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adjcent[v].add(w);
    }

    private void DFSUtil(int i, boolean[] visited) {
        //Mark the current node as visited
        visited[i] = true;
        System.out.println(i + " ");
        Iterator<Integer> itr = adjcent[i].listIterator();
        while (itr.hasNext()) {
            int num = itr.next();
            if (!visited[num])
                DFSUtil(num, visited);
        }
    }


    public void DFS() {
        /*
        Mark all the vertices as not visited, set as false by default
        */
        boolean[] visited = new boolean[this.vertex];
        for (int i = 0; i < this.vertex; i++)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }


    public static void main(String args[]) {
        //int[][] graphEdges = {{0,1},{0,2},{1,2},{2,3},{3,3}};
        DfsGraphTraversal dfGraph = new DfsGraphTraversal(5);
        /*dfGraph.addEdge(0, 1);
        dfGraph.addEdge(0, 2);
        dfGraph.addEdge(1, 2);
        dfGraph.addEdge(2, 0);
        dfGraph.addEdge(2, 3);
        dfGraph.addEdge(3, 3);*/
        dfGraph.addEdge(0,1);
        dfGraph.addEdge(1,4);
        dfGraph.addEdge(1,2);
        dfGraph.addEdge(2,4);
        dfGraph.addEdge(2,3);
        dfGraph.addEdge(3,3);
        System.out.println("Following is Depth First Traversal");
        dfGraph.DFS();

    }
}
