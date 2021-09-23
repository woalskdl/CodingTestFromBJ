package d210916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P6549_my {

    static private List<int[]> caseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        caseList = new ArrayList<>();

        for(int n = Integer.parseInt(st.nextToken()); n != 0; n = Integer.parseInt(st.nextToken())){
            int[] shapes = new int[n];
            for(int i=0; i<n; i++)
                shapes[i] = Integer.parseInt(st.nextToken());

            caseList.add(shapes);
            st = new StringTokenizer(br.readLine());
        }

        for(int i=0, size = caseList.size(); i<size; i++){
            int[] shapes = caseList.get(i);

            List<Integer> areas = new ArrayList<>();

            for(int j=0, length = shapes.length; j<length; j++){
                boolean[] visited = new boolean[length];
                int area = shapes[j];

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

                areas.add(area);
            }

            System.out.println(Collections.max(areas));
        }
    }
}
