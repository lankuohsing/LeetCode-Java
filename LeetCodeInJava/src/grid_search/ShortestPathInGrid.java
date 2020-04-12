package grid_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathInGrid {
    class Node {
        int x;
        int y;
        // 来到此点的出发点
        int pre;

        public Node(int x, int y, int pre) {
            this.x = x;
            this.y = y;
            this.pre = pre;
        }
    }

    public static int width = 5;
    public static int height = 5;

    public static void printQueuq(List<Node> queue, Node node, List<Integer[]> path) {
        if (node.pre == -1) {
//            System.out.println("(" + node.x + "," + node.y + ")");
            Integer[] tempPoint = { node.y, node.x };
            path.add(tempPoint);
            return;
        } else {
            printQueuq(queue, queue.get(node.pre), path);
//            System.out.println("(" + node.x + "," + node.y + ")");
            Integer[] tempPoint = { node.y, node.x };
            path.add(tempPoint);
        }

    }

    public static void main(String args[]) {
        // 行代表Y轴方向，列代表X轴方向
        int[][] map = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        // 起点和终点，第一个代表Y值，第二个代表X值，与map的格式对应
        int[] startPoint = { 0, 0 };
        int[] endPoint = { 0, 0 };
        List<Integer[]> path = new ArrayList<>();
        int shortLength = new ShortestPathInGrid().getShortestPath(map, startPoint, endPoint, path);
        System.out.println("Shortest Length: " + shortLength);
        System.out.println("One of the shortest path: ");
        for (Integer[] point : path) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }

    }

    public int getShortestPath(int[][] map, int[] startPoint, int[] endPoint, List<Integer[]> path) {
        if (startPoint[0] == endPoint[0] && startPoint[1] == endPoint[1]) {
            Integer[] tempPoint = { startPoint[0], startPoint[1] };
            path.add(tempPoint);
            return path.size() - 1;
        }
        // 记录每个点是否被访问过。如果已经被访问过则
        int[][] book = new int[height][width];
        // 队列头的位置
        int head = 0;
        // 队列尾
        int tail = 0;
        // 创建队列
        List<Node> queue = new ArrayList<Node>(Arrays.asList(new Node[width * height]));
        queue.add(tail, new Node(startPoint[1], startPoint[0], -1));
        book[startPoint[0]][startPoint[1]] = 1;
        tail++;
        while (head < tail) {
            int[][] next = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };// 定义出四个方向
            int flag = 0;
            for (int i = 0; i < 4; i++) {
                // 实现移动
                int nextX = queue.get(head).x + next[i][0];
                int nextY = queue.get(head).y + next[i][1];
                // 移动到了边界外部
                if (nextX < 0 || nextX > width - 1 || nextY < 0 || nextY > height - 1) {
                    continue;
                }
                // 当该点未被访问过且是可行点才入队列
                if (book[nextY][nextX] == 0 && map[nextY][nextX] == 0) {
                    book[nextY][nextX] = 1;
                    queue.set(tail, new Node(nextX, nextY, head));
                    tail++;
                }
                // 到达终点
                if (nextX == endPoint[1] && nextY == endPoint[0]) {
                    flag = 1;
                    break;
                }

            }
            // 到达终点
            if (flag == 1) {
                printQueuq(queue, queue.get(tail - 1), path);
                break;
            }
            head++;

        }
        if (path == null || path.size() == 0) {
            return -1;
        } else {
            return path.size() - 1;
        }
    }
}