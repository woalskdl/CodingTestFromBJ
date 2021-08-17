package Day210817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10430_my {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append((A + B) % C);
        sb.append("\n");

        sb.append(((A % C) + (B % C)) % C);
        sb.append("\n");

        sb.append((A * B) % C);
        sb.append("\n");

        sb.append(((A % C) * (B % C)) % C);
        System.out.println(sb);
    }
}
