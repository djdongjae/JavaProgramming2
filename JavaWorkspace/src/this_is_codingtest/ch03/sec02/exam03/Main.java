package this_is_codingtest.ch03.sec02.exam03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

//        while (n != 1) {
//            if (n % k == 0) n /= k;
//            else n -= 1;
//            count++;
//        }
//
//        System.out.println(count);

        while (n != 0) {
            int target = (n / k) * k;
            count += n - target;
            n = target;
            count += 1;
            n /= k;
        }

        System.out.println(count-2);
    }
}
