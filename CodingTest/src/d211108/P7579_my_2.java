package d211108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7579_my_2 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;

        int[] memoryArr = new int[N];
        int[] costArr = new int[N];
        int[][] dp = new int[N][100001];

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        StringTokenizer s2 = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            memoryArr[i] = Integer.parseInt(s1.nextToken());
            costArr[i] = Integer.parseInt(s2.nextToken());
        }

        for(int i=0; i<N; i++){
            int cost = costArr[i];
            int memory = memoryArr[i];

            for(int j=0; j<=10000; j++){
                if(i == 0){
                    if(j >= cost )
                        dp[i][j] = memory;
                }else {
                    if(j >= cost)
                        dp[i][j] = Math.max(dp[i-1][j-cost] + memory, dp[i-1][j]);
                    else
                        dp[i][j] = dp[i-1][j];
                }

                if(dp[i][j] >= M)
                    result = Math.min(result, j);
            }
        }

        System.out.println(result);

    }
}
