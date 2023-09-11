package GDSC.sec01.exam04;

public class Main {
    public static void main(String[] args) {
        int[] score = {75, 80, 95, 90};
        int sum = 0;
        for (int a = 0; a < score.length; a++) {
            sum += score[a];
        }
        System.out.println(sum);
    }
}
