package d211220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1699_my {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 0;
        while (true){
            int a = (int) Math.floor(N);
            count += 1;

            int b = N - a;
            if(b == 0){
                break;
            }
        }

        System.out.println(count);
    }
}
