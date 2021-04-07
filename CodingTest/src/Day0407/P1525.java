package Day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Sort{
	Matrix m;
	Queue<Matrix> list = new LinkedList<>();
	int[][] answer = {{1,2,3},{4,5,6},{7,8,0}};

	Sort(int[][] init){
		m = new Matrix(init);
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

	void run() {
		list.offer(m);
		while(!list.isEmpty()) {
			Matrix matrix = list.peek();		// 여기서 matrix가 list에 담긴 Matrix의 주소값까지 담아오는게 문제인듯
			if(matrix.empty.x - 1 >= 0) {
				matrix.moveR();
				if(check(matrix.arr)) {
					System.out.println(matrix.moveCnt);
					break;
				}
				list.offer(matrix);
			}
			
			matrix = list.peek();
			if(matrix.empty.x + 1 < 3) {
				matrix.moveL();
				if(check(matrix.arr)) {
					System.out.println(matrix.moveCnt);
					break;
				}
				list.offer(matrix);
			}
			
			matrix = list.peek();
			if(matrix.empty.y - 1 >= 0) {
				matrix.moveD();
				if(check(matrix.arr)) {
					System.out.println(matrix.moveCnt);
					break;
				}
				list.offer(matrix);
			}
			
			matrix = list.peek();
			if(matrix.empty.y + 1 < 3) {
				matrix.moveU();
				if(check(matrix.arr)) {
					System.out.println(matrix.moveCnt);
					break;
				}
				list.offer(matrix);
			}
			
			list.poll();
			break;
		}
	}
}

class Matrix{
	int[][] arr;
	Code empty;
	int moveCnt;
	
	Matrix(int[][] arr){
		this.arr = arr;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j] == 0)
					this.empty = new Code(i,j);
			}
		}
		this.moveCnt = 0;
	}
	
	void moveR() {
		int temp = arr[empty.y][empty.x - 1];
		arr[empty.y][empty.x - 1] = 0;
		arr[empty.y][empty.x] = temp;
		empty.x -= 1;
		this.moveCnt += 1;
		System.out.println("Move Right");
		print(arr);
	}

	void moveL() {
		int temp = arr[empty.y][empty.x + 1];
		arr[empty.y][empty.x + 1] = 0;
		arr[empty.y][empty.x] = temp;
		empty.x += 1;
		this.moveCnt += 1;
		System.out.println("Move Left");
		print(arr);
	}

	void moveD() {
		int temp = arr[empty.y - 1][empty.x];
		arr[empty.y - 1][empty.x] = 0;
		arr[empty.y][empty.x] = temp;
		empty.y -= 1;
		this.moveCnt += 1;
		System.out.println("Move Down");
		print(arr);
	}

	void moveU() {
		int temp = arr[empty.y + 1][empty.x];
		arr[empty.y + 1][empty.x] = 0;
		arr[empty.y][empty.x] = temp;
		empty.y += 1;
		this.moveCnt += 1;
		System.out.println("Move Up");
		print(arr);
	}
	
	void print(int[][] matrix) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
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

public class P1525 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[3][3];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Sort m = new Sort(arr);
		m.run();
		
	}
}
