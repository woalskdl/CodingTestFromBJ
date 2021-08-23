package d210408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Matrix{
	String matrix;

	int[] dx = {-1 ,1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	Map<String, Integer> m = new HashMap<>();
	Queue<String> q = new LinkedList<>();
	
	Matrix(String matrix){
		this.matrix = matrix;
	}
	
	void run() {
		m.put(matrix, 0);
		q.offer(matrix);
		while(!q.isEmpty()) {
			String input = q.poll();
			int codeX = input.indexOf("9") % 3;
			int codeY = input.indexOf("9") / 3;
			
			for(int i=0; i<4; i++) {
				int nx = codeX + dx[i];
				int ny = codeY + dy[i];
				
				if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
					String newMatrix = "";
					int code = codeX + codeY * 3;
					int nCode = nx + ny * 3;
					for(int j=0; j<input.length(); j++) {
						if(j != nCode && j != code) {
							newMatrix += input.charAt(j) + "";
						}else if(j == nCode){
							newMatrix += "9";
						}else if(j == code) {
							newMatrix += input.charAt(nCode) + "";
						}
					}
					
					if(!m.containsKey(newMatrix)) {
						m.put(newMatrix, m.get(input) + 1);
						q.offer(newMatrix);
					}
				}
			}
		}
		
		if(m.containsKey("123456789"))
			System.out.println(m.get("123456789"));
		else
			System.out.println("-1");
	}
	
}

public class P1525 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String matrix = "";
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				String n = st.nextToken();
				if(n.equals("0"))
					n = "9";
				matrix += n;
			}
		}
		
		Matrix m = new Matrix(matrix);
		m.run();
		
	}
}
