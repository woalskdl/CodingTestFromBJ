package d210826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014_my {

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];

        System.out.println(bfs());
    }

    public static String bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()){
            int now = queue.poll();
            if(now == G)
                return visited[now] + "";

            if(now + U <= F && now + U != S && visited[now + U] == 0){
                queue.add(now + U);
                visited[now + U] = visited[now] + 1;
            }

            if(now - D > 0 && now - D != S && visited[now - D] == 0){
                queue.add(now - D);
                visited[now - D] = visited[now] + 1;
            }
        }

        return "use the stairs";
    }
}
