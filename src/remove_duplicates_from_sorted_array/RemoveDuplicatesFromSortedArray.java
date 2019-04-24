package remove_duplicates_from_sorted_array;

import java.util.Arrays;

class Solution1 {
    public static int removeDuplicates(int[] nums) {
    	if (null==nums||0==nums.length) {
			return 0;
		}
    	int newLength=0;
    	int i=0;
        for (i = 0; i < nums.length-1; i++) {
			if (nums[i]!=nums[i+1]) {
				nums[newLength]=nums[i];
				++newLength;
			}
			else {
				
			}
		}

        nums[newLength]=nums[i];
        ++newLength;
        return newLength;
    }
}
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4,5};
		int newLength=Solution1.removeDuplicates(nums);
		System.out.println(newLength);
		int[] nums1=new int [newLength];
		for (int i = 0; i < newLength; i++) {
			nums1[i]=nums[i];
		}
		System.out.println(Arrays.toString(nums1));
	}
	
	
}
