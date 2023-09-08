package lab0_2;

public class Main_201914089 {
    public static void main(String[] args) {
        System.out.println("lab0_2:오동재");
        System.out.println(factorial(5));
        System.out.println(sum(5));
        show(5);
    }

    private static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    private static int sum(int n) {
        if (n == 1) return 1;
        else return n + sum(n - 1);
    }

    private static void show(int n) {
        if (n == 1) System.out.print(1 + " ");
        else {
            show(n - 1);
            System.out.print(n + " ");
        }
    }
}
