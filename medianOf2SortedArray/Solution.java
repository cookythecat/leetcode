package medianOf2SortedArray;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(nums1.length == 0) {
    		if(nums2.length % 2==0) {
	    		return ((double)nums2[nums2.length/2-1] + nums2[nums2.length/2])/2;
	    	}else {
	    		return	nums2[nums2.length/2];
	    	}
    	}
    	if(nums2.length == 0) {
    		if(nums1.length % 2==0) {
	    		return ((double)nums1[nums1.length/2-1] + nums1[nums1.length/2])/2;
	    	}else {
	    		return	nums1[nums1.length/2];
	    	}
    	}
        int count1 = 0;
        int count2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum = length1 + length2;
        int medianIndex = (int) ((sum) % 2 == 0 ? sum/2 : Math.ceil((float)sum/2));
        int oneTwo = -1;
        if(sum == 1 || sum == 2) {
          	if(nums1[0] < nums2[0]) {
          		oneTwo = 1;
          		count1 = 1;
          	}else {
          		oneTwo = 2;
          		count2 = 1;
          	}
        }else {
        	boolean case1 = true;
        	if(length1 >= 2) {
        		if(nums1[1] < nums2[0])	case1 = false;
        	}
        	if(length2 >= 2) {
        		if(nums2[1] < nums1[0]) case1 = false;
        	}
        	if(sum == 3 && case1) {
             	if(nums1[0] > nums2[0]) {
              		oneTwo = 1;
              		count1 = 1;
              	}else {
              		oneTwo = 2;
              		count2 = 1;
              	}
        	}else {
		        while(count1 + count2 < medianIndex) {
		        	if(count1 == length1) {
		        		count2 = medianIndex - count1;
		        		oneTwo = 2;
		        		break;
		        	}
		        	if(count2 == length2){
		        		count1 = medianIndex - count2;
		        		oneTwo = 1;
		        		break;
		        	}
		        	int num1 = nums1[count1];
		        	int num2 = nums2[count2];
		        	if(num1 > num2) {
		        		count2++;
		        		oneTwo = 2;
		        	}else if (num2 > num1) {
		        		count1++;
		        		oneTwo = 1;
		        	}else{
		        		count1++;
		        		oneTwo = 1;
		        	}
		        }
        	}
        }
        System.out.println(count1 + "\n" + count2 + "\n1 or 2: " + oneTwo);
        int med = oneTwo == 1 ? nums1[count1-1] : nums2[count2 -1];
        if(sum % 2 == 0) {
        	int next = -1;
	        	if(count1 >= length1) {
	        		 next = nums2[count2];
	        	}else if(count2 >= length2) {
	        		next = nums1[count1];
	        	}else {
	        		next = Math.min(nums1[count1], nums2[count2]);
	        	}
	        	return ((float)med + next)/2;
        	}else {
        		return med;
        	}
    }
    
    public static void main(String[] args) {
    	int [] arr1 = {-2,-1};
    	int [] arr2 = {3};
    	Solution s = new Solution();
    	System.out.println(s.findMedianSortedArrays(arr2, arr1));
    }
}
