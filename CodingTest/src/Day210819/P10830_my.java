package Day210819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10830_my {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] input = new int[N][N];
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                input[i][j] = num;
                arr[i][j] = num;
            }
        }

        for(long i=1; i<B; i++){
            int[][] temp = new int[N][N];
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    int tempNum = 0;
                    for(int l=0; l<N; l++){
                        tempNum += arr[j][l] * input[l][k];
                    }
                    temp[j][k] = tempNum % 1000;
                }
            }
            arr = temp;
            temp = null;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]);
                if(j != N-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
