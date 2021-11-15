package d211115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1463_answer_1 {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        System.out.println(cal(N));
    }

    private static int cal(int n){
        if(n <= 1)
            return arr[n];

        if(n % 6 == 0)
            arr[n] = Math.min(cal(n - 1), Math.min(cal(n / 3), cal(n / 2))) + 1;
        else if(n % 3 == 0)
            arr[n] = Math.min(cal(n / 3), cal(n - 1)) + 1;
        else if(n % 2 == 0)
            arr[n] = Math.min(cal(n / 2), cal(n - 1)) + 1;
        else
            arr[n] = cal(n - 1) + 1;

        return arr[n];
    }
}
