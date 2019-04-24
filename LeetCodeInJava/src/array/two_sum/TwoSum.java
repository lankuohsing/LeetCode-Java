package array.two_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }
}
class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer, ArrayList<Integer>>mapVauleIndex=new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
        	if (mapVauleIndex.containsKey(nums[i])) {
        		ArrayList<Integer> indexList=mapVauleIndex.get(nums[i]);
        		indexList.add(i);
        		mapVauleIndex.put(nums[i], indexList);
			}
        	else {
        		ArrayList<Integer> indexList=new ArrayList<>();
        		indexList.add(i);
        		mapVauleIndex.put(nums[i], indexList);
			}
        	
        	
        	
        }
        for (int i = 0; i < nums.length; i++) {
        	int temp=target-nums[i];
			if (mapVauleIndex.containsKey(temp)) {
				if (mapVauleIndex.get(temp).size()==1) {
					if (mapVauleIndex.get(temp).get(0)!=i) {
						result[0]=i;
						result[1]=mapVauleIndex.get(temp).get(0);
						return result;
					}
				}
				else {
					result[0]=i;
					result[1]=mapVauleIndex.get(temp).get(1);
					return result;
				}
				
			}
		}
        return result;
    }
}
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] results=Solution1.twoSum(nums, target);
		results=Solution2.twoSum(nums, target);
		System.out.println(Arrays.toString(results));
	}
}
