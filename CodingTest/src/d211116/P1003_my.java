package d211116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1003_my {
    private static int T;
    private static int N;

    private static int[] cnt0;
    private static int[] cnt1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            cnt0 = new int[N + 1];
            cnt1 = new int[N + 1];

            cnt0[0] = 1;
            if (N > 0)
                cnt1[1] = 1;

            for (int j = 2; j <= N; j++) {
                cnt0[j] = cnt0[j - 1] + cnt0[j - 2];
                cnt1[j] = cnt1[j - 1] + cnt1[j - 2];
            }

            System.out.println(cnt0[N] + " " + cnt1[N]);
        }
    }
}
