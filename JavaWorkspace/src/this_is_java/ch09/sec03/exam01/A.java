package this_is_java.ch09.sec03.exam01;

public class A {

    static class B {};

    B field1 = new B();

    static B field2 = new B();

    A() {
        B b = new B();
    }

    void method1() {
        B b = new B();
    }

    void method2() {
        B b = new B();
    }

}
