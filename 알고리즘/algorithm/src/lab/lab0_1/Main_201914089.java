package lab.lab0_1;

import java.util.*;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("lab.lab0_1:오동재");



// n개의 정수값을 입력받아 배열에 저장

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for(int i = 0; i < n; i++) {

            array[i] = scanner.nextInt();

        }



// n개의 정수값을 출력

        int total = 0;
        for(int i = 0; i < n; i++) {
            total += array[i];
        }
        double avg = (double)total / n;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (avg < array[i]) count++;
        }
        System.out.println(avg);
        System.out.println(count);

        scanner.close();

    }

}