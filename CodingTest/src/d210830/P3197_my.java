package d210830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3197_my {
    static int R, C;
    static char[][] arr;

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
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<C; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'L')
                    point.add(new Node(i, j));
            }
        }

        int count = 0;

        while(!bfsCk()){
            melt();
            count += 1;
        }

        System.out.println(count);
    }

    public static boolean bfsCk(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(point.get(0));
        visited[point.get(0).y][point.get(0).x] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < R && nx < C && !visited[ny][nx]){
                    if(arr[ny][nx] == 'L')
                        return true;

                    if(arr[ny][nx] == '.'){
                        queue.add(new Node(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return false;
    }

    public static void melt(){
        char[][] temp = new char[R][C];
        for(int i= point.get(0).y; i<=point.get(1).y; i++){
            for(int j=point.get(0).x; j<point.get(1).x; j++)
                temp[i][j] = arr[i][j];
        }

        for(int i= point.get(0).y; i<=point.get(1).y; i++){
            for(int j=point.get(0).x; j<point.get(1).x; j++){
                if(arr[i][j] == 'X'){
                    for(int k=0; k<4; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if(ny >= 0 && nx >= 0 && ny < R && nx < C){
                            if(temp[ny][nx] != 'X')
                                arr[i][j] = '.';
                        }
                    }
                }
            }
        }
    }
}
