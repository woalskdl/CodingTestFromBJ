package d210401;

import java.util.Scanner;

class Map{
	
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	
	int[][] map;
	int number;
	boolean[][] visited;
	int a;
	int b;
	
	Map(int a, int b, int[][] map){
		this.a = a;
		this.b = b;
		this.map = map;
		this.visited = new boolean[a][b]; 
	}
	
	void printNum() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					number ++;
					dfs(i,j);
				}
			}
		}
		System.out.println(number);
	}
	
	void dfs(int i, int j) {
		visited[i][j] = true;
		for(int n=0; n<4; n++) {
			int nx = j + dx[n];
			int ny = i + dy[n];
			
			if(nx < b && ny < a && nx >= 0 && ny >= 0) {
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny,nx);
				}
			}
		}
	}
}

public class P1012 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		int T = Integer.parseInt(input);
		
		Map[] m = new Map[T];
		
		for(int i=0; i<T; i++) {
			String line = scan.nextLine();
			String[] t = line.split(" ");
			int a = Integer.parseInt(t[1]);
			int b = Integer.parseInt(t[0]);
			int[][] map = new int[a][b];
			int n = Integer.parseInt(t[2]);
			for(int j=0; j<n; j++) {
				String l = scan.nextLine();
				String[] e = l.split(" ");
				map[Integer.parseInt(e[1])][Integer.parseInt(e[0])] = 1;
			}
			
			m[i] = new Map(a,b,map);
		}
		
		for(int i=0; i<T; i++)
			m[i].printNum();
	}
}
