package d211108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7579_my {
    private static int N;
    private static int M;

    private static App[] apps;

    private static class App {
        long memory;
        int cost;
        List<Integer> list;

        public App() {
        }

        public App(long memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apps = new App[N];
        // 초기화
        for (int i = 0; i < N; i++)
            apps[i] = new App();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            apps[i].memory = Long.parseLong(st.nextToken());

        Queue<App> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++){
            apps[i].cost = Integer.parseInt(st.nextToken());
            apps[i].list = new ArrayList<>();
            apps[i].list.add(i);
            queue.add(apps[i]);
        }

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            App app = queue.poll();
            if(app.memory >= M && app.cost < result){
                result = app.cost;
                continue;
            }

            for(int i=0; i<N; i++){
                if(!app.list.contains(i)){
                    long memory = app.memory + apps[i].memory;
                    int cost = app.cost + apps[i].cost;
                    List<Integer> list = new ArrayList<>();
                    list.addAll(app.list);
                    list.add(i);

                    App nApp = new App();

                    nApp.memory = memory;
                    nApp.cost = cost;
                    nApp.list = list;

                    queue.add(nApp);
                }
            }
        }

        System.out.println(result);

    }
}
