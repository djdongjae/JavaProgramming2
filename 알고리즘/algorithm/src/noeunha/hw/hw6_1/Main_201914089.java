package noeunha.hw.hw6_1;

import java.util.Scanner;

public class Main_201914089 {

    public static void main(String[] args) {

        System.out.println("noeunha.hw.hw6_1:오동재");
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
        //(4) 삭제할 키 값 x, y, z를 입력받음
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        //(5) tree에서 키값 x, y, z를 삭제(키값이 없으면 삭제하지 않으면 됨)
        tree.remove(x);
        tree.remove(y);
        tree.remove(z);
        //(6) tree를 중순위 순회하여 키값을 출력
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
        MyBinarySearchTree.Node left;
        MyBinarySearchTree.Node right;

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

    private class SearchResult {
        Node node;  // 찾은 노드
        Node parent;  // 찾은 노드의 부모

        SearchResult(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    // 주어진 키를 가진 노드와 그 부모를 찾는 메소드
    private SearchResult findWithParent(int key) {
        return searchWithParent(root, null, key);
    }

    // 재귀적으로 트리를 검색하면서 부모 노드를 함께 추적하는 보조 메소드
    private SearchResult searchWithParent(Node current, Node parent, int key) {
        if (current == null) {
            // 노드가 없으면 결과가 없음
            return new SearchResult(null, null);
        }
        if (key == current.key) {
            // 키를 찾았으면 현재 노드와 부모 노드 반환
            return new SearchResult(current, parent);
        } else if (key < current.key) {
            // 키가 현재 노드의 키보다 작으면 왼쪽 자식으로 이동
            return searchWithParent(current.left, current, key);
        } else {
            // 키가 현재 노드의 키보다 크면 오른쪽 자식으로 이동
            return searchWithParent(current.right, current, key);
        }
    }

    // 삭제 알고리즘
    public void remove(int key) {
        SearchResult searchResult = findWithParent(key); // 부모 포함 추적
        if (searchResult.node != null) treeDelete(searchResult.node, searchResult.parent); // 해당 노드가 있으면 삭제
    }

    private void treeDelete(Node r, Node p) {
        if (r == root) root = deleteNode(r); // 해당 노드가 루트이면
        else if (r == p.left) p.left = deleteNode(r); // 해당 노드가 부모의 왼쪽 자식
        else p.right = deleteNode(r); // 해당 노드가 부모의 오른쪽 자식
    }

    private Node deleteNode(Node r) {
        if (r.left == null && r.right == null) return null; // r이 리프노드인 경우
        else if (r.left == null && r.right != null) return r.right; // r의 자식이 오른쪽 하나인 경우
        else if (r.left != null && r.right == null) return r.left; // r의 자식이 왼쪽 하나인 경우
        else { // r의 자식 노드가 두 개인 경우
            Node s = r.right;
            Node p = null;
            while (s.left != null) { // r의 오른쪽 서브트리에서 가장 최솟값을 찾음
                p = s;
                s = s.left;
            }
            r.key = s.key; // 해당 값을 r자리에 복사 후 삭제
            if (s == r.right) r.right = s.right;
            else p.left = s.right;
            return r;
        }
    }
}