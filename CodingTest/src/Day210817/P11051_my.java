package Day210817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051_my {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        System.out.println(BCM(N, K));
    }

    static int BCM(int n, int k){
        if(dp[n][k] != 0)
            return dp[n][k];

        if(n == k || k == 0)
            return dp[n][k] = 1;

        return dp[n][k] = (BCM(n - 1, k - 1) + BCM(n - 1, k)) % 10007;
    }
}
