package ch12.prob08;

import java.util.*;

// chap12 구현문제 322p 문자열 재정렬
public class Main {
    public static String str;
    public static ArrayList<Character> result = new ArrayList<>();
    public static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();
        sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            } else {
                int num = str.charAt(i) - '0';
                sum += num;
            }
        }

        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }

        if (sum != 0) System.out.print(sum);

    }

}
