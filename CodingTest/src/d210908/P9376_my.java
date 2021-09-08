package d210908;

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

    static private class Node{
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
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
                        nodes.add(new Node(j, k));
                }
            }

            maps.add(new MapInfo(map, nodes));
        }
    }

    private static int bfs(MapInfo mapInfo){
        char[][] map = mapInfo.map;
        boolean[][] visited = new boolean[map.length][map[0].length];

        class Case{
            private char[][] map;
            private int count;

            public Case(char[][] map, int count) {
                this.map = map;
                this.count = count;
            }
        }

        List<Case> cases = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        Node node1 = mapInfo.nodes.get(0);
        queue.add(node1);
        visited[node1.y][node1.x] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(inArea(ny, nx, map) && !visited[ny][nx] && map[ny][nx] != '*'){
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                    if(map[ny][nx] == '#'){

                    }

                    if(ny == 0 || nx == 0 || ny == map.length - 1 || nx == map[0].length - 1){
                        char[][] temp = new char[map.length][map[0].length];
                        for(int j=0; j<map.length; j++){
                            for(int k=0; k<map[0].length; k++){

                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static boolean inArea(int y, int x, char[][] map){
        return y >= 0 && x >= 0 && y < map.length && x < map[0].length;
    }
}
