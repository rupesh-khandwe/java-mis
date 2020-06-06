import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalNetworkConnection {
    boolean[] visited;      // Whether we visited this node before
    List<Integer>[] graph;  // Adjacent list of the graph
    int[] low;              // Low value of this node: lowest id this node can reach
    int[] ids;              // Id of this node
    int id;                 // Current id
    List<List<Integer>> ans;// List of all the critical connections


    public List<List<Integer>> criticalConnections(int n, int[][] connections) {
        // Init the instance variables
        visited = new boolean[n];
        graph = new List[n];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        low = new int[n];
        ids = new int[n];
        id = 0;
        ans = new ArrayList<>();

        // Init the graph adjacent list
        for(int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }

        // Run DFS from every possible nodes in the graph
        id = 0;
        for(int i = 0; i < n; i++) {
            // Start DFS from node i with no parent
            if(!visited[i]) DFS(i, -1);
        }

        return ans;
    }


    private void DFS(int at, int parent) {
        visited[at] = true;
        ids[at] = ++id;
        low[at] = ids[at];

        // For edge from "at" to "to"
        for(int to : graph[at]) {
            if(to == parent) continue; // Avoid duplicates: [1, 3] and [3, 1]

            if(!visited[to]) {
                DFS(to, at);
                low[at] = Math.min(low[at], low[to]); // Update low when children nodes reach nodes with lower id

                // If there is no other way between "at" and "to", this edge is a critical connection
                if(ids[at] < low[to]) {
                    ans.add(Arrays.asList(at, to));
                }

            } else {
                low[at] = Math.min(low[at], ids[to]); // Update low[at] because of the edge from "at" to "to"
                // ??: Can we use low[at] = Math.min(low[at], low[to]); here?
            }
        }
    }

    public static void main(String args[]){
        CriticalNetworkConnection cnc = new CriticalNetworkConnection();
        List<List<Integer>> ans= new ArrayList<>();
        int[][] inputArr = {{0,1},{1,2},{2,0},{1,3}};

        ans = cnc.criticalConnections(4, inputArr);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
