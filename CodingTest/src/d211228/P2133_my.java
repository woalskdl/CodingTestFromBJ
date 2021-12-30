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

        arr = new Integer[N + 1][10];

//        220 > 0
//        022 > 1
//        000 > 2
//        221 > 3 //
//        001 > 4
//        122 > 5 //
//        100 > 6
//        111 > 7 //
//        110 > 8
//        011 > 9

        arr[1][0] = arr[1][1] = arr[1][2] = 1;
        arr[1][3] = arr[1][4] = arr[1][5] = arr[1][6] = arr[1][7] = arr[1][8] = arr[1][9] = 0;
        
        for(int i=2; i<=N; i++){
            arr[i][0] = arr[i][1] = arr[i][2] = arr[i - 1][3] + arr[i - 1][5] + arr[i - 1][7];
            arr[i][3] = arr[i][4] = arr[i - 1][0];
            arr[i][5] = arr[i][6] = arr[i - 1][1];
            arr[i][7] = arr[i - 1][2];
            arr[i][8] = arr[i - 1][4];
            arr[i][9] = arr[i - 1][6];
        }

        System.out.println(arr[N][3] + arr[N][5] + arr[N][7]);

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

    private int recur(int pos, int idx, int count){
        if(pos == 1)
            return count;

        arr[pos][0] = arr[pos][1] = arr[pos][2] = recur(pos - 1, 3, arr[pos - 1][3]) + recur(pos - 1, 5, arr[pos - 1][5]) + recur(pos - 1, 7, arr[pos - 1][7]);
        arr[pos][3] = arr[pos][4] = recur(pos - 1, 0, arr[pos - 1][0]);
        arr[pos][5] = arr[pos][6] = recur(pos - 1, 1, arr[pos - 1][1]);
        arr[pos][7] = recur(pos - 1, 2, arr[pos - 1][2]);
        arr[pos][8] = recur(pos - 1, 4, arr[pos - 1][4]);
        arr[pos][9] = recur(pos - 1, 6, arr[pos - 1][6]);

        for(int i : arr[pos])
            count += arr[pos][i];

        return count;
    }

//    private int recur(int pos, int[][] input, int count){
//        if(pos == 1)
//            return count + input[pos][0] + input[pos][1] + input[pos][2];
//
//        int[][] arr = new int[3][3];
//
//        for(int i=0; i<3; i++){
//            arr[i][0] = input[i][1] + input[i][2];
//            arr[i][1] = input[i][0];
//            arr[i][2] = input[i][1] + input[i][2];
//
//            count += arr[i][0];
//            count += arr[i][1];
//            count += arr[i][2];
//        }
//
//        return recur(pos - 1, arr, count);
//    }
}
