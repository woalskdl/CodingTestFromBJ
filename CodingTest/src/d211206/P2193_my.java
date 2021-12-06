package d211206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193_my {

    private static int N;
    private static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][2];

        for (int i = 0; i < 2; i++)
            dp[1][i] = 1L;

        System.out.println(recur(N, 1));
    }

    private static long recur(int digit, int val) {
        if (digit == 1)
            return dp[digit][val];

        if (dp[digit][val] == null) {
            if (val == 1)
                dp[digit][val] = recur(digit - 1, 0);
            else
                dp[digit][val] = recur(digit - 1, 0) + recur(digit - 1, 1);
        }

        return dp[digit][val];
    }
}