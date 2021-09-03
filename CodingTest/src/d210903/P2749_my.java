package d210903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2749_my {

    private static long n;
    private static int arr[];
    private static final int SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        arr = new int[SIZE];

        while(n > SIZE){

        }
        System.out.println(pvn(n));
    }

    private static int pvn(long n){
        if(n > SIZE){
//            int result = ((pvn(n / 2) % 1000000) + (pvn(n / 2) % 1000000));
//            if(n % 2 != 0)
//                result +=
            return ((pvn(n / 2) % 1000000) + (pvn(n / 2) % 1000000));
        }

        if(arr[(int) n] != 0)
            return arr[(int) n];

        if(n == 0)
            return arr[(int) n] = 0;

        if(n == 1)
            return arr[(int) n] = 1;

        return arr[(int) n] = ((pvn(n-1) % 1000000) + (pvn(n-2) % 1000000)) % 1000000;
    }

//    private static int bi(){
//        int result = 0;
//        while (n > SIZE){
//            result +=
//        }
//    }
}