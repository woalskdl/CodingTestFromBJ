package d210816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1655_my {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        List<Integer> input = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            input.add(Integer.parseInt(st.nextToken()));
            input.sort(null);

            if(i % 2 == 0)
                arr[i] = input.get(i / 2);
            else
                arr[i] = Math.min(input.get(i / 2), input.get(i / 2 + 1));
        }

        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }

        // 시간 복잡도 개념에 대해서 공부해봐야 함.
    }
}