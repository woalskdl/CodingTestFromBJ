package d210831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2933_my {

    static int R, C, N;
    static char[][] arr;
    static List<Node> dropList;

    static private class Node implements Comparable<Node>{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node node) {
            if(node.y < y)
                return 1;
            else if(node.y > y)
                return -1;

            return 0;
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
        for(int i=0; i<N; i++){
            int h = R - Integer.parseInt(st.nextToken());
            if(i % 2 == 0){
                for(int j=0; j<arr[h].length; j++){
                    if(arr[h][j] == 'x'){
                        arr[h][j] = '.';
                        break;
                    }
                }
            }else{
                for(int j=C-1; j>=0; j--){
                    if(arr[h][j] == 'x'){
                        arr[h][j] = '.';
                        break;
                    }
                }
            }

            if(fallCk())
                fall();

            for(int j=0; j<R; j++){
                for(int k=0; k<C; k++){
                    System.out.print(arr[j][k]);
                }
                System.out.println();
            }

            System.out.println();
        }

        System.out.println("=======================");
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean fallCk(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'x' && !visited[i][j]){
                    dropList = new ArrayList<>();
                    Node start = new Node(i, j);
                    queue.add(start);
                    visited[i][j] = true;

                    int ck = 0;

                    while (!queue.isEmpty()){
                        Node node = queue.poll();
                        dropList.add(node);
                        for(int k=0; k<4; k++){
                            int ny = node.y + dy[k];
                            int nx = node.x + dx[k];

                            if(inArea(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 'x'){
                                queue.add(new Node(ny, nx));
                                visited[ny][nx] = true;
                                ck = ny;
                            }
                        }
                    }

                    if(ck != R - 1){
                        for(int k=0; k< dropList.size(); k++){
                            System.out.println(dropList.get(k).y + " / " + dropList.get(k).x);
                        }
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void fall(){
        boolean ck = true;
        Collections.sort(dropList, Collections.reverseOrder());
        while (ck){
            for(int i=0; i<dropList.size(); i++){
                Node node = dropList.get(i);
                arr[node.y][node.x] = '.';
                arr[node.y + 1][node.x] = 'x';
                dropList.set(i, new Node(node.y + 1, node.x));

                System.out.println(dropList.get(i).y + " : " + dropList.get(i).x);

                if(dropList.get(i).y >= R || arr[dropList.get(i).y + 1][dropList.get(i).x] == 'x'){
                    System.out.println(i);
                    ck = false;
                }
            }
        }
    }

    private static boolean inArea(int y, int x){
        return x >= 0 && y >= 0 && x < C && y < R;
    }
}
