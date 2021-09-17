package d210909;

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
        private Node node;

        public Node(int y, int x, Node node) {
            this.y = y;
            this.x = x;
            this.node = node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return y == node.y && x == node.x;
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
            int exitCnt = 0;

            for(int j=0; j<h; j++){
                String line = br.readLine();
                for(int k=0; k<w; k++){
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '$')
                        nodes.add(new Node(j, k, null));

//                    if(j == 0 || k == 0 || j == h - 1 || k == w - 1){
//                        if(map[j][k] == '#' || map[j][k] == '.')
//                            exitCnt += 1;
//                    }

                }
            }
            maps.add(new MapInfo(map, nodes));
        }

        for(int i=0; i<T; i++){
//            //
//            for(int j=0; j<maps.get(i).map.length; j++){
//                for(int k=0; k<maps.get(i).map[0].length; k++){
//                    System.out.print(maps.get(i).map[j][k] + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("\nnode1 : " + maps.get(i).nodes.get(0).y + " / " + maps.get(i).nodes.get(0).x);
//            System.out.println("node2 : " + maps.get(i).nodes.get(1).y + " / " + maps.get(i).nodes.get(1).x + "\n");
//
//            //

            System.out.println(bfs(maps.get(i)));
        }
    }

    private static int bfs(MapInfo mapInfo){

        List<char[][]> maps = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        char[][] map = mapInfo.map;
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<Node> queue = new LinkedList<>();

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

                for(int i=0; i<map.length; i++){
                    for(int j=0; j<map[0].length; j++){
                        System.out.print(tempMap[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println(doorCnt);
                System.out.println();

                maps.add(tempMap);
                count.add(doorCnt);
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (inArea(ny, nx, map) && !visited[ny][nx] && map[ny][nx] != '*') {
                    queue.add(new Node(ny, nx, node));
                    visited[ny][nx] = true;
                }
            }
        }

        List<Integer> totalCnt = new ArrayList<>();

        for(int i=0; i<maps.size(); i++){
            char[][] newMap = maps.get(i);
            visited = new boolean[newMap.length][newMap[0].length];

            queue = new LinkedList<>();

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
                        queue.add(new Node(ny, nx, node));
                        visited[ny][nx] = true;
                    }
                }
            }

        }

        System.out.println(totalCnt.toString() + "test");
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
