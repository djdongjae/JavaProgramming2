package ch12.prob13;
/*
 * chap12 구현문제 332p 치킨 배달
 * */
import java.util.*;

// 위치 정보 클래스
class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] map = new int[50][50]; // map 정보
    public static ArrayList<Position> chicken = new ArrayList<>();
    public static ArrayList<Position> house = new ArrayList<>();

    public static ArrayList<ArrayList<Position>> chickenList = new ArrayList<>();

    public static void comb(ArrayList<Position> arr, boolean[] visited, int depth, int r) {
        // 다 뽑았을 경우
        if (r == 0) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) temp.add(arr.get(i));
            }
            chickenList.add(temp);
            return;
        }
        // 배열 끝까지 확인했을 경우
        if (depth == arr.size()) return;
        else {
            visited[depth] = true;
            comb(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb(arr, visited, depth + 1, r);
        }
    }

    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getX();
            int hy = house.get(i).getY();
            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] == 2) chicken.add(new Position(r, c));
                else if (map[r][c] == 1) house.add(new Position(r, c));
            }
        }

        boolean[] visited = new boolean[chicken.size()];
        comb(chicken, visited, 0, m);

        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }
}
