package coordinate.find_southeast_boundary;

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
