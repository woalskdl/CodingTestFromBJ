package d211129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10844_my {

    private static int N;
    private static int result;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        result = 0;

        for (int i = 1; i < 10; i++)
            dp(i, 1);

//        arr = new int[101];
//        arr[1] = 9;
//        arr[2] = 17;



        System.out.println(result);

    }

    private static void dp(int i, int size) {
        if (size >= N) {
            result = (result + 1) % 1000000000;
            return;
        }

        if (i > 0)
            dp(i - 1, size + 1);

        if (i < 9)
            dp(i + 1, size + 1);

    }

}
