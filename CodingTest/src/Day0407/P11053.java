package Day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Array{
	int[] arr;
	int n;
	int[] length;
	
	Array(int[] arr){
		this.arr = arr;
		this.n = arr.length;
		this.length = new int[n];
	}
	
	
	void get() {
		for(int i=0; i<n; i++) {
			length[i] = 1;
			
			for(int j=0; j<i; j++)
				if(arr[i] > arr[j])
					if(length[i] < length[j] + 1)
						length[i] = length[j] + 1;
		}
		
		Arrays.sort(length);
		System.out.println(length[n-1]);
	}
}

public class P11053 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Array array = new Array(arr);
		array.get();
	}
}
