package Day0403;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato{
	int[][] box;
	int m;
	int n;
	int cnt = 0;
	int cntTomato = 0;
	int day;
	
	int[] dx = {0, 0, -1, 1};
	int[] dy = {-1, 1, 0, 0};
	
	Queue<int[]> list = new LinkedList<>();
	
	Tomato(int[][] box){
		this.box = box;
		this.m = box[0].length;
		this.n = box.length;
		this.day = 0;
		this.cntTomato = this.m * this.n;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 1) {
					int[] code = {i, j, this.day};
					list.offer(code);
					this.cnt ++;
				}
				
				if(box[i][j] == -1)
					this.cntTomato -= 1;
			}
		}
	}
	
	void result() {
		while(!this.list.isEmpty()) {
			while(true) {
				int[] code = list.peek();
				if(code == null) {
					break;
				}else if(code[2] == this.day) {
					int[] temp = list.poll();
					bfs(temp[0], temp[1]);
				}else
					break;
			}
			this.day += 1;
		}
		
		if(this.cnt != this.cntTomato)
			System.out.println(-1);
		else
			System.out.println(this.day - 1);
	}
	
	void bfs(int i, int j) {
		for(int n=0; n<4; n++) {
			int ny = i + dy[n];
			int nx = j + dx[n];
			
			if(nx >= 0 && ny >= 0 && nx < this.m && ny < this.n) {
				if(this.box[ny][nx] == 0) {
					this.box[ny][nx] = 1;
					int[] code = {ny, nx, this.day + 1};
					list.offer(code);
					this.cnt += 1;
				}
			}
		}
	}
}

public class P7576 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String line = scan.nextLine();
		String[] temp = line.split(" ");
		
		int m = Integer.parseInt(temp[0]);
		int n = Integer.parseInt(temp[1]);
		
		int[][] box = new int[n][m]; 
		
		for(int i=0; i<n; i++) {
			String l = scan.nextLine();
			String[] tp = l.split(" ");
			for(int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(tp[j]);
			}
		}
		
		Tomato t = new Tomato(box);
		t.result();
	}
}
