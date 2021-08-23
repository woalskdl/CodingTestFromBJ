package d210816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050_my {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 1;

        if(K != 0){
            int top = 1;
            int bottom = 1;

            for(int i=0; i<K; i++){
                top *= N--;
            }

            for(int i=0; i<K; i++){
                bottom *= (K-i);
            }

            result = top / bottom;
        }

        System.out.println(result);
    }
}