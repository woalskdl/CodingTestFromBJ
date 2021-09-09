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
        private List<Node> exits;

        public MapInfo(char[][] map, List<Node> nodes, List<Node> exits) {
            this.map = map;
            this.nodes = nodes;
            this.exits = exits;
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
            List<Node> exits = new ArrayList<>();

            for(int j=0; j<h; j++){
                String line = br.readLine();
                for(int k=0; k<w; k++){
                    map[j][k] = line.charAt(k);
                    if(map[j][k] == '$')
                        nodes.add(new Node(j, k));

                    if(j == 0 || k == 0 || j == h - 1 || k == w - 1){
                        if(map[j][k] == '#' || map[j][k] == '.')
                            exits.add(new Node(j, k));
                    }

                }
            }
            maps.add(new MapInfo(map, nodes, exits));
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
//            for(int j=0; j<maps.get(i).exits.size(); j++)
//                System.out.println("exit" + i + " : " + maps.get(i).exits.get(j).y + " / " + maps.get(i).exits.get(j).x);
//            //

            System.out.println(bfs(maps.get(i)));
        }
    }

    private static int bfs(MapInfo mapInfo){

        class Info{
            private Node node;
            private List<Node> route;
            private int doorCnt;

            public Info(Node node, List<Node> route, int doorCnt) {
                this.node = node;
                this.route = route;
                this.doorCnt = doorCnt;
            }
        }

        List<char[][]> maps = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        char[][] map = copy(mapInfo.map);
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<Info> queue = new LinkedList<>();
        List<Node> route = new ArrayList<>();

        Node node1 = mapInfo.nodes.get(0);
        route.add(node1);
        queue.add(new Info(node1, route, 0 ));
        visited[node1.y][node1.x] = true;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            Node node = info.node;

//            if(node.equals(mapInfo.nodes.get(0))){
//                count1.add(info.doorCnt);
//                endCnt += 1;
//            }
//            if(node.equals(mapInfo.nodes.get(1))){
//                count2.add(info.doorCnt);
//                endCnt += 1;
//            }
//
//            if(endCnt == 2)
//                break;

            if(node.y == 0 || node.x == 0 || node.y == map.length - 1 || node.x == map[0].length - 1)


            for (int j = 0; j < 4; j++) {
                int ny = node.y + dy[j];
                int nx = node.x + dx[j];

                if (inArea(ny, nx, map) && !visited[ny][nx] && map[ny][nx] != '*') {
                    int doorCnt = info.doorCnt;
                    if(map[ny][nx] == '#'){
                        map[ny][nx] = '.';
                        doorCnt += 1;
                    }

                    List<Node> tempRoute = new ArrayList<>();
                    tempRoute.addAll(info.route);
                    tempRoute.add(new Node(ny, nx));

                    queue.add(new Info(new Node(ny, nx), tempRoute, doorCnt));
                    visited[ny][nx] = true;
                }
            }
        }

        count1.sort(Comparator.naturalOrder());
        count2.sort(Comparator.naturalOrder());

        System.out.println(count1.toString());
        System.out.println(count2.toString());

        return count1.get(0) + count2.get(0);
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
