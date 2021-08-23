package d210329;

import java.util.*;

class HAS{
	int[] check = new int[100001];
	boolean[] c = new boolean[100001];
	int pA;
	int pB;
	
	HAS(int a, int b) {
		this.pA = a;
		this.pB = b;
		c[a] = true;
	}
	
	int run() {
		Queue<Integer> track = new LinkedList<>();
		
		while(pA != pB) {
			
			if(pA + 1 < c.length) {
				if(!c[pA + 1]) {
					track.offer(pA + 1);
					check[pA + 1] = check[pA] + 1;
					c[pA + 1] = true;
				}
			}
			
			if(pA - 1 >= 0) {
				if(!c[pA - 1]) {
					track.offer(pA - 1);
					check[pA - 1] = check[pA] + 1;
					c[pA - 1] = true;
				}
			}
			
			if(pA * 2 < c.length) {
				if(!c[pA * 2]) {
					track.offer(pA * 2);
					check[pA * 2] = check[pA] + 1;
					c[pA * 2] = true;
				}
			}
			
			pA = track.poll();
		}
		
		return check[pA];
	}
	
}

public class P1697 {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
	
	int N = scan.nextInt();
	int K = scan.nextInt();
	
	HAS h = new HAS(N,K);
	System.out.println(h.run());
	
		
	}
}
