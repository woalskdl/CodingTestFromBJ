package d210824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667_my {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> count;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        br.close();

        count = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    count.add(bfs(new Address(i,j)));
                }
            }
        }

        Collections.sort(count);
        System.out.println(count.size());
        for(int i=0; i<count.size(); i++)
            System.out.println(count.get(i));
    }

    public static class Address{
        int a;
        int b;

        public Address(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static int bfs(Address address){
        int c = 0;
        Queue<Address> queue = new LinkedList<>();
        queue.add(address);
        visited[address.a][address.b] = true;
        c += 1;

        while (!queue.isEmpty()){
            Address addr = queue.poll();
            for(int i=0; i<4; i++){
                int ny = addr.a + dy[i];
                int nx = addr.b + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx] && map[ny][nx] != 0){
                    queue.add(new Address(ny, nx));
                    visited[ny][nx] = true;
                    c += 1;
                }
            }
        }

        return c;
    }
}
