package d211111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1463_my {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if(i == 10)
                arr[i] = 3;
            else if(i % 10 == 0)
                arr[i] = arr[10] + arr[i / 10];
            else if (i % 3 == 0)
                arr[i] = arr[i / 3] + 1;
            else if (i % 2 == 0)
                arr[i] = arr[i / 2] + 1;
            else
                arr[i] = arr[i - 1] + 1;
        }

        System.out.println(arr[N]);
    }
}
