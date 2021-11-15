package d211115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_answer_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(cal(N, 0));
    }

    private static int cal(int n, int count){
        if(n < 2)
            return count;

        return Math.min(cal(n / 2, count + 1 + (n % 2)), cal(n / 3, count + 1 + (n % 3)));
    }
}
