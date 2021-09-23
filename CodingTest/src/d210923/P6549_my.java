package d210923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6549_my {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        class Check{
            int num;
            int count;

            public Check(int num, int count) {
                this.num = num;
                this.count = count;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Check check = (Check) o;
                return num == check.num;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }

        for(int n = Integer.parseInt(st.nextToken()); n != 0; st = new StringTokenizer(br.readLine()), n = Integer.parseInt(st.nextToken())){
            int[] shapes = new int[n];
            List<Check> ck = new ArrayList<>();

            int min = Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                int num = Integer.parseInt(st.nextToken());
                shapes[i] = num;
                if(min > num)
                    min = num;
                Check c = new Check(num, 1);
                if(ck.contains(c)){
                    int idx = ck.indexOf(c);
                    ck.get(idx).setCount(ck.get(idx).getCount() + 1);
                }else{
                    ck.add(c);
                }
            }

            long maxArea = (long) min * shapes.length;

            for(int j=0, length = shapes.length; j<length; j++){
                long area = shapes[j];
                int c = ck.indexOf(area);
                if(area * ck.get(c).getCount() <= maxArea)
                    continue;

                boolean[] visited = new boolean[length];

                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                visited[j] = true;

                while (!queue.isEmpty()){
                    int idx = queue.poll();
                    if(idx + 1 < length - 1 && shapes[idx + 1] >= shapes[idx] && !visited[idx + 1]){
                        queue.add(idx + 1);
                        visited[idx + 1] = true;
                        area += shapes[j];

                    }

                    if(idx - 1 >= 0 && shapes[idx - 1] >= shapes[idx] && !visited[idx - 1]){
                        queue.add(idx - 1);
                        visited[idx - 1] = true;
                        area += shapes[j];
                    }
                }

                if(maxArea < area )
                    maxArea = area;
            }

            System.out.println(maxArea);
        }
    }
}
