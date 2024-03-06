package noeunha.hw.hw4_1;

import java.util.Scanner;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("noeunha.hw.hw4_1:오동재");
        Scanner sc = new Scanner(System.in);

        // 입력받을 개수인 n 입력
        int n = sc.nextInt();
        // 크기 n의 배열을 생성
        int[] array = new int[n];
        // n개의 정수 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // 병합정렬 수행
        mergeSort(array, 0, array.length - 1);
        // 출력
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }

    }

    // 병합 정렬 함수
    public static void mergeSort(int[] array, int lb, int ub) {
        if (lb < ub) { // 시작점이 끝점보다 작을 경우
            int m = (lb + ub) / 2; // 중간값 지정
            mergeSort(array, lb, m); // 전반부 정렬
            mergeSort(array, m+1, ub); // 후반부 정렬
            merge(array, lb, m, ub); // 병합
        }
    }


    // 정렬된 두 부분 배열 array[lb...m], array[m+1...ub]를 병합하여 정렬된 배열 array[lb...ub]를 얻음
    public static void merge(int[] array, int lb, int m, int ub) {
        int[] tmp = new int[array.length]; // 결과를 임시 저장할 tmp 배열 생성
        int left = lb; // 왼쪽 배열의 시작점
        int right = m + 1; // 오른쪽 배열의 시작점
        int index = left; // tmp 배열의 시작점

        while (left <= m && right <=ub) { // 왼쪽 배열과 오른쪽 배열의 인덱스가 범위를 벗어나지 않는 동안
            if ((array[left] % 10) <= (array[right] % 10)) { // 왼쪽 값과 오른쪽 값을 비교하며
                tmp[index] = array[left]; // 왼쪽이 작을 경우 먼저 저장
                left++; // 왼쪽 인덱스 1 증가
            } else {
                tmp[index] = array[right]; // 오른쪽이 작을 경우 먼저 저장
                right++; // 오른쪽 인덱스 1 증가
            }
            index++; // 임시 배열 인데스 증가
        }

        // 왼쪽 오른쪽 중 아직 다 순회하지 못한 배열에 대해 처리
        if (left <= m && right > ub) { // 왼쪽 배열이 아직 전부 처리되지 못했을 경우
            while (left <= m) { // 남은 왼쪽 배열을 순회하며
                tmp[index] = array[left]; // 임시 배열에 저장
                left++;
                index++;
            }
        } else if(left > m && right <= ub) { // 오른쪽 배열이 아직 전부 처리되지 못했을 경우
            while (right <= ub) { // 남은 오른쪽 배열을 순회하며
                tmp[index] = array[right]; // 임시 배열에 저장
                right++;
                index++;
            }
        }

        for (int i = lb; i <= ub; i++) { // 임시 배열을 기존 배열로 복사
            array[i] = tmp[i];
        }
    }

}