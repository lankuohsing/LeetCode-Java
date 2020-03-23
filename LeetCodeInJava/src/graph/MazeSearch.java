package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int x;
    int y;
    int pre;// 来到此点的出发点

    public Node(int x, int y, int pre) {
        this.x = x;
        this.y = y;
        this.pre = pre;
    }
}

public class MazeSearch {
    public static int width = 5;
    public static int height = 5;

    public static void printQueuq(List<Node> queue, Node node) {
        if (node.pre == -1) {
            System.out.println("(" + node.x + "," + node.y + ")");
            return;
        } else {
            printQueuq(queue, queue.get(node.pre));
            System.out.println("(" + node.x + "," + node.y + ")");
        }

    }

    public static void main(String args[]) {
        int[][] map = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 } };
        int[][] book = new int[height][width];
        int head = 0;
        int tail = 0;
        List<Node> queue = new ArrayList<Node>(Arrays.asList(new Node[width * height]));
        queue.add(tail, new Node(0, 0, -1));
        book[0][0] = 1;
        tail++;
        while (head < tail) {
            int[][] next = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };// 定义出四个方向
            int flag = 0;
            for (int i = 0; i < 4; i++) {
                // 实现移动
                int nextX = queue.get(head).x + next[i][0];
                int nextY = queue.get(head).y + next[i][1];
                if (nextX < 0 || nextX > width - 1 || nextY < 0 || nextY > height - 1) {
                    continue;
                }
                if (book[nextX][nextY] == 0 && map[nextX][nextY] == 0) {// 当该点未被访问过且是可行点才入队列
                    book[nextX][nextY] = 1;
                    queue.set(tail, new Node(nextX, nextY, head));
                    tail++;
                }
                if (nextX == width - 1 && nextY == height - 1) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                printQueuq(queue, queue.get(tail - 1));
                break;
            }
            head++;

        }

    }
}
