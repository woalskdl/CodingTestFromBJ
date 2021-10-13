package d211013;

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
                    int cnt1 = arr[j][k].cnt;
                    int l = arr[k + 1][i + j].x;
                    int cnt2 = arr[k + 1][i + j].cnt;

                    if (arr[j][i + j] == null){
                        arr[j][i + j] = new Matrix(n, l, (cnt1 + cnt2 + n * m * l));
                    } else {
                        int min = Math.min(arr[j][i + j].cnt, (cnt1 + cnt2 + n * m * l));
                        arr[j][i + j] = new Matrix(n, l, min);
                    }
                }
            }
        }

        System.out.println(arr[0][N-1].cnt);
    }
}
