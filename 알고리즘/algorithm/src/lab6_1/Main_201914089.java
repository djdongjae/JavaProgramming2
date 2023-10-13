package lab6_1;

import java.util.Scanner;



public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("lab6_1:오동재");
        // (1) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
        MyBinarySearchTree tree = new MyBinarySearchTree();
        // (2) 사용자가 원하는 갯수의 정수 키값을 입력받아 tree에 삽입한 후, tree 출력
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            tree.add(input.nextInt());
        }

        // (3) tree를 중순위 순회하여 키값을 출력
        tree.inorder();
    }
}



// 정수 키값을 갖는 이진검색트리를 구현하는 클래스

class MyBinarySearchTree {

    // 루트 노드를 가리키는 인스턴스 변수 - 알고리즘 연습을 위해 root 만 둘 것
    private Node root = null;

    // 노드의 구조를 정의하는 클래스 - key, left, right 필드를 지님
    private class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

    }

    // 트리를 중순위 순회
    public void inorder() {
        System.out.print("트리 = ");
        inorder(root);
        System.out.println();
    }



// t를 루트로 하는 트리를 중순위 순회하여 키값을 출력
    private void inorder(Node t) {
        if(t != null) {
            inorder(t.left);
            System.out.print(t.key + " ");
            inorder(t.right);
        }
    }

// 매개변수로 받은 키값을 트리에 삽입
    public void add(int key) {
        root = treeInsert(root, key);
    }



// t를 루트로 하는 트리에 key를 삽입하고, 삽입 후 루트 노드를 리턴하는 재귀 메소드

    private Node treeInsert(Node t, int key) {
        if(t == null) {
            // 새로운 노드를 할당받아 키 값을 저장하고 그 노드를 리턴
            Node newNode = new Node(key);
            return newNode;
        }
        else if(key < t.key) {
            // t의 왼쪽 자식을 루트로 하는 트리에 key 값을 삽입하고(treeInsert 재귀 호출), 그 결과를 t의 왼쪽 자식으로 저장
            t.left = treeInsert(t.left, key);
            // 루트 노드 t는 변경되지 않았으므로 t를 그대로 리턴
            return t;
        }
        else if(key > t.key) {
            // t의 오른쪽 자식을 루트로 하는 트리에 key 값을 삽입하고(treeInsert 재귀 호출), 그 결과를 t의 오른쪽 자식으로 저장
            t.right = treeInsert(t.right, key);
            // 루트 노드 t는 변경되지 않았으므로 t를 그대로 리턴
            return t;
        }
        else {
            // 이미 존재하는 키값인 경우 삽입하지 않음. 즉, 아무 작업도 하지 않고 t를 그대로 리턴
            return t;
        }
    }
}