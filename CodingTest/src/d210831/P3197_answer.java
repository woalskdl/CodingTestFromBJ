package d210831;

import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3197_answer {
    static int R, C;
    static char[][] arr;
    static int[][] melt;
    static int day;

    static List<Node> point;

    static public class Node{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        point = new ArrayList<>();
        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'L')
                    point.add(new Node(i, j));
            }
        }

        br.close();

        melt = melt();

        int left = 0;
        int right = day;
        int min = Integer.MAX_VALUE;

        while (left <= right){
            int mid = (left + right) / 2;

            if(bfsCk(mid)){
                min = Math.min(min, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(min);
    }

    public static boolean bfsCk(int limit){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(point.get(0));
        visited[point.get(0).y][point.get(0).x] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(inArea(nx, ny) && !visited[ny][nx] && melt[ny][nx] <= limit){
                    if(arr[ny][nx] == 'L')
                        return true;

                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        return false;
    }

    public static int[][] melt(){
        boolean[][] visited = new boolean[R][C];
        int[][] melt = new int[R][C];

        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'L' || arr[i][j] == '.'){
                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        day = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            day += 1;

            for(int i=0; i<size; i++){
                Node node = queue.poll();

                for(int j=0; j<4; j++){
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if(inArea(nx, ny) && !visited[ny][nx] && arr[ny][nx] == 'X'){
                        melt[ny][nx] = day;
                        visited[ny][nx] = true;

                        queue.offer(new Node(ny, nx));
                    }
                }
            }
        }

        return melt;
    }

    private static boolean inArea(int x, int y){
        return x >= 0 && y >= 0 && x < C && y < R;
    }
}
