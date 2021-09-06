package d210906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9471_my {
    static private int P;
    static private int[] arr;

    static private int[] pow2ck;
    static private int[] pow5ck;
    static private int[] pow5dbck;
    static private int[] pow10ck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());

        arr = new int[P + 1];
        for(int i=1; i<=P; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

    }
}
