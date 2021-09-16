package d210916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P6549_my {

    static private List<int[]> caseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        caseList = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        while (n != 0){
            int[] shapes = new int[n];
            for(int i=0; i<n; i++)
                shapes[i] = Integer.parseInt(st.nextToken());

            caseList.add(shapes);

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        for(int i=0, size = caseList.size(); i<size; i++){
            int[] shapes = caseList.get(i);
            boolean[] visited = new boolean[shapes.length];

            int max = Arrays.stream(shapes).max().getAsInt();
            int min = Arrays.stream(shapes).min().getAsInt();

            int area = shapes[0];
            List<Integer> areas = new ArrayList<>();
            areas.add(area);

            for(int j=0, length = shapes.length; j<length && !visited[j]; j++){

                if(j - 1 >= 0 && shapes[j-1] < shapes[j]){
                }else {
                    areas.add(area);

                }
                    area = shapes[j];

                if(shapes[j + 1] >= shapes[j])
                    area += shapes[j];
                else
                    visited[j + 1] = true;

                visited[j] = true;
            }
        }
    }
}
