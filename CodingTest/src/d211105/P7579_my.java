package d211105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7579_my {
    private static int N;
    private static int M;

    private static App[][] apps;

    private static class App {
        int memory;
        int cost;

        public App() {
        }

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apps = new App[N][N];
        // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                apps[i][j] = new App();
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            apps[i][i].memory = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            apps[i][i].cost = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++)
            apps[i][i + 1] = new App(apps[i][i].memory + apps[i + 1][i + 1].memory, apps[i][i].cost + apps[i + 1][i + 1].cost);

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                for (int k = j; k < i + j; k++) {
                    int memory = apps[j][k].memory + apps[k + 1][i + j].memory;
                    int cost = 0;
                    if(apps[j][i+j].cost == 0)
                        cost = apps[j][k].cost + apps[k + 1][i + j].cost;
                    else
                        cost = Math.min(apps[j][i + j].cost, apps[j][k].cost + apps[k + 1][i + j].cost);
                    apps[j][i + j] = new App(memory, cost);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (apps[i][j].memory >= M && result > apps[i][j].cost)
                    result = apps[i][j].cost;
            }
        }

        System.out.println(result);

    }
}
