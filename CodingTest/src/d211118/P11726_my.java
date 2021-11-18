package d211118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11726_my {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        if (n >= 1)
            arr[1] = 1;
        if (n >= 2)
            arr[2] = 2;

        for (int i = 3; i <= n; i++)
            arr[i] = (arr[i - 1] % 10007 + arr[i - 2] % 10007) % 10007;

        System.out.println(arr[n]);

    }
}
