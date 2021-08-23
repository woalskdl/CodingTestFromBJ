package d210329;

import java.util.*;

class Maze{
	
	int y;
	int x;
	int[][] maze;
	int[] code = new int[2];
	
	Maze(int[][] m){
		this.y = m.length;
		this.x = m[0].length;
		this.maze = m;
	}
	
	int run() {
		int[][] check = new int[this.y][this.x];
		
		y -= 1;
		x -= 1;
		Queue<int[]> run = new LinkedList<>();
		check[code[0]][code[1]] = 1;

		while(!(y == code[0] && x == code[1])) {
			if(code[0] - 1 >= 0) {
				if(maze[code[0]-1][code[1]] == 1 && check[code[0]-1][code[1]] == 0) {
					check[code[0]-1][code[1]] = check[code[0]][code[1]] + 1;
					int y = code[0] - 1;
					int x = code[1];
					int[] temp = {y,x};
					run.offer(temp);
				}
			}

			if(code[1] - 1 >= 0) {
				if(maze[code[0]][code[1]-1] == 1 && check[code[0]][code[1]-1] == 0) {
					check[code[0]][code[1]-1] = check[code[0]][code[1]] + 1;
					int y = code[0];
					int x = code[1] - 1;
					int[] temp = {y,x};
					run.offer(temp);
				}
			}

			if(code[0] + 1 < check.length) {
				if(maze[code[0]+1][code[1]] == 1 && check[code[0]+1][code[1]] == 0) {
					check[code[0]+1][code[1]] = check[code[0]][code[1]] + 1;
					int y = code[0] + 1;
					int x = code[1];
					int[] temp = {y,x};
					run.offer(temp);
				}
			}
			
			if(code[1] + 1 < check[code[0]].length) {
				if(maze[code[0]][code[1]+1] == 1 && check[code[0]][code[1]+1] == 0) {
					check[code[0]][code[1]+1] = check[code[0]][code[1]] + 1;
					int y = code[0];
					int x = code[1] + 1;
					int[] temp = {y,x};
					run.offer(temp);
				}
			}
			
			code = run.poll();
		}
		
		return check[code[0]][code[1]];
		
	}
	
}

public class P2178 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] temp = input.split(" ");
		int[][] m = new int[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
		for(int i=0; i<m.length; i++) {
			String t = scan.next();
			for(int j=0; j<m[i].length; j++) {
				m[i][j] = t.charAt(j) - '0';
			}
		}
		
		Maze maze = new Maze(m);
		System.out.println(maze.run());
	}
}
