package this_is_codingtest.ch03.sec01.exam01;

public class Main {

    public static void main(String[] args) {
        int n = 1260;
        int count = 0;
        int[] coins = {500, 100, 50, 10};

        for (int i = 0; i < coins.length; i++) {
            count += n / coins[i];
            n %= coins[i];
        }

        System.out.println(count);
    }

}
