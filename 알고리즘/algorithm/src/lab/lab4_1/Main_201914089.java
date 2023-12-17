package lab.lab4_1;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("lab.lab4_1:오동재");

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
        int[] tmp = new int[ub - lb + 1]; // 결과를 임시 저장할 tmp 배열 생성
        int left = lb; // 왼쪽 배열의 시작점
        int right = m + 1; // 오른쪽 배열의 시작점
        int index = left; // tmp 배열의 시작점

        while (left <= m && right <=ub) { // 왼쪽 배열과 오른쪽 배열의 인덱스가 범위를 벗어나지 않는 동안
            if (array[left] < array[right]) { // 왼쪽 값과 오른쪽 값을 비교하며
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
