package d211226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699_my {
    private static int N;
    private static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N + 1];

        System.out.println(dp(N));
    }

    private static int dp(int val){
        if(val == 0)
            return 0;

        if(arr[val] != null)
            return arr[val];

        int a = (int) Math.floor(Math.sqrt(val));
        arr[val] = Integer.MAX_VALUE;
        for(int i=a; i>0; i--)
            arr[val] = Math.min(arr[val], dp(val - (int) Math.pow(i, 2)) + 1);

        return arr[val];
    }
}