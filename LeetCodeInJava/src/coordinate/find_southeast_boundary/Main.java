package coordinate.find_southeast_boundary;

/*
 * 给定平面直角坐标系上的点集合，寻找处于西南方向边界线上的点的子集合。
 * 西南方向边界线的定义是：不在该边界线上的点，横纵坐标不会同时小于等于在该边界线上的点
 */
public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated constructor stub
        int[][] points = { { 6, 5 }, { 3, 7 }, { 5, 4 }, { 4, 8 }, { 4, 3 }, { 3, 8 }, { 7, 3 } };
        Solution solution = new Solution();
        int[][] results = solution.southEastPoints(points);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + "," + results[i][1]);
        }
    }
}
