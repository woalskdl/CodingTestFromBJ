package Day210820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2933_my_later {

    static int R;
    static int C;
    static String[][] cave;

    static int count;
    static int[] heights;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new String[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++){
                cave[i][j] = st.nextToken();
            }
        }

        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        heights = new int[count];
        for(int i=0; i<count; i++)
            heights[i] = Integer.parseInt(st.nextToken());



    }
}
