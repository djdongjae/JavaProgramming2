package this_is_codingtest.ch11.exam03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                count += 1;
            }
        }

        int result = (count + 1) / 2;
        System.out.println(result);
    }
}