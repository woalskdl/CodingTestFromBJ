package d210831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2933_my {

    static int R, C, N;
    static char[][] arr;
    static int[] th;

    static private class Node{
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

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = line.charAt(j);
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        th = new int[N];
        for(int i=0; i<N; i++){
            th[i] = Integer.parseInt(st.nextToken());
        }

    }

    private static boolean dropCk(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'X'){
                    queue.add(new Node(i, j));
                    visited[i][j] = true;

                    int ck = 0;

                    while (!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int k=0; k<4; k++){
                            int ny = node.y + dy[k];
                            int nx = node.x + dx[k];

                            if(inArea(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 'X'){
                                queue.add(new Node(ny, nx));
                                visited[ny][nx] = true;
                                ck = ny;
                            }
                        }
                    }

                    if(ck != R - 1)
                        return true;
                }
            }
        }

        return false;
    }

    private static boolean inArea(int y, int x){
        return x >= 0 && y >= 0 && x < C && y < R;
    }
}
