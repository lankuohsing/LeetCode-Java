package coordinate.find_southeast_boundary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    private final int maxNum = 1000000000;

    public int[][] southEastPoints(int[][] points) {
        List<int[]> pointsList = new ArrayList<int[]>();
        for (int i = 0; i < points.length; i++) {
            pointsList.add(points[i]);
        }
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        Map<Integer, List<int[]>> xtoPoints = new HashMap<Integer, List<int[]>>();
        Map<Integer, List<int[]>> ytoPoints = new HashMap<Integer, List<int[]>>();
        List<int[]> listVerticalMinY = new ArrayList<>();
        List<int[]> listHorizonMinX = new ArrayList<>();
        for (int[] point : pointsList) {
            setX.add(point[0]);
            setY.add(point[1]);
        }
        for (Integer xnum : setX) {
            xtoPoints.put(xnum, new ArrayList<>());
        }
        for (Integer ynum : setY) {
            ytoPoints.put(ynum, new ArrayList<>());
        }
        for (int[] point : pointsList) {
            xtoPoints.get(point[0]).add(point);
            ytoPoints.get(point[1]).add(point);
        }
        Map<Integer, int[]> mapVerticalMinY = new HashMap<>();
        Map<Integer, int[]> mapHorizonMinX = new HashMap<>();
        for (Map.Entry<Integer, List<int[]>> entry : xtoPoints.entrySet()) {
            int[] tempPoint = { entry.getKey(), maxNum };
            for (int[] point : entry.getValue()) {
                if (point[1] < tempPoint[1]) {
                    tempPoint = point;
                }
            }
            listVerticalMinY.add(tempPoint);
            mapVerticalMinY.put(tempPoint[0], tempPoint);
        }
        for (Map.Entry<Integer, List<int[]>> entry : ytoPoints.entrySet()) {
            int[] tempPoint = { maxNum, entry.getKey() };
            for (int[] point : entry.getValue()) {
                if (point[0] < tempPoint[0]) {
                    tempPoint = point;
                }
            }
            listHorizonMinX.add(tempPoint);
            mapHorizonMinX.put(tempPoint[1], tempPoint);
        }
        List<int[]> listIntersection = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : mapVerticalMinY.entrySet()) {
            if (!mapHorizonMinX.keySet().contains(entry.getValue()[1])) {
                continue;
            }
            if (entry.getValue()[0] == mapHorizonMinX.get(entry.getValue()[1])[0]) {
                listIntersection.add(entry.getValue());
            }
        }
        List<int[]> listResults = new ArrayList<>();
        listResults.add(listIntersection.get(0));
        int index = 0;
        for (int i = 1; i < listIntersection.size(); i++) {
            if (listIntersection.get(i)[1] < listResults.get(index)[1]) {
                listResults.add(listIntersection.get(i));
                index++;
            }
        }
        int[][] results = new int[listResults.size()][2];
        for (int i = 0; i < listResults.size(); i++) {
            results[i] = listResults.get(i);
        }
        return results;
    }
}
