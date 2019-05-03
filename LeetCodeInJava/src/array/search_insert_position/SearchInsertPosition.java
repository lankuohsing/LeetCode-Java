package array.search_insert_position;

import java.util.Arrays;

class Solution1 {
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int result=-1;
        while(left<=right){
           int medium=(left+right)/2;
            
            if(nums[medium]==target){
                result=medium;
                return result;
            }
            else{
                if(nums[medium]>target){
                    right=medium-1;
                }
                else{
                    left=medium+1;
                }
            }
        }
    
        result=left;
        return result;
        
    }
}
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 5;
		int result=Solution1.searchInsert(nums, target);
		System.out.println(result);
	}
}
