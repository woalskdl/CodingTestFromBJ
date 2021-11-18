package d211118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9095_answer {
    private static int T;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];
            if (N >= 1)
                arr[1] = 1;
            if (N >= 2)
                arr[2] = 2;
            if (N >= 3)
                arr[3] = 4;

            for (int j = 4; j <= N; j++)
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];

            System.out.println(arr[N]);

        }
    }
}
