package maxWater;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = -1;
        while(l != r) {
        	int areaNow = (r-l)*Math.min(height[l], height[r]);
        	max = areaNow > max ? areaNow : max;
        	if(height[l] > height[r]) {
        		r--;
        	}else {
        		l++;
        	}
        }
        return max;
    }
    public static void main(String[] args) {
    	int[] area = {1,2,3,4,5};
    	Solution s = new Solution();
    	System.out.println(s.maxArea(area));
    }
}