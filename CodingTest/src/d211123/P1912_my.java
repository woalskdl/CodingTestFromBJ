package d211123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1912_my {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(dp(0, arr[0]));
    }

    private static int dp(int i, int sum) {
        if (i >= n - 1)
            return sum;

        if(sum + arr[i + 1] < 0)
            return Math.max(sum, dp(i + 1, arr[i + 1]));

        return Math.max(sum, dp(i + 1, sum + arr[i + 1]));
    }
}