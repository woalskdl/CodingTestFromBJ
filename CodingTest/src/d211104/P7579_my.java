package d211104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7579_my {
    private static int N;
    private static long M;

    private static App[] apps;

    private static class App implements Comparable<App>{
        int memory;
        int cost;

        public App(int memory) {
            this.memory = memory;
        }

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public int compareTo(App o) {
            if(this.memory < o.memory)
                return -1;
            else if(this.memory == o.memory)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        apps = new App[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            apps[i] = new App(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            apps[i].cost = Integer.parseInt(st.nextToken());

        Arrays.sort(apps, Collections.reverseOrder());
        Stack<App> stack = new Stack<>();

        int result = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            App app = apps[i];
            int memory = app.memory;
            int cost = app.cost;

            if(memory >= M){
                if(result > cost){
                    result = cost;
                }
            }else{
                stack.push(app);
                for(int j=i; j<N; j++){
                    memory += apps[j].memory;
                    stack.push(apps[j]);
                }
            }
        }

    }
}
