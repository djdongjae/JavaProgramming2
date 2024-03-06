package noeunha.lab.lab10_1;

import java.util.Scanner;

public class Main_201914089 {

    public static void main(String[] args) {
        System.out.println("noeunha.lab.lab10_1:오동재");
        Scanner input = new Scanner(System.in);

// (1) 정점 수를 입력받아 방향 그래프
        int numVertices = input.nextInt();
        MyGraph graph = new MyGraph(numVertices);

// (2) 간선 수와 간선(정점 쌍)을 입력받아 방향 그래프에 삽입
        int numEdges = input.nextInt();
        for(int i = 0; i < numEdges; i++) {
            graph.insertEdge(input.nextInt(), input.nextInt());
        }

// (3) 정점을 입력받아 out-degree를 출력
        int vertex = input.nextInt();
        System.out.println(vertex + "의 out-degree = " + graph.outDegree(vertex));

// (4) 그래프 구현을 확인하기 위해 인접 정점 정보를 출력
        graph.printAdjVertices();
        input.close();
    }
}

// 인접 리스트로 방향 그래프를 구현하는 클래스
class MyGraph {
    private int n;// 정점 수
    private Node[] list;// 인접 리스트

// 단순연결리스트 노드 구조
    private class Node {
        int vertex;
        Node link;
        public Node(int vertex) {
            this.vertex = vertex;
            this.link = null;
        }
    }

// 정점 수가 n이고, 간선은 없는 그래프를 생성
    public MyGraph(int n) {
        this.n = n;
        this.list = new Node[n];
    }

// 그래프에 간선 <v1, v2>를 삽입
    public void insertEdge(int v1, int v2) {
        Node newNode = new Node(v2);
        newNode.link = list[v1];
        list[v1] = newNode;
    }
// 정점 vertex의 out-degree를 리턴
    public int outDegree(int vertex) {
        int outDegree = 0;
        Node temp = list[vertex];
        while (temp != null) {
            outDegree++;
            temp = temp.link;
        }
        return outDegree;
    }

// 그래프 구현을 확인하기 위해 인접 정점 정보를 출력
    public void printAdjVertices() {
        for(int i = 0; i < n; i++) {
            System.out.print(i + " : ");
            Node temp = list[i];
            while(temp != null) {
                System.out.print(temp.vertex + " ");
                temp = temp.link;
            }
            System.out.println();
        }
    }
}
