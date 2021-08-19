package Day210818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11401_my {

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N+1][K+1];

        System.out.println(BCD(N, K));
    }

    public static long BCD(int n, int k){
        if(n == k || k == 0)
            return dp[n][k] = 1;

        if(dp[n][k] != 0)
            return dp[n][k];

        return dp[n][k] = (BCD(n-1, k-1) + BCD(n-1, k)) % 1000000007;
    }
}
