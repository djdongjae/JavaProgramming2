package BOJ_11403;

import java.util.*;

public class Main {

    public static final int INF = (int) 1e9;
    public static int n;
    public static int[][] graph = new int[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < n; n++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                graph[i][j] = x;
            }
        }

        for (int k = 0; k < n; )


    }

}
