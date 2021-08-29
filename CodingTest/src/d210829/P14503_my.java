package d210829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14503_my {
    static int N, M, r, c, d;
    static int[][] arr;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));
        visited[r][c] = true;
        count = 1;
        int check = 0;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int nx = node.x;
            int ny = node.y;

            if(check < 4){
                if(d == 0)
                    nx -= 1;
                else if(d == 1)
                    ny -= 1;
                else if(d == 2)
                    nx += 1;
                else if(d == 3)
                    ny += 1;

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] == 0 && !visited[ny][nx]){
                    r = ny;
                    c = nx;
                    visited[r][c] = true;
                    count += 1;
                    check = 0;
                }else
                    check += 1;

                d -= 1;
                if(d < 0)
                    d = 3;
            }else {
                if(d == 0)
                    ny = r + 1;
                else if(d == 1)
                    nx = c - 1;
                else if(d == 2)
                    ny = r - 1;
                else if(d == 3)
                    nx = c + 1;

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] != 0)
                    break;

                r = ny;
                c = nx;
                check = 0;
            }

            queue.add(new Node(r, c));
        }

        return count;
    }

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}