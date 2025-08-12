import java.util.*;

public class Graph_List {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int v = sc.nextInt();
	    int e = sc.nextInt();
	    List<List<Integer>> adj = new ArrayList<>();
	    for (int i = 0; i<v; i++) {
	        adj.add(new ArrayList<>());
	    }
	    for (int i = 0; i<e; i++) {
	        int src = sc.nextInt();
	        int dst = sc.nextInt();
	        addEdges(adj, src, dst);
	    }
	    for (int i = 0; i<adj.size(); i++) {
	        System.out.print("Vertex " + i + " : ");
	        for (int j = 0; j<adj.get(i).size(); j++) {
	            System.out.print(adj.get(i).get(j) + " ");
	        }
	        System.out.println();
	    }
	    boolean visited[] = new boolean[v];
	    bfs(adj, visited, 0);
	    visited = new boolean[v];
	    dfs(adj, visited, 0);
	}
	
	public static void dfs(List<List<Integer>> adj, boolean visited[], int src) {
	    System.out.println("DFS Traversal of Undirected Graph: ");
	    Stack<Integer> st = new Stack<>();
	    st.push(src);
	    visited[src] = true;
	    while (!st.isEmpty()) {
	        int curr = st.pop();
	        System.out.print(curr + " ");
	        List<Integer> neighbour = adj.get(curr);
	        for (int i = neighbour.size()-1; i>=0; i--) {
	            if (!visited[neighbour.get(i)]) {
	                st.push(neighbour.get(i));
	                visited[neighbour.get(i)] = true;
	            }
	        }
	    }
	}
	
	public static void bfs(List<List<Integer>> adj, boolean visited[], int src) {
	    System.out.println("BFS Traversal of Undirected Graph: ");
	    Queue<Integer> q = new LinkedList<>();
	    q.add(src);
	    visited[src] = true;
	    while (!q.isEmpty()) {
	        int curr = q.poll();
	        System.out.print(curr + " ");
	        for (int neighbour : adj.get(curr)) {
	            if (!visited[neighbour]) {
	                q.add(neighbour);
	                visited[neighbour] = true;
	            }
	        }
	    }
	}
	
	public static void addEdges(List<List<Integer>> adj, int u, int v) {
	    adj.get(u).add(v);
	    adj.get(v).add(u);
	}
}
