package ch04.sec01.exam02;

import java.util.Scanner;

// ch04 구현 113p 시각
public class Main {

    public static Boolean check(int i, int j, int k) {
        String iString = Integer.toString(i);
        String jString = Integer.toString(j);
        String kString = Integer.toString(k);

        if (iString.contains("3") || jString.contains("3") || kString.contains("3")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <=59; k++) {
                    if( check(i, j, k) ) count++;
                    }
                }
            }

        System.out.println(count);
    }
}
