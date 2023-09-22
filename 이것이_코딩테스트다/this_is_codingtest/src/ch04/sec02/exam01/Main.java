package ch04.sec02.exam01;

import java.util.*;

// chap04 115p 왕실의 나이트
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String now = sc.next();
        int x = now.charAt(0) - 'a' + 1;
        int y = now.charAt(1) - '0';

        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = -1;
            int ny = -1;
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
                count++;
            }
        }

        System.out.println(count);
    }
}
