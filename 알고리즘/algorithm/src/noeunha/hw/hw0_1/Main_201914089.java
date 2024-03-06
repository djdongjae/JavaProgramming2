package noeunha.hw.hw0_1;

import java.util.Scanner;

public class Main_201914089 {
    public static void main(String[] args) {
        System.out.println("noeunha.hw.hw0_1:오동재");

        Scanner sc = new Scanner(System.in);
        int ib = sc.nextInt(); // 하한 입력
        int ub = sc.nextInt(); // 상한 입력

        int[] array = new int[ub - ib + 1]; // [ib, ub] 구간 크기의 배열 생성 (0으로 초기화)

        int n = sc.nextInt(); // 입력 받을 n 입력

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 해당 숫자 입력
            array[num - ib] += 1; // 해당 숫자와 같은 배열 인덱스를 가진 위치의 값 1 증가
        }

        for (int x : array) {
            System.out.print(x + " "); // 순회하며 배열을 출력
        }

        sc.close();

    }
}
