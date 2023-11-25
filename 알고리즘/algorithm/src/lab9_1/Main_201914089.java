package lab9_1;

import java.util.Scanner;



public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("lab9_1:오동재");
        Scanner scanner = new Scanner(System.in);

        // 동전 종류 개수(n)와 n가지 동전 액면을 입력
        int n = scanner.nextInt();// 동전 종류 개수
        int[] coins = new int[n];       // 동전 액면
        for(int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // 원하는 금액 amount를 입력
        int amount = scanner.nextInt();
        scanner.close();

        // 최소 동전 개수를 구함
        int[] dp = new int[amount + 1];  // dp[i]는 금액 i를 만들기 위해 필요한 최소 동전수
        int[] use = new int[amount + 1]; // use[i]는 금액 i를 만들 때 어떤 액면의 동전이 마지막으로 사용되었는지를 나타냄

        // 배열 초기화
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0; // 0원을 만드는데 필요한 동전 개수는 0개

        // 동전 교환 알고리즘 구현
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        if (dp[amount] == amount + 1) {  // 나올 수 없는 큰 값이 그대로 저장되어 있으면
            System.out.println("해가 없습니다.");
        } else {
            System.out.println("최소 동전수 = " + dp[amount]);
        }

        // 확인을 위해 자료구조 출력
        for(int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
        for(int i = 0; i < use.length; i++)
            System.out.print(use[i] + " ");
    }
}