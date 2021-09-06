package d210906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2749_answer {

    private static long n;
    private static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        int a = 1500000;
        if(n > a)
            n %= a;

        arr = new int[a + 1];
        arr[1] = 1;
        for(int i=2; i<=a; i++){
            if(i > n)
                break;
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000;
        }

        System.out.println(arr[(int) n]);
    }
}