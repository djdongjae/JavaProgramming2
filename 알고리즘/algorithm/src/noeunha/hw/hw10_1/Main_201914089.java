package noeunha.hw.hw10_1;

import java.util.Scanner;

public class Main_201914089 {
    public static void main(String[] args) {
        System.out.println("hw10_1:오동재");
        Scanner input = new Scanner(System.in);

        // (1) 정점 수를 입력받아 weighted directed graph를 생성
        int numVertices = input.nextInt();
        MyGraph graph = new MyGraph(numVertices);

        // (2) 간선 수와 간선(v1, v2, weight)을 입력받아 그래프에 삽입
        int numEdges = input.nextInt();
        for (int i = 0; i < numEdges; i++) {
            graph.insertEdge(input.nextInt(), input.nextInt(), input.nextDouble());
        }

        // (3) 그래프를 위상 정렬하여 결과를 출력
        System.out.print("위상 정렬 결과: ");
        int[] result = graph.topologicalSort();
        // 위상 정렬 결과 출력
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
        System.out.println();
        System.out.print("최단 경로 길이: ");
        graph.dagShortestPath();
        input.close();
    }
}

class MyGraph {
    private int n; // 정점 수
    private Node[] list; // 인접 리스트

    // 단순연결리스트 노드 구조
    private static class Node {
        int vertex; // 정점
        double weight; // 가중치
        Node link; // 다음 노드 주소

        public Node(int vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
            this.link = null;
        }
    }

    // 정점 수가 n이고, 간선은 없는 그래프를 생성
    public MyGraph(int n) {
        this.n = n;
        this.list = new Node[n]; // 노드 개수만큼의 길이를 가지는 배열 생성
    }

    private boolean[] visited;

    public void dagShortestPath() {
        double[] distance = new double[n]; // 시작 정점으로부터의 거리
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = 987654321; // 무한대로 초기화
            prev[i] = -1; // 이전 정점 정보
        }
        distance[0] = 0;
        int[] tsResult = topologicalSort(); // 정점들을 위상정렬
        for (int v : tsResult) { // 위상정렬 순서대로
            for (Node temp = list[v]; temp != null; temp = temp.link) { // 인접 정점의 집합을 순회하며
                if (distance[temp.vertex] > distance[v] + temp.weight) {
                    distance[temp.vertex] = distance[v] + temp.weight; // 거리를 갱신
                    prev[temp.vertex] = v;
                }
            }
        }

        // 최단 경로 출력
        for (double d : distance) {
            if (d == 987654321) {
                System.out.print("Infinity ");
            } else {
                System.out.print(d + " ");
            }
        }
    }


    public int[] topologicalSort() {
        visited = new boolean[n]; // 방문한 노드인지 기록하기 위한 배열
        int[] result = new int[n]; // 위상 정렬의 결과를 저장할 배열
        int index = n - 1; // 시작 정점을 앞에 두기 위해 뒤에서부터 결과를 저장

        for (int i = 0; i < n; i++) { // 정점을 입력 받은 순서대로 순회하며
            if (!visited[i]) { // 방문한 정점이 아닐 경우
                index = dfsTS(i, result, index); // 해당 정점에 대해 dfsTS를 수행한 후 갱신된 인덱스 값 반환
            }
        }

        return result;
    }

    private int dfsTS(int v, int[] result, int index) {
        visited[v] = true; // 해당 정점 방문 처리
        for (Node temp = list[v]; temp != null; temp = temp.link) { // 연결된 정점들을 순회하며
            int x = temp.vertex;
            if (!visited[x]) { // 해당 정점이 방문한 정점이 아닐 경우
                index = dfsTS(x, result, index); // 재귀적으로 또 순회하며
            }
        }
        // 리스트 맨 앞에 삽입
        result[index] = v; // 끝자락에 도달했을 때 값을 뒤에서부터 저장하고
        index = index -1; // index를 한 칸 줄이고
        return index; // 새로운 index 반환
    }

    // 그래프에 간선 <v1, v2>를 삽입
    public void insertEdge(int v1, int v2, double weight) {
        Node newNode = new Node(v2, weight);
        newNode.link = list[v1];
        list[v1] = newNode;
    }
}
