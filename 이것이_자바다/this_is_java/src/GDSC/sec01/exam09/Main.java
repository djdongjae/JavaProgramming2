package GDSC.sec01.exam09;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 12;
        try {
            System.out.println(b / a);
        } catch (Exception e) {
            System.out.println("예외 발생");
        }
        finally {
            System.out.println("난 반드시 실행돼");
        }
    }
}
