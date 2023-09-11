package GDSC.sec01.exam06;

public class Drink {
    void coke() {};
    void soda() {};
}

class Tansan extends Drink {
    @Override
    void coke() {
        System.out.println("안녕");
    }

    int coke(int a) {
        return a;
    }

    void soda() {
    }

    void fanta() {

    }

    void fanta(char a, char b) {

    }
}
