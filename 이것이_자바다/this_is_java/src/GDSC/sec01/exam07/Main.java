package GDSC.sec01.exam07;

public class Main {
    public static void main(String[] args) {

    }
}

abstract class Unit {
    abstract void move(int a, int b);

    void power() {};
}

class Tank extends Unit {
    @Override
    void move(int a, int b) {
        System.out.println(a + b);
    }

    void attack() {};
}
