package d211012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11049_my {
    private static int N;
    private static Matrix[][] arr;

    private static class Matrix {
        int y;
        int x;
        int cnt;

        public Matrix(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Matrix matrix = (Matrix) o;
            return cnt == matrix.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new Matrix[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        for (int i = 0; i < N - 1; i++) {
            int n = arr[i][i].y;
            int m = arr[i][i].x;
            int k = arr[i + 1][i + 1].x;

            arr[i][i + 1] = new Matrix(n, k, n * m * k);
        }

        for (int i = 2; i < N; i++) {
            for (int j = 0; i + j < N; j++) {
                for (int k = j; k < i + j; k++) {
                    int n = arr[j][k].y;
                    int m = arr[j][k].x;
                    int l = arr[k + 1][i + j].x;
                    int cnt = arr[k + 1][i + j].cnt;

                    if (arr[j][i + j] == null)
                        arr[j][i + j] = new Matrix(n, l, cnt + n * m * l);
                    else
                        arr[j][i + j] = Math.min(arr[i][i + j], )
                }
            }
        }

        for (int j = 2; j < dp.length; j++) {
            for (int i = 0; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }
        }
    }
}
