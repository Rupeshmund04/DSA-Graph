import java.util.*;

public class Graph_Matrix {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int v = sc.nextInt();
	    int e = sc.nextInt();
	    int adj[][] = new int[v][v];
	    for (int i = 0; i<e; i++) {
	        int src = sc.nextInt();
	        int dst = sc.nextInt();
	        adj[src][dst] = 1;
	        adj[dst][src] = 1;
	    }
	    System.out.println("Adjacency matrix: ");
	    for (int i = 0; i<v; i++) {
	        for (int j = 0; j<v; j++) {
	            System.out.print(adj[i][j] + " ");
	        }
	        System.out.println();
	    }
	    boolean visited[] = new boolean[v];
	    bfs(adj, visited, 0);
	    visited = new boolean[v];
	    dfs(adj, visited, 0);
	}
	
	public static void dfs(int adj[][], boolean visited[], int src) {
	    System.out.println("DFS Traversal of Undirected Graph: ");
	    Stack<Integer> st = new Stack<>();
	    st.push(src);
	    visited[src] = true;
	    while (!st.isEmpty()) {
	        int curr = st.pop();
	        System.out.print(curr + " ");
	        for (int i = adj.length-1; i>=0; i--) {
	            if (adj[curr][i] == 1 && !visited[i]) {
	                st.push(i);
	                visited[i] = true;
	            }
	        }
	    }
	}
	
	public static void bfs(int[][] adj, boolean visited[], int src) {
	    System.out.println("BFS Traversal of Undirected Graph: ");
	    Queue<Integer> q = new LinkedList<>();
	    q.add(src);
	    visited[src] = true;
	    while (!q.isEmpty()) {
	        int curr = q.poll();
	        System.out.print(curr + " ");
	        for (int i = 0; i<adj.length; i++) {
	            if (!visited[i] && adj[curr][i] == 1) {
	                q.add(i);
	                visited[i] = true;
	            }
	        }
	    }
	}
	
}