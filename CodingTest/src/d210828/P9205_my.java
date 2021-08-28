package d210828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P9205_my {
    static int t;
    static int n;
    static List<int[]> d;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        d = new ArrayList<>();
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 2];
            int x = 0;
            int y = 0;
            for(int j=0; j<n+2; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int nx = Integer.parseInt(st.nextToken());
                int ny = Integer.parseInt(st.nextToken());
                arr[j] = Math.abs(ny - y) + Math.abs(nx - x);
                x = nx;
                y = ny;
            }
            d.add(arr);
        }

        answer = new ArrayList<>();

        for(int i=0; i<t; i++){
            String check = "happy";
            int[] temp = d.get(i);
            for(int j=0; j<d.get(i).length; j++){
                if(temp[j] > 1000)
                    check = "sad";
            }
            answer.add(check);
        }

        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}
