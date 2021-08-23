package d210820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_my_re {

    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        dfs(v);
        System.out.println();
        bfd(v);

    }

    public static void init(){
        for(int i=0; i< visited.length; i++){
            visited[i] = false;
        }
    }

    public static void dfs(int start){
        System.out.print(start + " ");
        visited[start] = true;

        for(int i=1; i< visited.length; i++){
            if(arr[start][i] == 1 && i != start && !visited[i])
                dfs(i);
        }
    }

    public static void bfd(int start){
        init();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num + " ");

            for(int i=1; i<visited.length; i++){
                if(arr[num][i] == 1 && !visited[i] && i != num){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
