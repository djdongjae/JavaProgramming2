package bakhayoon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("lab4_1:백하윤");

// 세가지 배열 초기화
        int[] array1 = {20, 10};
        int[] array2 = {1, 3, 5, 7, 9};
        int[] array3 = {-2, 1, 3, 3, 6, 8, 9, -2, -1, 0, 1, 3, 4, 5};

// 병합 수행
        merge(array1, 0, (array1.length-1)/2, array1.length-1);  // merge(array1, 0, 0, 1);
        merge(array2, 0, (array2.length-1)/2, array2.length-1);  // merge(array2, 0, 2, 4);
        merge(array3, 0, (array3.length-1)/2, array3.length-1);  // merge(array3, 0, 6, 13);

// 병합 결과 세가지 배열 출력
        for (int num : array1) {
            System.out.print(num + " ");
        }

        System.out.println();

        for (int num : array2) {
            System.out.print(num + " ");
        }

        System.out.println();

        for (int num : array3) {
            System.out.print(num + " ");
        }

    }

    // 정렬된 두 부분 배열 array[lb...m], array[m+1...ub]를 병합하여 정렬된 배열 array[lb...ub]를 얻음
    public static void merge(int[] array, int lb, int m, int ub) {
        // 1. 임시 배열 생성
        int[] tmp = new int[ub - lb + 1];
        int left = lb, right = m + 1, i = 0;

        // 2. 앞부분 대표값과 뒷부분 대표값을 비교하여 작은 값을 임시 배열에 복사
        while(left <= m && right <= ub) {
            if(array[left] <= array[right]) { // 작은 값을 먼저 넣어줌
                tmp[i] = array[left];
                left++;
            } else {
                tmp[i] = array[right];
                right++;
            }
            i++;
        }

        // 3. 앞부분에 남은 원소가 있으면 임시 배열에 복사
        while (left <= m) {
            tmp[i] = array[left];
            left++;
            i++;
        }

        // 4. 뒷부분에 남은 원소가 있으면 임시 배열에 복사
        while (right <= ub) {
            tmp[i] = array[right];
            right++;
            i++;
        }

        // 5. 임시배열 원소를 array에 복사
        for (int j = 0; j < tmp.length; j++) {
            array[lb + j] = tmp[j];
        }
    }
}