package Day0331;

import java.util.*;

class Complex{
	int n;
	int[][] complex;
	int[][] num;
	
	Complex(int n, String[] map){
		this.n = n;
		this.complex = new int[n][n];
		this.num = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				complex[i][j] = (int)(map[i].charAt(j) - '0');
			}
		}
	}
	
	void comp() {
		Queue<int[]> check = new LinkedList<>();
		ArrayList<Integer> homeCnt = new ArrayList<>();
		
		int number = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(complex[i][j] == 1 && num[i][j] == 0) {
					num[i][j] = ++number;
					int cnt = 0;
					int[] address = {i,j};
					check.offer(address);
					
					while(!check.isEmpty()) {
						
						int[] t = check.poll();
						int p = t[0];
						int q = t[1];
						cnt++;
						
						if(p+1 < n) {
							if(complex[p+1][q] == 1 && num[p+1][q] == 0) {
								int[] temp = {p+1,q};
								check.offer(temp);
								num[p+1][q] = number;
							}
						}
						
						if(q+1 < n) {
							if(complex[p][q+1] == 1 && num[p][q+1] == 0) {
								int[] temp = {p,q+1};
								check.offer(temp);
								num[p][q+1] = number;
							}
						}
						
						if(p-1 >= 0) {
							if(complex[p-1][q] == 1 && num[p-1][q] == 0) {
								int[] temp = {p-1,q};
								check.offer(temp);
								num[p-1][q] = number;
							}
						}
						
						if(q-1 >= 0) {
							if(complex[p][q-1] == 1 && num[p][q-1] == 0) {
								int[] temp = {p,q-1};
								check.offer(temp);
								num[p][q-1] = number;
							}
						}
					}
					homeCnt.add(cnt);
				}
			}
		}
		
		System.out.println(number);
		Collections.sort(homeCnt);
		for(Integer i : homeCnt)
			System.out.println(i);
		
	}
	
}

public class P2667 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.nextLine());
		String[] map = new String[n];
		for(int i=0; i<n; i++) {
			map[i] = scan.nextLine();
		}
		
		Complex comp = new Complex(n, map);
		comp.comp();
		
	}
}
