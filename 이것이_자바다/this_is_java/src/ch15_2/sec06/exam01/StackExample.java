package ch15_2.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // stack 자료구조 사용
        Stack<Coin> coinBox = new Stack<>();

        // Stack 자료구조의 push 메소드
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        // stack이 빌 때까지 위에서 하나씩 꺼내기
        while (!coinBox.isEmpty()) {
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
        }
    }
}
