package hw.hw4_2;

import java.util.Scanner;

public class Main_201914089 {

    public static void main(String[] args) {
        System.out.println("hw.hw4_2:오동재");
        Scanner sc = new Scanner(System.in);

        // 입력받을 개수인 n 입력
        int n = sc.nextInt();
        // 크기 n의 배열을 생성
        int[] array = new int[n];
        // n개의 정수 입력받아 배열에 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        // 퀵 정렬 수행
        quickSort(array, 0, array.length - 1);
        System.out.println("퀵 정렬, nlogn");

        // 배열 출력
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }

    // partition 알고리즘
    public static int partition(int[] array, int p, int r) {
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

    // 퀵 정렬 알고리즘
    public static void quickSort(int[] array, int p, int r) {
        if (p < r) { // 정렬한 원소 수가 2이상일 경우
            int q = partition(array, p, r); // pivot 기준으로 분할
            quickSort(array, p, q - 1); // 왼쪽 부분배열 정렬
            quickSort(array, q+1, r); // 오른쪽 부분배열 정렬
        }
    }

}
