package d210823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2178_my {

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> countList;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Node{
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        countList = new ArrayList<>();
        visited = new boolean[n][m];

        bfs(new Node(0, 0, 1));
        System.out.println(Collections.min(countList));
    }

    public static void bfs(Node node){

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.y][node.x] = true;

        while (!queue.isEmpty()){
            Node nd = queue.poll();
            for(int i=0; i<4; i++){
                int ny = nd.y + dy[i];
                int nx = nd.x + dx[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 1 && !visited[ny][nx]){
                    if(ny == n - 1 && nx == m - 1){
                        countList.add(nd.count + 1);
                    }else{
                        queue.add(new Node(ny, nx, nd.count + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
