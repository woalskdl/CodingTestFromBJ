package d210829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9205_my {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node[] nodes = new Node[n + 2];
            int[] check = new int[n + 2];

            Queue<Node> queue = new LinkedList<>();
            boolean success = false;
            String[] str;

            for(int j=0; j<n+2; j++){
                st = new StringTokenizer(br.readLine(), " ");
                nodes[j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Node start = nodes[0];
            Node end = nodes[n + 1];
            queue.add(start);

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                if(cur.equals(end)){
                    success = true;
                    break;
                }

                for(int j=1; j<n+2; j++){
                    if(check[j] == 0 && Math.abs(cur.x - nodes[j].x) + Math.abs(cur.y - nodes[j].y) <= 1000){
                        queue.add(nodes[j]);
                        check[j] = 1;
                    }
                }
            }

            if(success)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}