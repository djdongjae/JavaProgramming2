package ch12.prob11;

import java.util.*;

// chap12 구현문제 328p 뱀
class Node {
    private int time;
    private String direction;

    public Node(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public String getDirection() {
        return this.direction;
    }
}

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
    public static int n, k, l;
    public static int[][] map = new int[101][101];
    public static ArrayList<Node> rotateInfo = new ArrayList<>();

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static int turn(String c, int direction) {
        int newDirection;
        if (c.equals("L")) {
            newDirection = (direction + 1) % 4;
        } else {
            newDirection = ((direction) == 0) ? 3 : direction - 1;
        }
        return newDirection;
    }

    public static int simulate() {
        int x = 1, y = 1;
        map[x][y] = 2;
        int direction = 0;
        int time = 0;
        int index = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && map[nx][ny] != 2) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    queue.offer(new Position(nx, ny));
                    Position prev = queue.poll();
                    map[prev.getX()][prev.getY()] = 0;
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 2;
                    queue.offer(new Position(nx, ny));
                }
            } else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            if (index < l && rotateInfo.get(index).getTime() == time) {
                direction = turn(rotateInfo.get(index).getDirection(), direction);
                index += 1;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }

        l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            String c = sc.next();
            rotateInfo.add(new Node(x, c));
        }

        int result = simulate();
        System.out.println(result);
    }
}
