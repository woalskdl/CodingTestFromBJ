package d210825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P2644_my {

    static int n;
    static int[][] arr;
    static boolean[] visited;

    static int s;
    static int e;

    public static class Info{
        int p;
        int count;

        public Info(int p, int count) {
            this.p = p;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(s, 0));
        visited[s] = true;

        while(!queue.isEmpty()){
            Info info = queue.poll();
            if(info.p == e)
                return info.count;

            for(int i=1; i<n+1; i++){
                if(arr[info.p][i] != 0 && !visited[i]){
                    queue.add(new Info(i, info.count + 1));
                    visited[i] = true;
                }
            }
        }

        return -1;
    }
}
