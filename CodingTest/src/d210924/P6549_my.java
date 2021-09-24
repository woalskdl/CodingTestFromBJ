package d210924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6549_my {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int n = Integer.parseInt(st.nextToken()); n != 0; st = new StringTokenizer(br.readLine()), n = Integer.parseInt(st.nextToken())){
            int[] shapes = new int[n];
            int min = Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
                shapes[i] = num;
                if(min > num)
                    min = num;
            }

            long maxArea = (long) min * shapes.length;

            for(int j=0, length = shapes.length; j<length; j++){
                long area = shapes[j];
                boolean[] visited = new boolean[length];

                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                visited[j] = true;

                while (!queue.isEmpty()){
                    int idx = queue.poll();
                    if(idx + 1 < length - 1 && shapes[idx + 1] >= shapes[idx] && !visited[idx + 1]){
                        queue.add(idx + 1);
                        visited[idx + 1] = true;
                        area += shapes[j];

                    }

                    if(idx - 1 >= 0 && shapes[idx - 1] >= shapes[idx] && !visited[idx - 1]){
                        queue.add(idx - 1);
                        visited[idx - 1] = true;
                        area += shapes[j];
                    }
                }

                if(maxArea < area )
                    maxArea = area;
            }

            System.out.println(maxArea);
        }
    }
}
