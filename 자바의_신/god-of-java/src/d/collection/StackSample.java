package d.collection;

import java.util.Stack;

public class StackSample {
    public static void main(String[] args) {
//        checkPeek();
        checkPop();
    }

    public static void checkPeek() {
        Stack<Integer> intStack = new Stack<>();
        for (int loop = 0; loop < 5; loop++) {
            intStack.push(loop);
            System.out.println(intStack.peek());
        }
        System.out.println("size=" + intStack.size());
    }

    public static void checkPop() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack.pop());
        }
        System.out.println("size = " + stack.size());
    }
}
