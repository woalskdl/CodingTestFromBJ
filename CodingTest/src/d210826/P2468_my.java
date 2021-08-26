package d210826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2468_my {

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    static int MAX;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Integer> list;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        MAX = 1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(MAX < arr[i][j])
                    MAX = arr[i][j];
            }
        }

        list = new ArrayList<>();
        for(int i=0; i<=MAX; i++){
           list.add(bfs(i));
        }

        System.out.println(Collections.max(list));
    }

    public static int bfs(int a){
        int count = 0;
        visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] > a && !visited[i][j]){
                    queue.add(new Node(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()){
                        Node point = queue.poll();
                        for(int k=0; k<4; k++){
                            int nx = point.x + dx[k];
                            int ny = point.y + dy[k];
                            if(nx >= 0 && ny >= 0 && nx < N && ny < N && arr[ny][nx] > a && !visited[ny][nx]){
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

}
