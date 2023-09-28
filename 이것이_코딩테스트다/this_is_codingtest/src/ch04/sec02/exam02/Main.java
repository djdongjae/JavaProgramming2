package ch04.sec02.exam02;

import java.util.Scanner;

// chap04 구현 118p 게임 개발
public class Main {

    public static int n, m, x, y, direction;
    public static int[][] visited = new int[50][50];
    public static int[][] map = new int[50][50];

    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        visited[x][y] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 1;
        int turn_times = 0;
        int nx = -1, ny = -1;
        while (true) {
            turn_left();
            nx = x + dx[direction];
            ny = y + dy[direction];
            if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                x = nx;
                y = ny;
                count++;
                visited[nx][ny] = 1;
                turn_times = 0;
                continue;
            } else {
                turn_times++;
            }

            if (turn_times == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];
                if (map[nx][ny] == 1) break;
                else {
                    x = nx;
                    y = ny;
                    turn_times = 0;
                }
            }
        }

        System.out.println(count);
    }

}
