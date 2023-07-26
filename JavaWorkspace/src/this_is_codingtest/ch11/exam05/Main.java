package this_is_codingtest.ch11.exam05;

import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    private static int[] array = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            array[x] += 1;
        }

        int result = 0;

        for (int i = 1; i < m + 1; i++) {
            n -= array[i];
            result += array[i] * n;
        }

        System.out.println(result);
    }
}
