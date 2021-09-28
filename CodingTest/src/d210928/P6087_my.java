package d210928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6087_my {
    static private int W;
    static private int H;
    static private char[][] map;
    static private int[][] visited;
    static private List<Node> nodes;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static private List<Integer> countList;
    static private class Node{
        int y;
        int x;
        int dir;
        int dirCount;

        public Node(int y, int x, int dir, int dirCount) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.dirCount = dirCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        map = new char[H][W];
        visited = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<W; j++){
                map[i][j] = line.charAt(j);
                visited[i][j] = W * H;
                if(map[i][j] == 'C')
                    nodes.add(new Node(i, j, -1, 0));
            }
        }

        System.out.println(bfs());

    }

    static private int bfs(){
        Queue<Node> queue = new LinkedList<>();
        Node start = nodes.get(0);
        queue.add(start);
        visited[start.y][start.x] = 0;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(inArea(ny, nx) && visited[ny][nx] >= node.dirCount){
                    int dirCount = node.dirCount;
                    if(node.dir != -1 && node.dir != i)
                        dirCount += 1;

                    if(visited[ny][nx] >= dirCount){
                        queue.add(new Node(ny, nx, i, dirCount));
                        visited[ny][nx] = dirCount;
                    }
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

        return visited[nodes.get(1).y][nodes.get(1).x];
    }

    static private boolean inArea(int y, int x){
        return y >= 0 && x >= 0 && y < H && x < W && map[y][x] != '*';
    }
}
