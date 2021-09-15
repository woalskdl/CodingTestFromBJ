package d210915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9376_answer_final {
    static int H, W;

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static char map[][];
    static int open[][];
    static boolean visited[][];

    static class xy{
        int y, x;

        public xy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static ArrayList<xy> slave = new ArrayList<>();
    static ArrayList<xy> key = new ArrayList<>();

    static class Data implements Comparable<Data>{
        int y, x, key;

        public Data(int y, int x, int key) {
            this.y = y;
            this.x = x;
            this.key = key;
        }

        @Override
        public int compareTo(Data o){
            return this.key - o.key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t<=tc; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H + 2][W + 2];
            open = new int[H + 2][W + 2];
            visited = new boolean[H + 2][W + 2];

            slave.clear();
            key.clear();

            for(char[] item : map)
                Arrays.fill(item, '.');
            for(int i=1; i<=H; i++){
                char temp[] = br.readLine().toCharArray();
                for(int j=0; j<W; j++){
                    map[i][j+1] = temp[j];
                    if(map[i][j+1] == '$')
                        slave.add(new xy(i, j+1));
                    if(map[i][j+1] == '#')
                        key.add(new xy(i,j+1));
                }
            }

            if(Move())
                System.out.println(0);
            else{
                openMove(0, 0);
                for(int i=0; i<slave.size(); i++)
                    openMove(slave.get(i).y, slave.get(i).x);
                solve();
            }
        }
    }

    static boolean Move(){
        int find = 0;
        Queue<xy> queue = new LinkedList<>();
        queue.add(new xy(0, 0));
        while (!queue.isEmpty()){
            xy out = queue.poll();
            if(map[out.y][out.x] == '$'){
                if(find == 1)
                    return true;

                find += 1;
            }

            for(int i=0; i<4; i++){
                int ny = out.y + dy[i];
                int nx = out.x + dx[i];
                if(!outArea(ny, nx) && map[ny][nx] != '#' && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.add(new xy(ny, nx));
                }
            }
        }

        return false;
    }

    static void openMove(int y, int x){
        PriorityQueue<Data> queue = new PriorityQueue<>();
        queue.add(new Data(y, x, 0));
        for(boolean[] item : visited)
            Arrays.fill(item, false);

        visited[y][x] = true;

        while (!queue.isEmpty()){
            Data out = queue.poll();
            for(int i=0; i<4; i++){
                int ny = out.y + dy[i];
                int nx = out.x + dx[i];
                int nKey = out.key;
                if(!outArea(ny, nx) && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    if(map[ny][nx] == '#'){
                        nKey += 1;
                        open[ny][nx] += nKey;
                    }

                    queue.add(new Data(ny, nx, nKey));
                }
            }
        }
    }

    static void solve(){
        int answer = Integer.MAX_VALUE;
        for(xy item : key)
            answer = Math.min(answer, open[item.y][item.x]);
        System.out.println(answer - 2);
    }

    static boolean outArea(int y, int x){
        return y < 0 || x < 0 || y > H + 1 || x > W + 1 || map[y][x] == '*';
    }
}
