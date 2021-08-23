package d210331;

import java.util.*;

class DFS{
	int v;
	int[][] graph;
	boolean[] visited;
	
	DFS(int v, int[][] lines){
		this.v = v;
		this.graph = new int[v+1][v+1];
		for(int i=0; i<lines.length; i++) {
			this.graph[lines[i][0]][lines[i][1]] = this.graph[lines[i][1]][lines[i][0]] = 1;
		}
		this.visited = new boolean[v+1];
	}
	
	void root(int init) {
		
		this.visited[init] = true;
		System.out.print(init + " ");
		
		for(int i=1; i<=v; i++) {
			if(graph[init][i] == 1 && !visited[i]) {
				root(i);
			}
		}
	}
	
}

class BFS{
	int v;
	int[][] graph;
	Map<Integer, Boolean> visited;
	Queue<Integer> check;
	
	BFS(int v, int[][] lines){
		this.v = v;
		this.graph = new int[v+1][v+1];
		visited = new HashMap<>();
		for(int i=0; i<lines.length; i++) {
			this.graph[lines[i][0]][lines[i][1]] = this.graph[lines[i][1]][lines[i][0]] = 1;
			visited.put(lines[i][0],false);
			visited.put(lines[i][1],false);
		}
		check = new LinkedList<>();
	}
	
	void root(int init) {
		check.offer(init);
		visited.put(init, true);
		
		while(!check.isEmpty()) {
			int p = check.poll();
			System.out.print(p + " ");
			
			for(int i=1; i<=v; i++) {
				if (graph[p][i] == 1 && !visited.get(i)) {
					check.offer(i);
					visited.put(i,true);
				}
			}
			
		}
	}
	
}

public class P1260 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] tempInput = input.split(" ");
		
		int v = Integer.parseInt(tempInput[0]);
		int e = Integer.parseInt(tempInput[1]);
		int init = Integer.parseInt(tempInput[2]);
		
		int[][] lines = new int[e][2];
		
		for(int i=0; i<e; i++) {
			String temp = scan.nextLine();
			String[] in = temp.split(" ");
			lines[i][0] = Integer.parseInt(in[0]);
			lines[i][1] = Integer.parseInt(in[1]);
		}
		
		DFS dfs = new DFS(v,lines);
		BFS bfs = new BFS(v,lines);
		dfs.root(init);
		System.out.println();
		bfs.root(init);
		
	}
}
