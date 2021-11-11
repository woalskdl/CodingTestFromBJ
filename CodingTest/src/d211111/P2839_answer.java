package d211111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2839_answer {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        if(N == 4 || N == 7)
            System.out.println(-1);
        else if(N % 5 == 0)
            System.out.println(N / 5);
        else if(N % 5 == 1)
            System.out.println((N / 5 - 1) + 2);
        else if(N % 5 == 2)
            System.out.println((N / 5 - 2) + 4);
        else if(N % 5 == 3)
            System.out.println((N / 5) + 1);
        else if(N % 5 == 4)
            System.out.println((N / 5 - 1) + 3);
    }
}
