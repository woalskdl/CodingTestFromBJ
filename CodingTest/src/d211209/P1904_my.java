package d211209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904_my {
    private static int N;
    private static Long[][] dp;
    private static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][3];

        // 0 >> 1, 1 >> 첫번째 0, 2 >> 두번째 0
        dp[1][0] = 1L;
        dp[1][1] = 0L;
        dp[1][2] = 1L;

        long result = 0;

        for (int i = 0; i < 2; i++)
            result += recur(N, i);

        System.out.println(result % MOD);

    }

    private static long recur(int digit, int val) {
        if (digit == 1)
            return dp[digit][val];

        if (dp[digit][val] == null) {
            if (val == 1)
                dp[digit][val] = recur(digit - 1, 2);
            else
                dp[digit][val] = recur(digit - 1, 0) + recur(digit - 1, 1);
        }

        return dp[digit][val] % MOD;
    }
}
