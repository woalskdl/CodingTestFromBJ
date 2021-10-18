package d211018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4991_my {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Node{
        int y;
        int x;

        int count;
        int dirCount;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        public Node(int y, int x, int count, int dirCount) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.dirCount = dirCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                break;

            char[][] map = new char[h][w];
            boolean[][] visited = new boolean[h][w];
            Node start = null;
            int dirCount = 0;

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    char c = st.nextToken().charAt(j);
                    map[i][j] = c;
                    if(c == 'o')
                        start = new Node(i, j);
                    if(c == '*')
                        dirCount += 1;
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()){
                Node node = queue.poll();
                visited[node.y][node.x] = true;

                for(int i=0; i<4; i++){
                    int ny = node.y + dy[i];
                    int nx = node.x + dx[i];

                    if(inArea(ny, nx, map) && !visited[ny][nx]){
                        if(map[ny][nx] == '*'){
                            visited = new boolean[h][w];
                            visited[ny][nx] = true;

                            if(node.dirCount == dirCount){

                            }

                        }else{
                            queue.add(new Node(ny, nx, node.count + 1, node.dirCount));
                            visited[ny][nx] = true;
                        }
                    }

                }
            }

        }
    }

    private static boolean inArea(int y, int x, char[][] map){
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length && map[y][x] != 'x';
    }
}
