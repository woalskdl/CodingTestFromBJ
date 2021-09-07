package d210907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2941_answer {
    static private int P;
    static private int[] input;
    static private int[] arr;
    static private final int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        input = new int[P+1];
        for(int i=1; i<=P; i++){
            st = new StringTokenizer(br.readLine(), " ");
            input[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        arr = new int[SIZE];
        arr[1] = arr[2] = 1;
        for(int i=1; i<=P; i++){
            int result = 3;
            for(int j=3; j<SIZE; j++){
                arr[j] =  (arr[j-1] % input[i] + arr[j-2] % input[i]) % input[i];
                if(j != 3 && arr[j] == 1 && arr[j - 1] == 1){
                    result -= 2;
                    break;
                }
                result += 1;
            }
            System.out.println(i + " " + result);
        }

    }
}
