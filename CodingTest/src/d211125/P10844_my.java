package d211125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10844_my {

    private static int N;
    private static final int[] NUM = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int result;

    private static class Node{
        int i;
        int size;

        public Node(int i, int size) {
            this.i = i;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        result = 0;

        for(int i=1; i<10; i++)
            bfs(i);

        System.out.println(result);

    }

    private static void bfs(int i){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, 1));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int size = node.size;
            int index = node.i;

            if(size >= N){
                result = size % 1000000000 + 1;
                continue;
            }

            if(index > 0) {
                int nIndex = index - 1;
                int nSize = size + 1;

                queue.add(new Node(nIndex, nSize));
            }

            if(index < 9){
                int nIndex = index + 1;
                int nSize = size + 1;

                queue.add(new Node(nIndex, nSize));
            }
        }
    }

    private static int dp(int i, int size){
        if(size >= N)
            return dp(i, size % 1000000000 + 1);

        if(i > 0)
            return dp(i - 1, size + 1);

        if(i < 9)
            return dp(i + 1, size + 1);

        return size;
    }

}
