package d210930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066_my {
    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int[] files = new int[K];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; j++)
                files[j] = Integer.parseInt(st.nextToken());
        }
    }


}
