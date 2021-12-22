package d211222;

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

        System.out.println(dp(N, 0));
    }

    private static int dp(int val, int count){
        if(val == 0)
            return count;

        int a = (int) Math.floor(Math.sqrt(val));
        for(int i=a; i>0; i--){
            if(arr[val] == null)
                arr[val] = dp(val - (int) Math.pow(i, 2), count + 1);
            else
                arr[val] = Math.min(arr[val], dp(val - (int) Math.pow(i, 2), count + 1));
        }

        return arr[val];
    }
}