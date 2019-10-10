package array.num_of_interval_subarray;

import java.util.ArrayList;

class Solution1 {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        ArrayList<Integer> lengthSubArray1 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> lengthSubArray3 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> lengthSubArray2 = new ArrayList<Integer>();

        Boolean flag1 = false;
        Boolean flag2 = true;
        int length1 = 0;
        int length2 = 0;
        for (int i = 0; i < A.length; i++) {

            if (!flag1) {
                lengthSubArray2 = new ArrayList<Integer>();
            }
            if (A[i] < L) {
                length1++;
                length2++;
                flag2 = false;
                continue;
            }
            if (L <= A[i] && A[i] <= R) {
                length1++;
                flag1 = true;
                lengthSubArray2.add(length2);
                length2 = 0;
//                lengthSubArray3.add(lengthSubArray2);


                flag2 = true;
                continue;
            }
            if (A[i] > R) {
                if (flag1) {
                    lengthSubArray1.add(length1);


                    lengthSubArray2.add(length2);
                    lengthSubArray3.add(lengthSubArray2);

                }
                length1 = 0;
                length2 = 0;
                flag1 = false;
                flag2 = true;
            }
        }
        lengthSubArray1.add(length1);
        lengthSubArray2 = new ArrayList<Integer>();
        lengthSubArray2.add(length2);
        lengthSubArray3.add(lengthSubArray2);
        int result = 0;
        for (int i = 0; i < lengthSubArray1.size(); i++) {
            int n1 = lengthSubArray1.get(i);
            int result1 = n1*(n1+1)/2;
            int result2 = 0;
            for (int j = 0; j < lengthSubArray3.get(i).size(); j++) {
                int n2 = lengthSubArray3.get(i).get(j);
                result2+= n2*(n2+1)/2;
            }
            result+= result1 - result2;
        }
        return result;
    }
}
public class NumOfIntervalSubArray {

    public static void main(String[] args) {
        int[] nums = {45,2,49,6,55,73,27,17,4,71};
        int L = 17;
        int R = 33;
        int result = Solution1.numSubarrayBoundedMax(nums, L, R);
        System.out.println(result);
        }
}
