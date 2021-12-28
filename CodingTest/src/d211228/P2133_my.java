package d211228;

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
        arr[1][0] = 4;
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
}
