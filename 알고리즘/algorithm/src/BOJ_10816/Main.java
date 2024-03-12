package BOJ_10816;

public class Main {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) result += 1;

        }
    }

}
