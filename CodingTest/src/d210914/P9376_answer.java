package d210914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9376_answer {
    static private int T;
    static private List<MapInfo> maps;

    static private class MapInfo{
        private char[][] map;
        private List<Node> nodes;

        public MapInfo(char[][] map, List<Node> nodes) {
            this.map = map;
            this.nodes = nodes;
        }
    }

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    static private class Node implements Comparable<Node> {
        private int y;
        private int x;
        private int doorCk = 0;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int doorCk) {
            this.y = y;
            this.x = x;
            this.doorCk = doorCk;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.doorCk, o.doorCk);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maps = new ArrayList<>();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h + 2][w + 2];
            List<Node> nodes = new ArrayList<>();

            for(int j=0; j<h; j++){
                String line = br.readLine();
                for(int k=0; k<w; k++){
                    map[j + 1][k + 1] = line.charAt(k);
                    if(map[j + 1][k + 1] == '$')
                        nodes.add(new Node(j + 1, k + 1));
                }
            }

            for(int j=0; j<w+2; j++)
                map[0][j] = map[h + 1][j] = '.';

            for(int j=0; j<h+2; j++)
                map[j][0] = map[j][w + 1] = '.';

            maps.add(new MapInfo(map, nodes));
        }

        for(int i=0; i<T; i++){
            char[][] map = maps.get(i).map;
            List<Node> nodes = maps.get(i).nodes;

            int[][] doorCnt1, doorCnt2, doorCnt3;

            doorCnt1 = bfs(map, nodes.get(0));
            doorCnt2 = bfs(map, nodes.get(1));
            doorCnt3 = bfs(map, new Node(0, 0));

//            System.out.println();
//            printMap(doorCnt1);
//            printMap(doorCnt2);
//            printMap(doorCnt3);

            System.out.println(getMinSum(doorCnt1, doorCnt2, doorCnt3, map));
        }
    }

    private static void printMap(int[][] arr) {
        for (int[] a: arr)
            System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static void printMap(char[][] arr) {
        for (char[] a: arr)
            System.out.println(Arrays.toString(a));
        System.out.println();
    }

    private static int getMinSum(int[][] node1, int[][] node2, int[][] outNode, char[][] map) {
        int minSum;

        minSum = Integer.MAX_VALUE;

        for (int i = 0; i < node1.length; i++) {
            for (int j = 0; j < node1[i].length; j++) {
                if (map[i][j] == '*')
                    continue;

                int sum = node1[i][j] + node2[i][j] + outNode[i][j];
                if (map[i][j] == '#')
                    sum -= 2;
                if (minSum > sum)
                    minSum = sum;
            }
        }

        return minSum;
    }

    private static int[][] bfs(char[][] map, Node node){
        int h = map.length;
        int w = map[0].length;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[h][w];
        int[][] doorCnt = new int[h][w];

        queue.add(node);
        visited[node.y][node.x] = true;

        while (!queue.isEmpty()){
            Node ck = queue.poll();
            doorCnt[ck.y][ck.x] = ck.doorCk;

            for(int i=0; i<4; i++){
                int ny = ck.y + dy[i];
                int nx = ck.x + dx[i];
                if(inArea(ny, nx, map) && !visited[ny][nx] && map[ny][nx] != '*'){
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx, map[ny][nx] == '#' ? ck.doorCk + 1 : ck.doorCk));
                }
            }
        }

        return doorCnt;
    }

    private static boolean inArea(int y, int x, char[][] map){
        return y >= 0 && x >= 0 && y < map.length && x < map[0].length;
    }
}
