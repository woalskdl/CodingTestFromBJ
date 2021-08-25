package d210825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569_my {

    static int M;
    static int N;
    static int H;

    static int[][][] arr;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static class Point{
        int m;
        int n;
        int h;

        int day;

        public Point(int m, int n, int h, int day) {
            this.m = m;
            this.n = n;
            this.h = h;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];

        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Point> queue = new LinkedList<>();
        int day = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[i][j][k] == 1){
                        queue.add(new Point(k, j, i, day));
                    }
                }
            }
        }

        while (!queue.isEmpty()){
            if(check())
                return day;

            Point point = queue.poll();
            for(int i=0; i<6; i++){
                int nm = point.m + dy[i];
                int nn = point.n + dx[i];
                int nh = point.h + dz[i];

                if(nm >= 0 && nn >= 0 && nh >= 0 && nm < M && nn < N && nh < H && arr[nh][nn][nm] == 0){
                    arr[nh][nn][nm] = 1;
                    day = point.day + 1;
                    queue.add(new Point(nm, nn, nh, day));
                }
            }
        }

        return -1;
    }

    public static boolean check(){
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
