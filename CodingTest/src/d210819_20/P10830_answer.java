package d210819_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10830_answer {

    public static int N;
    public final static int MOD = 1000;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = sq(arr, B);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(result[i][j]);
                if(j != N-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] sq(int[][] a, long exp){
        if(exp == 1L)
            return a;

        int[][] ret = sq(a, exp / 2);

        ret = mul(ret, ret);

        if(exp % 2 == 1L)
            ret = mul(ret, arr);

        return ret;
    }

    public static int[][] mul(int[][] a1, int[][] a2){
        int[][] ret = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    ret[i][j] += a1[i][k] * a2[k][j];
                }
                ret[i][j] %= MOD;
            }
        }

        return ret;
    }
}
