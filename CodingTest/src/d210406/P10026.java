package d210406;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Color{
	int n;
	char[][] color;
	char[][] colorless;
	int nColor = 0;
	int nColorless = 0;
	Queue<Code> list;
	
	boolean[][] visitedC;
	boolean[][] visitedCL;
	
	int[] dx = {0, 0, -1, 1};
	int[] dy = {-1, 1, 0, 0};
	
	Color(int n, char[][] color){
		this.n = n;
		this.color = color;
		list = new LinkedList<>();
		visitedC = new boolean[n][n];
		visitedCL = new boolean[n][n];
		this.colorless = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(color[i][j] == 'G')
					colorless[i][j] = 'R';
				else
					colorless[i][j] = color[i][j];
			}
		}
	}
	
	void result() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visitedC[i][j]) {
					bfs(i, j, color, visitedC);
					nColor += 1;
				}
				if(!visitedCL[i][j]) {
					bfs(i, j, colorless, visitedCL);
					nColorless += 1;
				}
			}
		}
		System.out.println(nColor + " " + nColorless);
	}
	
	
	void bfs(int i, int j, char[][] arr, boolean[][] visited) {
		visited[i][j] = true;
		Code c = new Code(i,j);
		list.offer(c);
		while(!list.isEmpty()) {
			c = list.poll();
			i = c.y;
			j = c.x;
			
			for(int n=0; n<4; n++) {
				int nx = j + dx[n];
				int ny = i + dy[n];
				
				if(nx >= 0 && nx < this.n && ny >= 0 && ny < this.n)
					if(arr[ny][nx] == arr[i][j] && !visited[ny][nx]) {
						visited[ny][nx] = true;
						c = new Code(ny, nx);
						list.offer(c);
					}
			}
		}
	}
}

class Code{
	int y;
	int x;
	
	Code(int y, int x){
		this.y = y;
		this.x = x;
	}
}

public class P10026 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String num = scan.nextLine();
		int n = Integer.parseInt(num);
		
		char[][] color = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String line = scan.nextLine();
			for(int j=0; j<n; j++) {
				color[i][j] = line.charAt(j);
			}
		}
		
		Color c = new Color(n, color);
		c.result();
	}
}
