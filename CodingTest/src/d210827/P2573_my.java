package d210827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2573_my {

    static int N;
    static int M;
    static int[][] arr;
    static int YEAR;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        YEAR = 0;
        while (check() < 2){
            if (check() == 0){
                YEAR = 0;
                break;
            }
            melt();
            YEAR += 1;
        }

        System.out.println(YEAR);
    }

    public static int check(){
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && arr[i][j] != 0){
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int k=0; k<4; k++){
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];

                            if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && arr[ny][nx] != 0){
                                queue.add(new Node(ny, nx));
                                visited[ny][nx] = true;
                            }
                        }
                    }

                    count += 1;
                }
            }
        }

        return count;
    }

    public static void melt(){
        int[][] temp = copy(arr);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 0){
                    for(int k=0; k<4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if(ny >= 0 && nx >= 0 && ny < N && nx < M && temp[ny][nx] == 0 && arr[i][j] > 0)
                            arr[i][j] -= 1;
                    }
                }
            }
        }
    }

    public static int[][] copy(int[][] input){
        int[][] output = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                output[i][j] = input[i][j];
            }
        }

        return output;
    }
}
