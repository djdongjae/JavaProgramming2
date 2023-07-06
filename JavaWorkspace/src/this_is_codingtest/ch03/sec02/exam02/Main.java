package this_is_codingtest.ch03.sec02.exam02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) { // 각 줄을 순회하며
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x); // 지역 예선 최소값 팀
            }
            result = Math.max(result, min_value); // 전국 본선 최대값 팀
        }

        System.out.println(result); // 결과 출력
    }

}
