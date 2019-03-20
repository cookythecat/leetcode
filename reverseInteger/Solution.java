package reverseInteger;

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        int digits = String.valueOf(x).length() - 1;
        if(x < 0){
            isNegative = true;
            digits -= 1;
            x *= -1;
        }
        int result = 0;
        while(x > 0){
        	int temp =(int) Math.pow(10,digits--);
        	if(isNegative) {
        		if(temp * (-1) < (double)Integer.MIN_VALUE/(x%10))	return 0;
        		if(result *(-1) < Integer.MIN_VALUE + temp*(x%10))	return 0;; 
        	}else {
        		if(temp> (double)Integer.MAX_VALUE/(x%10))	return 0;
        		if(result > Integer.MAX_VALUE - temp*(x%10))	return 0;
        	}
            result += (x%10) * temp;
            x /= 10;
        }
        if(isNegative)  result *= -1;
        return result;
        
    }
    public static void main(String[] agrs) {
    	Solution s = new Solution();
    	System.out.println(s.reverse(-1232131412));
    }
}