package noeunha.hw.hw5_1;

import java.util.Scanner;

public class Main_201914089 {
    public static void main(String[] args) {

        System.out.println("noeunha.hw.hw5_1:오동재");

        // 사용자가 원하는 정수 갯수(n)와 n개의 정수값을 입력받아 배열에 저장
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        // 몇번째 작은 값을 찾고자 하는지 정보(i)를 입력
        int i = input.nextInt();
        // n개의 배열 원소들 중에서 i번째 작은 수를 찾아 출력
        System.out.println(select(array, 0, n-1, i));
        input.close();

    }

    // 배열 array[p...r]에서 인덱스 i에 위치한 원소를 찾는다.
    private static int select(int[] array, int p, int r, int i) {
        // 배열의 범위가 1인 경우 해당 원소 반환
        if (p == r) return array[p];
        // array[r]을 pivot으로 두는 파티션 알고리즘을 통해 q를 반환
        int q = partition(array, p, r);
        // 해당 pivot의 위치가 범위 시작으로부터 얼마나 떨어져 있는지 계산
        int k = q - p + 1;
        // 인덱스가 해당 거리보다 작으면 왼쪽 탐색
        if (i < k) return select(array, p, q - 1, i);
        // 해당 인덱스면 바로 반환
        else if (i == k) return array[q];
        // 인덱스가 해당 거리보다 크면 오른쪽 탐색
        else return select(array, q+1, r, i - k);
    }

    private static int partition(int[] array, int p, int r)  {
        int x = array[r]; // 기준원소 pivot의 값
        int i = p - 1; // 기준보다 작은 수를 저장하는 영역의 마지막 부분
        for (int j = p; j <= r-1; j++) { // 검사할 영역을 순회하며
            if (array[j] < x) { // pivot보다 값이 작을 경우
                int k = ++i; // 해당 값을 저장할 위치
                int tmp = array[k];
                array[k] = array[j]; // 기준보다 작은 수와 array[i + 1] 위치 교환
                array[j] = tmp;
            }
        }

        // pivot과 pivot보다 큰 수를 저장하는 영역의 첫 번째 원소를 교환
        int result = i + 1;
        int tmp = array[result];
        array[result] = array[r];
        array[r] = tmp;
        return result; // pivot을 새롭게 저장한 위치 반환
    }
}
