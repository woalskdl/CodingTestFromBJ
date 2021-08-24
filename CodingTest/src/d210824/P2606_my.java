package d210824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606_my {

    static int num;
    static int link;

    static boolean[] visited;
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        link = Integer.parseInt(st.nextToken());

        arr = new int[num + 1][num + 1];
        visited = new boolean[num + 1];
        for(int i=0; i<link; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        bfs();
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i=1; i<num+1; i++){
                if(!visited[i] && arr[n][i] != 0){
                    queue.add(i);
                    visited[i] = true;
                    count += 1;
                }
            }
        }
    }
}
