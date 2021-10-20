package d211020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4991_answer {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int h,w;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] distance;
    private static int dirCount;
    private static List<Node> nodeList;

    private static boolean[] check;
    private static int result;

    private static class Node {
        int y;
        int x;

        int count;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            map = new char[h][w];
            nodeList = new ArrayList<>();
            dirCount = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();

                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;
                    if (c == 'o')
                        nodeList.add(0, new Node(i, j));
                    if (c == '*')
                        nodeList.add(new Node(i, j));
                }
            }

            int[][] distance = new int[nodeList.size()][nodeList.size()];
            for(int i=0; i< nodeList.size(); i++)
                bfs(nodeList.get(i), i);

            if(dirCount == nodeList.size() - 1){
                result = Integer.MAX_VALUE;
                check = new boolean[nodeList.size()];
                check[0] = true;
                find(0, 1, 0);
                System.out.println(result);
            }else{
                System.out.println(-1);
            }
        }
    }

    private static void bfs(Node node, int start){

        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[h][w];

        queue.add(node);
        visited[node.y][node.x] = true;

        while (!queue.isEmpty()) {
            Node next = queue.poll();

            if(map[next.y][next.y] == '*'){
                if(start == 0)
                    dirCount += 1;

                for(int i=1; i< nodeList.size(); i++){
                    if(next.y == nodeList.get(i).y && next.x == nodeList.get(i).x)
                        distance[start][i] = next.count;
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny = next.y + dy[i];
                int nx = next.x + dx[i];

                if (inArea(ny, nx, map) && !visited[ny][nx]) {
                    queue.add(new Node(ny, nx, next.count + 1));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void find(int start, int cnt, int dist){
        if (cnt == nodeList.size())
            result = Math.min(result, dist);

        for(int i=1; i<nodeList.size(); i++){
            if(!check[i]){
                check[i] = true;
                find(i, cnt + 1, dist + distance[start][i]);
                check[i] = false;
            }
        }
    }

    private static boolean inArea(int y, int x, char[][] map) {
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length && map[y][x] != 'x';
    }
}
