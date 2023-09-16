package lab4_1;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("lab4_1:오동재");

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
        int left = lb; //
        int right = m + 1;
        int index = left;

        while (left <= m && right <=ub) {
            if (array[left] < array[right]) {
                tmp[index] = array[left];
                left++;
            } else {
                tmp[index] = array[right];
                right++;
            }
            index++;
        }

        if (left <= m && right > ub) {
            while (left <= m) {
                tmp[index] = array[left];
                left++;
                index++;
            }
        } else if(left > m && right <= ub) {
            while (right <= ub) {
                tmp[index] = array[right];
                right++;
                index++;
            }
        }

        for (int i = lb; i <= ub; i++) {
            array[i] = tmp[i];
        }
    }

}
