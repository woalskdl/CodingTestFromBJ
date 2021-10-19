package d211019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P4991_my {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Node {
        int y;
        int x;

        int count;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            char[][] map = new char[h][w];
            List<Node> nodeList = new ArrayList<>();
            List<Node> dirList = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();

                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    map[i][j] = c;
                    if (c == 'o')
                        nodeList.add(new Node(i, j));
                    if (c == '*')
                        dirList.add(new Node(i, j));
                }
            }

            nodeList.addAll(dirList);

            Queue<Node> queue = new LinkedList<>();
            int way = 0;
            int dirCount = 0;

            for (int i = 0; i < nodeList.size(); i++) {
                boolean[][] visited = new boolean[h][w];

                if (i != 0) {
                    for (int j = i; j >= 1; j--) {
                        Node ck = nodeList.get(j);
                        visited[ck.y][ck.x] = true;
                    }
                }

                Node start = nodeList.get(i);

                visited[start.y][start.x] = true;
                queue.add(start);

                while (!queue.isEmpty()) {
                    Node node = queue.poll();

                    for (int j = 0; j < 4; j++) {
                        int ny = node.y + dy[j];
                        int nx = node.x + dx[j];

                        if (inArea(ny, nx, map) && !visited[ny][nx]) {
                            int count = node.count + 1;

                            if (map[ny][nx] == '*') {
                                visited[ny][nx] = true;
                                way += count;
                                dirCount += 1;

                                queue.clear();
                                break;
                            } else {
                                queue.add(new Node(ny, nx, count));
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }

            if(dirCount != nodeList.size() - 1)
                way = -1;

            System.out.println(way);
        }
    }

    private static boolean inArea(int y, int x, char[][] map) {
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length && map[y][x] != 'x';
    }
}
