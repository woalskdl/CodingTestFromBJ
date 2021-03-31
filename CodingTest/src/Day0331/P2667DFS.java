package Day0331;

import java.util.Arrays;
import java.util.Scanner;

class Comp{
	int n;
	int[][] map;
	int[][] num;
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,-1,1};
	int[] compNum;
	int number = 0;
	
	Comp(int n, String[] map){
		this.n = n;
		this.map = new int[n][n];
		this.num = new int[n][n];
		this.compNum = new int[n*n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				this.map[i][j] = map[i].charAt(j) - '0'; 
			}
		}
	}
	
	void comp() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				if(map[i][j] == 1 && num[i][j] == 0) {
					number ++;
					dfs(i,j);
				}
	}
	
	void dfs(int x, int y) {
		num[x][y] = number;
		compNum[number] ++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < n && ny < n && nx >= 0 && ny >= 0)
				if(map[nx][ny] == 1 && num[nx][ny] == 0)
					dfs(nx,ny);
		}
	}
	
	void printResult() {
		System.out.println(number);
		Arrays.sort(compNum);
		for(int i=0; i<compNum.length; i++)
			if(compNum[i] != 0)
				System.out.println(compNum[i]);
	}
}

public class P2667DFS {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.nextLine());
		String[] map = new String[n];
		for(int i=0; i<n; i++) {
			map[i] = scan.nextLine();
		}
		
		Comp comp = new Comp(n, map);
		comp.comp();
		comp.printResult();
		
	}
}
