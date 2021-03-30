package Day0330;

import java.util.*;

class Find7{
	
	int[] heights;
	int total;
	
	Find7(int[] heights){
		this.heights = heights;
		for(int i=0; i<heights.length; i++) {
			this.total += heights[i];
		}
	}
	
	void find7() {
		for(int i=0; i<heights.length-1; i++) {
			for(int j=i+1; j<heights.length; j++) {
				if(total - (heights[i] + heights[j]) == 100) {
					print(heights, heights[i], heights[j]);
					return;
				}
			}
		}
	}
	
	void print(int[] arr, int a, int b) {
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			if(heights[i] != a && heights[i] != b)
				System.out.println(arr[i]);
		}
	}
	
}

public class P2309 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] heights = new int[9];
		
		for(int i=0; i<9; i++) {
			String height = scan.next();
			heights[i] = Integer.parseInt(height);
		}
		
		Find7 find = new Find7(heights);
		find.find7();
	}
}
