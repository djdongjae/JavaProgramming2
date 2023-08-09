package this_is_java.ch12.sec07;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        int[] selectNumber = new int[6];
        Random random = new Random(5);
        System.out.print("선택번호: ");
        for (int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.print("당첨번호: ");
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);

        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.print("당첨여부: ");
        if (result) {
            System.out.println("1등에 당첨되셨습니다."); // 1등 당첨
        } else {
            System.out.println("당첨되지 않았습니다."); // 당첨여부:
        }
    }
}
