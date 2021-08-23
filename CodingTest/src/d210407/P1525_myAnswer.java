package d210407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Sort{
	Matrix1 m;
	Queue<Matrix1> list = new LinkedList<>();
	int[][] answer = {{1,2,3},{4,5,6},{7,8,0}};

	Sort(int[][] init, int moveCnt){
		this.m = new Matrix1(init, moveCnt);
	}
	
	boolean check(int[][] arr) {
		int cnt = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j] == answer[i][j])
					cnt ++;
			}
		}
		
		if(cnt == 9)
			return true;
		else
			return false;
	}
	
	int[][] copy(int[][] arr){
		int[][] result = new int[3][3];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				result[i][j] = arr[i][j];
			}
		}
		
		return result;
	}

	void run() {
		list.offer(m);
		while(!list.isEmpty()) {
			Matrix1 matrix = list.poll();
			
			int moveCnt = matrix.moveCnt;
			System.out.println(moveCnt);
			if(moveCnt > 9 * 9) {
				System.out.println(-1);
				break;
			}
			
			int y = matrix.empty.y;
			int x = matrix.empty.x;
			
			if(x - 1 >= 0) {
				int[][] arr = copy(matrix.arr);
				
				int temp = arr[y][x - 1];
				arr[y][x - 1] = 0;
				arr[y][x] = temp;
				
				print(arr);
				
				Matrix1 R = new Matrix1(arr, moveCnt + 1);
				
				if(check(arr)) {
					System.out.println(R.moveCnt);
					break;
				}
				
				list.offer(R);
			}
			
			if(x + 1 < 3) {
				int[][] arr = copy(matrix.arr);
				
				int temp = arr[y][x + 1];
				arr[y][x + 1] = 0;
				arr[y][x] = temp;
				
				print(arr);

				Matrix1 L = new Matrix1(arr, moveCnt + 1);
				
				if(check(arr)) {
					System.out.println(L.moveCnt);
					break;
				}
				list.offer(L);
			}
			
			if(y - 1 >= 0) {
				int[][] arr = copy(matrix.arr);
				
				int temp = arr[y - 1][x];
				arr[y - 1][x] = 0;
				arr[y][x] = temp;
				
				print(arr);

				Matrix1 D = new Matrix1(arr, moveCnt + 1);
				
				if(check(arr)) {
					System.out.println(D.moveCnt);
					break;
				}
				list.offer(D);
			}
			
			if(y + 1 < 3) {
				int[][] arr = copy(matrix.arr);
				
				int temp = arr[y + 1][x];
				arr[y + 1][x] = 0;
				arr[y][x] = temp;
				
				print(arr);

				Matrix1 U = new Matrix1(arr, moveCnt + 1);
				
				if(check(arr)) {
					System.out.println(U.moveCnt);
					break;
				}
				list.offer(U);
			}
		}
	}
	
	void print(int[][] arr) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Matrix1{
	int[][] arr;
	Code empty;
	int moveCnt;
	
	Matrix1(int[][] arr, int moveCnt){
		this.arr = arr;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j] == 0)
					this.empty = new Code(i,j);
			}
		}
		this.moveCnt = moveCnt;
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

public class P1525_myAnswer {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[3][3];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Sort m = new Sort(arr, 0);
		m.run();
		
	}
}
