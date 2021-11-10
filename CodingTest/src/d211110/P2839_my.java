package d211110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2839_my {
    private static final int A = 3;
    private static final int B = 5;

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        System.out.println(find());
    }

    private static int find(){
        int result = Integer.MAX_VALUE;

        int div1;
        int div2;
        int r;

        div1 = N / A;

        for(int i=div1; i >= 0; i--){
            if(i != 0)
                r = N - (i * A);
            else
                r = N;

            if(r % B == 0){
                div2 = r / B;
                result = Math.min(i + div2, result);
            }
        }

        if(result == Integer.MAX_VALUE)
            return -1;

        return result;
    }
}
