package d211007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11066_answer {
    private static int T;
    private static List<Integer> sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            sumList = new ArrayList<>();

            int K = Integer.parseInt(st.nextToken());
            int[] files = new int[K];
            int[] sum = new int[K];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; j++){
                int num = Integer.parseInt(st.nextToken());
                files[j] = num;
                if(j == 0)
                    sum[j] = files[0];
                else
                    sum[j] += (sum[j - 1] + files[j]);
            }
        }
    }

    private static int sumDist(int[] sum, int start, int end){
        if(start == 0)
            return sum[end];

        return sum[end] - sum[start - 1];
    }

    private static int sol(int[] files, int[] sum){
        int[][] dp = new int[files.length][files.length];

        for(int i=0; i<dp.length; i++)
            dp[i][i + 1] = files[i] + files[i + 1];

        for (int j=2; j<dp.length; j++){
            for(int i=0; i + j < dp.length; i++){
                for(int k=i; k<i + j; k++){
                    if(dp[i][j+j] == 0){
                        dp[i][i+j] = dp[i][j] + dp[k+1][i+j] + sumDist(sum, i, i+j);
                    }else{
                        dp[i][i+j] = Math.min(dp[i][i+j], dp[i][j] + dp[k+1][i+j] + sumDist(sum,i,i+j));
                    }
                }
            }
        }

        return dp[0][dp.length - 1];
    }
}
