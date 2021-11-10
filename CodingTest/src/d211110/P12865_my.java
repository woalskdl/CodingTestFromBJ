package d211110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865_my {
    private static int N;
    private static int K;

    private static int[] weights;
    private static int[] values;

    private static int[][] things;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        values = new int[N];

        things = new int[N][100001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int w = weights[i];
            int v = values[i];

            for (int j = 0; j <= K; j++) {
                if (i == 0) {
                    if (j >= w)
                        things[i][j] = v;
                } else {
                    if (j >= w)
                        things[i][j] = Math.max(things[i - 1][j - w] + v, things[i - 1][j]);
                    else
                        things[i][j] = things[i - 1][j];
                }
            }
        }

        System.out.println(things[N-1][K]);

    }
}
