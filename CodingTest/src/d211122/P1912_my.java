package d211122;

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
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0, length = arr.length; i < length; i++)
            list.add(dp(i, Integer.MIN_VALUE));

        System.out.println(list);
        System.out.println(Collections.max(list));

    }

    private static int dp(int i, int sum) {
        if(i >= n)
            return sum;

        if(sum + arr[i] < 0)
            return sum;

        return dp(i + 1, sum + arr[i]);
    }
}
