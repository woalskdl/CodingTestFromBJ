package d211117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9095_my {
    private static int T;
    private static int N;

    private static int[] cnt1;
    private static int[] cnt2;
    private static int[] cnt3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            cnt1 = new int[N];
            cnt2 = new int[N];
            cnt3 = new int[N];

        }
    }
}
