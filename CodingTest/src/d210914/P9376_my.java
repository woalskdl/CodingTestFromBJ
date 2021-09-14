package d210914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P9376_my {
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

    static private class Node implements Comparable<Node>{
        private int y;
        private int x;
        private Node node;
        private int doorCk;

        public Node(int y, int x, Node node, int doorCk) {
            this.y = y;
            this.x = x;
            this.node = node;
            this.doorCk = doorCk;
        }

        @Override
        public int compareTo(Node o) {
            if(this.doorCk > o.doorCk)
                return 1;
            else if(this.doorCk < o.doorCk)
                return -1;

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        maps = new ArrayList<>();

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            List<Node> nodes = new ArrayList<>();

            for(int j=0; j<h; j++){
                String line = br.readLine();
                for(int k=0; k<w; k++){
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '$')
                        nodes.add(new Node(j, k, null, 0));
                }
            }
            maps.add(new MapInfo(map, nodes));
        }

        for(int i=0; i<T; i++){
            System.out.println(bfs(maps.get(i)));
        }
    }

    private static int bfs(MapInfo mapInfo){

        List<char[][]> maps = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        char[][] map = mapInfo.map;
        boolean[][] visited = new boolean[map.length][map[0].length];

        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node node1 = mapInfo.nodes.get(0);
        queue.add(node1);
        visited[node1.y][node1.x] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.y == 0 || node.x == 0 || node.y == map.length - 1 || node.x == map[0].length - 1){
                char[][] tempMap = copy(map);
                Node ck = node;
                int doorCnt = 0;
                while (ck != null){
                    if(tempMap[ck.y][ck.x] == '#'){
                        doorCnt += 1;
                        tempMap[ck.y][ck.x] = '.';
                    }

                    ck = ck.node;
                }

                maps.add(tempMap);
                count.add(doorCnt);
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (inArea(ny, nx, map) && !visited[ny][nx] && map[ny][nx] != '*'){
                    int doorCk = 0;
                    if(map[ny][nx] == '#')
                        doorCk = 1;
                    queue.add(new Node(ny, nx, node, doorCk));
                    visited[ny][nx] = true;
                }
            }
        }

        List<Integer> totalCnt = new ArrayList<>();

        for(int i=0; i<maps.size(); i++){
            char[][] newMap = maps.get(i);
            visited = new boolean[newMap.length][newMap[0].length];

            queue = new PriorityQueue<>();

            Node node2 = mapInfo.nodes.get(1);
            queue.add(node2);
            visited[node2.y][node2.x] = true;

            while (!queue.isEmpty()){
                Node node = queue.poll();

                if(node.y == 0 || node.x == 0 || node.y == newMap.length - 1 || node.x == newMap[0].length - 1){
                    Node ck = node;
                    int doorCnt = 0;
                    while (ck != null){
                        if(newMap[ck.y][ck.x] == '#')
                            doorCnt += 1;

                        ck = ck.node;
                    }
                    totalCnt.add(count.get(i) + doorCnt);
                }

                for(int j=0; j<4; j++){
                    int ny = node.y + dy[j];
                    int nx = node.x + dx[j];

                    if(inArea(ny, nx, newMap) && !visited[ny][nx] & newMap[ny][nx] != '*'){
                        int doorCk = 0;
                        if(newMap[ny][nx] == '#')
                            doorCk = 1;
                        queue.add(new Node(ny, nx, node, doorCk));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return Collections.min(totalCnt);
    }

    private static boolean inArea(int y, int x, char[][] map){
        return y >= 0 && x >= 0 && y < map.length && x < map[0].length;
    }

    private static char[][] copy(char[][] map){
        char[][] result = new char[map.length][map[0].length];

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                result[i][j] = map[i][j];
            }
        }

        return result;
    }
}
