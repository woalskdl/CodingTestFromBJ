package d210330;

import java.util.Arrays;
import java.util.Scanner;

class Combination{
	String[] nessV = {"a","e","i","o","u"};
	String[] nessC = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
	int n;
	int r;
	String[] charList;
	boolean[] visited;
	
	Combination(int r, int n, String[] charList){
		this.n = n;
		this.r = r;
		this.charList = charList;
		visited = new boolean[n];
	}
	
	void comb(int start, int r) {
		if(r == 0) {
			print();
		}else {
			for(int i=start; i<n; i++) {
				visited[i] = true;
				comb(i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
	
	void print() {
		int cntV = 0;
		int cntC = 0;
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				for(int j=0; j<this.nessV.length; j++) {
					if(charList[i].equals(this.nessV[j])) {
						cntV ++;
						break;
					}
				}
				for(int j=0; j<this.nessC.length; j++) {
					if(charList[i].equals(this.nessC[j])) {
						cntC++;
						break;
					}
				}
			}
		}
		
		if(cntV >= 1 && cntC >= 2) {
			for(int i=0; i<n; i++) {
				if(visited[i])
					System.out.print(charList[i]);
			}
			System.out.println();
		}
	}
}


public class P1759 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String info = scan.nextLine();
		String[] temp = info.split(" ");
		
		int n = Integer.parseInt(temp[1]);
		int r = Integer.parseInt(temp[0]);
		
		String[] charList = new String[n];
		for(int i=0; i<n; i++) {
			charList[i] = scan.next();
		}
		
		Arrays.sort(charList);
		
		Combination comb = new Combination(r, n, charList);
		comb.comb(0, r);
		
	}
}
