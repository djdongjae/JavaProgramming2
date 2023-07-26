package this_is_codingtest.ch11.exam04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int n;
    private static List<Integer> arraylist = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arraylist.add(sc.nextInt());
        }

        Collections.sort(arraylist);

        int target = 1;
        for (int i = 0; i < n; i++) {
            if (target < arraylist.get(i)) break;
            target += arraylist.get(i);
        }

        System.out.println(target);
    }
}
