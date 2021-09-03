package d210903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2747_my {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[46];

        System.out.println(pvn(n));
    }

    private static int pvn(int n){
        if(arr[n] != 0)
            return arr[n];

        if(n == 0)
            return arr[n] = 0;

        if(n == 1)
            return arr[n] = 1;

        return arr[n] = pvn(n-1) + pvn(n-2);
    }
}