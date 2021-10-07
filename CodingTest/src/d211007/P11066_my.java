package d211007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

            System.out.println(bfs(new Plus(0, files)));
//            dp(0, files);
//            System.out.println(sumList.toString());
//            System.out.println(Collections.min(sumList));
        }
    }

    static class Plus {
        int sum;
        int[] files;

        public Plus(int sum, int[] files) {
            this.sum = sum;
            this.files = files;
        }
    }

    private static int bfs(Plus plus){
        Queue<Plus> queue = new LinkedList<>();
        queue.add(plus);

        while (!queue.isEmpty()){
            Plus p = queue.poll();

            int[] files = p.files;
            int sum = p.sum;
            System.out.println(Arrays.toString(files) + " : " + sum);

            if(files.length == 1){
                sumList.add(sum);
                System.out.println("sum : " + sum);
                continue;
            }

            for(int i=0, length = files.length; i<length - 1; i++){
                int[] temp = new int[length - 1];
                int num = sum;

                for(int j=0, tempLength = temp.length; j<tempLength; j++){
                    int x = files[j];
                    int nx = files[j + 1];
                    if(j == i){
                        temp[j] = x + nx;
                        num += (x + nx);
                    }else if(j > i){
                        temp[j] = nx;
                    }else{
                        temp[j] = x;
                    }
                }

                queue.add(new Plus(num, temp));
            }
        }

        return Collections.min(sumList);
    }

    private static int dp(int sum, int[] files){
        if(files.length == 1){
            sumList.add(sum);
            System.out.println("sum : " + sum);
            return sum;
        }

        for(int i=0, length = files.length; i<length-1; i++){
            int[] temp = new int[length - 1];
            int num = sum;

            for(int j=0, tempLength = temp.length; j<tempLength; j++){
                if(j == i){
                    temp[j] = files[j] + files[j + 1];
                    num += temp[j];
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

            sumList.add(dp(num, temp));
        }

        return 0;
    }
}

