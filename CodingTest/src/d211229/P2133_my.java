package d211229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2133_my {
    private static int N;
    private static Integer[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        arr = new Integer[N + 1][3];

        // 0 > 첫번쨰 1, 1 > 두번째 1, 2 > 2
        arr[1][0] = 2;
        arr[1][1] = 0;
        arr[1][2] = 2;

    }

    private int dp(int pos, int val, int count){
        if(pos == N)
            return count;

        for(int i=0; i<3; i++){
            if(val == 0)
                arr[pos][i] = dp(pos + 1, 1, count + 1);
            else if(val == 1 || val == 2)
                arr[pos][i] = dp(pos + 1, 0, count + 1) + dp(pos + 1, 2, count + 1);
        }

        return 0;
    }

    private int recur(int pos, int[][] input, int count){
        if(pos == 1)
            return count + input[pos][0] + input[pos][1] + input[pos][2];

        int[][] arr = new int[3][3];

        for(int i=0; i<3; i++){
            arr[i][0] = input[i][1] + input[i][2];
            arr[i][1] = input[i][0];
            arr[i][2] = input[i][1] + input[i][2];

            count += arr[i][0];
            count += arr[i][1];
            count += arr[i][2];
        }

        return recur(pos - 1, arr, count);
    }
}
