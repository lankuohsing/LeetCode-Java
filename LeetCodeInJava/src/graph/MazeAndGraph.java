package graph;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MazeAndGraph {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int length = cin.nextInt();
        int timeLimit = cin.nextInt();
        int[][] officeLayout = new int[length][];
        for (int i = 0; i < officeLayout.length; i++) {
            officeLayout[i] = new int[length];
            for (int j = 0; j < officeLayout.length; j++) {
                officeLayout[i][j] = cin.nextInt();
            }
        }
        cin.close();
        System.out.print(new MazeAndGraph().getNumOfLightsOff(officeLayout, timeLimit));

    }

    class Graph {
        private int[] vertices;// 顶点信息，前两个分别是七点和终点
        private int[][] adjMatrices;// 邻接矩阵
        private int vexNum;// 顶点数量
        private boolean[] visited;// 记录顶点是否被访问过
        private int maxLength;// 最大长度
        private int maxNodesNum;// 有效路径的最大可能结点数，用于后续剪枝，不包括起点和终点
        private int curNodesNum;// 当前路径的结点数，用于与maxNodesNum一起完成剪枝，不包含起点和终点
        private boolean curNodesNumIsMax;// 是否要提前停止（剪枝）

        // 初始化图
        public Graph(int n, int maxLength) {
            this.maxLength = maxLength;
            this.vexNum = n;
            vertices = new int[vexNum];
            adjMatrices = new int[vexNum][vexNum];
            visited = new boolean[n];
            for (int i = 0; i < vexNum; i++) {
                for (int j = 0; j < vexNum; j++) {
                    adjMatrices[i][j] = 0;
                }
            }

        }

        // 添加边
        public void addEdge(int i, int j, int weight) {
            if (i == j) {
                return;
            }
            // 无向图对称的
            adjMatrices[i][j] = weight;
            adjMatrices[j][i] = weight;
        }
    }

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

    void setLightPoints(List<Integer[]> lightPoints, int index, int i, int j) {
        lightPoints.get(index)[0] = i;
        lightPoints.get(index)[1] = j;
    }

    void getPoints(List<Integer[]> lightPoints, int[][] officeLayout) {
        for (int i = 0; i < officeLayout.length; i++) {
            for (int j = 0; j < officeLayout[i].length; j++) {
                switch (officeLayout[i][j]) {
                case 3:
                    setLightPoints(lightPoints, 0, i, j);
                    break;
                case 4:
                    setLightPoints(lightPoints, 1, i, j);
                    break;
                case 2:
                    lightPoints.add(new Integer[2]);
                    setLightPoints(lightPoints, lightPoints.size() - 1, i, j);
                    break;

                default:
                    break;
                }
            }
        }
    }

    void printQueue(List<Node> queue, Node node, List<Integer> shortestPathLength) {
        if (node.pre == -1) {
            shortestPathLength.set(0, shortestPathLength.get(0) + 1);
            return;
        } else {
            printQueue(queue, queue.get(node.pre), shortestPathLength);
            shortestPathLength.set(0, shortestPathLength.get(0) + 1);
        }
    }

    int getEdgeLength(int[][] officeLayout, List<Integer[]> lightPoints, int vertexIndex1, int vertexIndex2) {
        int height = officeLayout.length;
        int width = height;
        int[][] book = new int[height][width];
        int head = 0;
        int tail = 0;
        List<Node> queue = new ArrayList<Node>(Arrays.asList(new Node[width * height]));
        List<Integer> shortestPathLength = new ArrayList<>();
        shortestPathLength.add(0);
        Integer[] tempStartPoint = lightPoints.get(vertexIndex1);
        Integer[] tempEndPoint = lightPoints.get(vertexIndex2);
        queue.add(tail, new Node(tempStartPoint[0], tempStartPoint[1], -1));
        book[0][0] = 1;
        tail++;
        while (head < tail) {
            int[][] next = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };// 定义四个方向
            int flag = 0;
            // for循环结束后，对当前点的四个方向都搜索了一遍
            // 然后下次for循环依次对前面的四个点进行探索，依次实现了BFS
            // 并且在第一次到达终点时break，此时的路径一定为最小
            for (int i = 0; i < 4; i++) {
                // 实现移动
                int nextX = queue.get(head).x + next[i][0];
                int nextY = queue.get(head).y + next[i][1];
                if (nextX < 0 || nextX > width - 1 || nextY < 0 || nextY > height - 1) {
                    continue;
                }
                if (book[nextX][nextY] == 0 && officeLayout[nextX][nextY] != 1) {// 当该点未被访问过且 是可行点才入队列
                    book[nextX][nextY] = 1;
                    queue.set(tail, new Node(nextX, nextY, head));
                    tail++;
                }
                if (nextX == tempEndPoint[0] && nextY == tempEndPoint[1]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                printQueue(queue, queue.get(tail - 1), shortestPathLength);
                break;
            }
            head++;
        }
        return shortestPathLength.get(0) - 1;
    }

    void buildOneEdge(Graph graph, int[][] officeLayout, List<Integer[]> lightPoints, int vertexIndex1,
            int vertexIndex2) {
        graph.addEdge(vertexIndex1, vertexIndex2, getEdgeLength(officeLayout, lightPoints, vertexIndex1, vertexIndex2));
    }

    void buildGraph(Graph graph, int[][] officeLayout, List<Integer[]> lightPoints) {
        for (int vertexIndex1 = 0; vertexIndex1 < lightPoints.size() - 1; vertexIndex1++) {
            for (int vertexIndex2 = vertexIndex1 + 1; vertexIndex2 < lightPoints.size(); vertexIndex2++) {
                buildOneEdge(graph, officeLayout, lightPoints, vertexIndex1, vertexIndex2);
            }
        }
    }

    int calCurPathLength(Stack<Integer> lightInPath, Graph graph) {
        int tempLength = 0;
        int tempStart = 1;
        int tempEnd = -1;
        while (!lightInPath.isEmpty()) {
            tempEnd = lightInPath.pop();
            tempLength += graph.adjMatrices[tempStart][tempEnd];
            tempStart = tempEnd;

        }
        tempLength += graph.adjMatrices[tempStart][0];
        return tempLength;
    }

    void traverse(int lightIndex, Graph graph, int[] maxLightNum, Stack<Integer> lightInPath, int[] result) {
        // 标记第i个节点已遍历
        graph.visited[lightIndex] = true;
        // 遍历邻接矩阵中第i个节点的直接连通
        for (int j = 0; j < graph.vexNum; j++) {
            if (graph.visited[j] == true) {
                continue;
            }
            lightInPath.push(j);
            Stack<Integer> tempLightInPath = (Stack<Integer>) lightInPath.clone();
            int tempLength = calCurPathLength(tempLightInPath, graph);
            if (tempLength <= 0 || tempLength > graph.maxLength) {
                lightInPath.pop();
                continue;
            } else {
                maxLightNum[0] = tempLength;
                graph.curNodesNum += 1;
                result[0] = graph.curNodesNum > result[0] ? graph.curNodesNum : result[0];
                if (graph.curNodesNum >= graph.maxNodesNum) {// 剪枝
                    graph.curNodesNumIsMax = true;
                    break;
                }
                traverse(j, graph, maxLightNum, lightInPath, result);
                if (graph.curNodesNumIsMax) {
                    return;
                }
                graph.curNodesNum -= 1;
                graph.visited[j] = false;
                lightInPath.pop();
            }
        }
    }

    Graph initGraph(List<Integer[]> lightPoints, int timeLimit, int[][] officeLayout, List<Integer> validLightIndex) {
        Graph graph = new Graph(lightPoints.size(), timeLimit);
        buildGraph(graph, officeLayout, lightPoints);
        graph.visited[0] = true;
        graph.visited[1] = true;
        graph.maxNodesNum = 0;
        graph.curNodesNumIsMax = false;
        for (int i = 2; i < graph.visited.length; i++) {
            graph.visited[i] = true;
        }
        for (int i = 2; i < graph.vexNum; i++) {
            int tempLength = graph.adjMatrices[0][i] + graph.adjMatrices[i][1];
            if (tempLength > 0 && tempLength <= timeLimit) {
                validLightIndex.add(i);
                graph.visited[i] = false;
                graph.maxNodesNum += 1;
            }
        }
        return graph;
    }

    int findSolutionByDfs(List<Integer> validLightIndex, Graph graph, int timeLimit, int[] maxLightNum) {
        int[] result = new int[1];
        Stack<Integer> lightInPath = new Stack<Integer>();
        // 从没有别遍历的结点开始深度优先遍历
        for (int i = 0; i < validLightIndex.size(); i++) {
            int lightIndex = validLightIndex.get(i);
            // 如果没有被访问过
            if (graph.visited[lightIndex] == false) {
                int tempLength = graph.adjMatrices[0][lightIndex] + graph.adjMatrices[lightIndex][1];
                if (tempLength <= 0 || tempLength > timeLimit) {
                    continue;
                } else {
                    maxLightNum[0] = tempLength;
                    lightInPath.push(lightIndex);
                    graph.curNodesNum += 1;
                    result[0] = graph.curNodesNum > result[0] ? graph.curNodesNum : result[0];
                    if (graph.curNodesNum >= graph.maxNodesNum) {
                        graph.curNodesNumIsMax = true;
                        break;
                    }
                    traverse(lightIndex, graph, maxLightNum, lightInPath, result);
                    if (graph.curNodesNumIsMax) {
                        break;
                    } else {
                        lightInPath.pop();
                        graph.curNodesNum -= 1;
                        graph.visited[lightIndex] = false;
                    }
                }
            }

        }
        return result[0];
    }

    int getNumOfLightsOff(int[][] officeLayout, int timeLimit) {
        Integer[] startPoint = new Integer[2];// （横坐标，纵坐标）
        Integer[] endPoint = new Integer[2];
        List<Integer[]> lightPoints = new ArrayList<>();
        lightPoints.add(startPoint);
        lightPoints.add(endPoint);
        getPoints(lightPoints, officeLayout);
        int startToEndLength = getEdgeLength(officeLayout, lightPoints, 0, 1);
        if (startToEndLength <= 0 || startToEndLength > timeLimit) {
            return -1;
        } else {
            int[] maxLightNum = new int[1];
            maxLightNum[0] = startToEndLength;
            List<Integer> validLightIndex = new ArrayList<>();
            Graph graph = initGraph(lightPoints, timeLimit, officeLayout, validLightIndex);
            int result = findSolutionByDfs(validLightIndex, graph, timeLimit, maxLightNum);
            return result;
        }
    }

}
