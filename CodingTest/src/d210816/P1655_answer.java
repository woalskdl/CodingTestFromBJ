package d210816;

import java.io.*;
import java.util.PriorityQueue;

public class P1655_answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());

            if(i % 2 == 0)
                maxPQ.add(n);
            else
                minPQ.add(n);

            if(!maxPQ.isEmpty() && !minPQ.isEmpty()){
                if(maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }

            bw.write(maxPQ.peek() + "\n");
        }

//        bw.flush();
//        bw.close();
//        br.close();
    }
}
