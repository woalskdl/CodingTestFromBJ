package d210907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9471_my {

    static final int SIZE = 1000001;

    static private int P;
    static private int[] arr;

    static private Info[] powCk;
    static private class Info{
        private int i;
        private int ck;

        public Info(int i, int ck) {
            this.i = i;
            this.ck = ck;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());

        arr = new int[P + 1];
        for(int i=1; i<=P; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        powCk = new Info[SIZE];

        boolean ck1 = true;
        boolean ck2 = true;
        boolean ck3 = true;
        boolean ck4 = true;
        int num;
        for(int i=1; ck1 || ck2 || ck3 || ck4; i++){
            if(ck4){
                num = (int) Math.pow(10, i);
                System.out.println(4 + " : " + num);
                if(ck4 = num < SIZE)
                    powCk[num] = new Info(i, 4);
            }

            if(ck2 || ck3){
                num = (int) Math.pow(5, i);
                System.out.println(3 + "," + 2 + " : " + num);
                if(ck3 = num * 2 < SIZE){
                    System.out.println(num * 2);
                    powCk[num * 2] = new Info(i, 3);
                }
                if(ck2 = num < SIZE)
                    powCk[num] = new Info(i, 2);
            }

            if(ck1){
                num = (int) Math.pow(2, i);
                System.out.println(1 + " : " + num);
                if(ck1 = num < SIZE)
                    powCk[num] = new Info(i, 1);
            }
        }

        for(int i=1; i<arr.length; i++){
            int result = 0;
            System.out.println(arr[i]);
            if(powCk[arr[i]].ck == 1)
                result = (int) (3 * Math.pow(2, powCk[arr[i]].i - 1));
            if(powCk[arr[i]].ck == 2)
                result = (int) (4 * Math.pow(5, powCk[arr[i]].i));
            if(powCk[arr[i]].ck == 3)
                result = 6 * powCk[arr[i]].i;
            if(powCk[arr[i]].ck == 4)
                result = (int) (15 * Math.pow(10, powCk[arr[i]].i - 1));

            System.out.println(i + " " + result);
        }

    }
}
