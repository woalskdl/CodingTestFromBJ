package d211005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P11066_my {

    private static int T;
    private static List<Integer> sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            sumList = new ArrayList<>();

            int K = Integer.parseInt(st.nextToken());
            int[] files = new int[K];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; j++)
                files[j] = Integer.parseInt(st.nextToken());

            dp(0, files);
            System.out.println(sumList.toString());
            System.out.println(Collections.min(sumList));
        }
    }

    private static int dp(int sum, int[] files){
        if(files.length == 1){
//            sum += files[0];
            sumList.add(sum);
            System.out.println("sum : " + sum);
            return sum;
        }

        for(int i=0, length = files.length; i<length-1; i++){
            int[] temp = new int[length - 1];
            for(int j=0, tempLength = temp.length; j<tempLength; j++){
                if(j == i){
                    temp[j] = files[j] + files[j + 1];
                    sum += temp[j];
                    System.out.print(temp[j] + " ");
                }else if(j > i){
                    temp[j] = files[j + 1];
                    System.out.print(temp[j] + " ");
                }else{
                    temp[j] = files[j];
                    System.out.print(temp[j] + " ");
                }

            }
            System.out.println();
            sumList.add(dp(sum, temp));
        }

        return 0;
    }
}

