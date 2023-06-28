package this_is_codingtest.ch03.sec02.exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        Arrays.sort(array);
        System.out.println(BigSum(array, n, m, k));

    }

    static int BigSum(int[] array, int n, int m, int k) {
        int a = array[n-1];
        int b = array[n-2];

        if (m == 1) {
            return a;
        };

        if (a != b) {
            if (m % (k + 1) == 0) {
                return (a * k + b) * (m / (k + 1));
            } else {
                return (a * k + b) * (m / (k + 1)) + (m % (k + 1)) * a;
            }
        } else {
            return m * a;
        }
    }
}
