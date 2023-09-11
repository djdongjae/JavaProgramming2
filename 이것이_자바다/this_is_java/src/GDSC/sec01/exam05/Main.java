package GDSC.sec01.exam05;

public class Main {
    public static void main(String[] args) {
        tansan a = new tansan();
        a.name = "콜라";
        a.price = 1500;
        a.showPrice();
    }
}

class tansan {
    String name;
    int price;

    public tansan() {

    }

    public void showPrice() {
        System.out.println(name + "의 가격은 " + price + "원 입니당.");
    }
}
