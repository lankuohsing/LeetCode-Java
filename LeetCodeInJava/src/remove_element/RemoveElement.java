package remove_element;

import java.util.Arrays;

class Solution1 {
    public static int removeElement(int[] nums, int val) {
        int newLength=0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=val) {
				nums[newLength]=nums[i];
				newLength++;
			}
		}
        return newLength;
    }
}
public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val=2;
		int newLength = Solution1.removeElement(nums, val);
		System.out.println(newLength);
		int[] nums1=new int[newLength];
		for (int i = 0; i < newLength; i++) {
			nums1[i]=nums[i];
		}
		System.out.println(Arrays.toString(nums1));
	}
}
