package twoSum;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] returnValue = new int[2];
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
        	int num = nums[i];
        	int another = target - num;
        	if(map.containsKey(another)) {
        		int anotherIndex = map.get(another);
        		if(anotherIndex == i)	continue;
        		returnValue[0] = i;
        		returnValue[1] = anotherIndex;
        		break;
        	}
        }
        return returnValue;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] array = {7,11,15,2};
    	int[] result = s.twoSum(array,13);
    	System.out.println(Arrays.toString(result));
    }
}