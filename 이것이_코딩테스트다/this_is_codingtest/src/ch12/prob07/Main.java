package ch12.prob07;

import java.util.Scanner;

// chap12 구현문제 321p 럭키 스트레이트
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.next();
        int length = score.length() / 2;
        String left = score.substring(0, length);
        String right = score.substring(length);

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < left.length(); i++) {
            int num = left.charAt(i) - '0';
            leftSum += num;
        }

        for (int i = 0; i < right.length(); i++) {
            int num = right.charAt(i) - '0';
            rightSum += num;
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
