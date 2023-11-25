package hw9_1;

import java.util.Scanner;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("hw9_1:오동재");
        Scanner scanner = new Scanner(System.in);

        // 동전 종류 개수와 n가지 동전 단위를 입력받음
        int n = scanner.nextInt(); // 동전 종류 개수
        int[] coins = new int[n]; // 동전 단위 배열
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // 목표 금액을 입력받음
        int amount = scanner.nextInt();
        scanner.close();

        // 최소 동전 개수를 구하기 위한 배열 초기화
        int[] dp = new int[amount + 1]; // dp[i]는 금액 i를 만들기 위해 필요한 최소 동전수
        int[] use = new int[amount + 1]; // use[i]는 금액 i를 만들 때 어떤 단위의 동전이 마지막으로 사용되었는지를 나타냄

        // 각 금액을 만드는데 필요한 최소 동전 수를 최대값으로 설정
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // 초기값 설정, 이 값은 최소 동전 개수를 나타내는데 사용됨
        }
        dp[0] = 0; // 0원을 만드는데 필요한 동전 개수는 0개

        // 동전 교환 알고리즘 구현
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 현재 금액 i를 coin만큼 뺄 수 있고, 그 동전을 사용했을 때 최소 동전 개수가 갱신될 경우
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1; // 최소 동전 개수 업데이트
                    use[i] = coin; // 어떤 액면의 동전을 사용했는지 기록
                }
            }
        }

        // 동전 개수가 나올 수 없는 경우 처리
        if (dp[amount] == amount + 1) {
            System.out.println("해가 없습니다.");
        } else {
            System.out.println("최소 동전수 = " + dp[amount]);

            // 각 동전의 개수를 출력
            for (int i = coins.length - 1; i >= 0; i--) {
                int coinCount = 0;
                // 목표 금액을 coins[i] 단위의 동전으로 만들 수 있는 동안 반복
                while (amount >= coins[i] && dp[amount] == dp[amount - coins[i]] + 1) {
                    amount -= coins[i]; // 금액 업데이트
                    coinCount++; // 동전 개수 증가
                }
                System.out.println(coins[i] + "원 동전 " + coinCount + "개");
            }
        }
    }
}
