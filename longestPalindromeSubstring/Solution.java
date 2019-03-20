package longestPalindromeSubstring;

class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 0) {
        	return "";
        }
        boolean[][] isPalindrome = new boolean[length][length];
        //first: higherbound
        //second: lowerbound
        int maxLength = 0; 
        int lo = 0;
        int hi = 0;
        for(int i = 0; i < length; i++){
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i + 1 < length; i++) {
        	if(s.charAt(i) == s.charAt(i+1)) {
        		isPalindrome[i+1][i] = true;
        		maxLength = 2;
        		lo = i;
        		hi = i+1;
        	}
        }
        
        for(int i = 3; i <= length; i++){
            // j is lower index; i is substring length
        	//lowIn: inner lower bound
        	//highIN: inner higher bound
            for(int j = 0; j + i - 1 < length; j++){
                int lowIn = j + 1;
                int highIn = j + i - 2;
                boolean innerPa = isPalindrome[highIn][lowIn]; 
         
                if(innerPa && s.charAt(highIn+1) == s.charAt(j)){
                    isPalindrome[highIn+1][j] = true;
                    if(i > maxLength){
                    	maxLength = i;
                        lo = j;
                        hi = highIn + 1;
                    }
                }
            }
        }
        return s.substring(lo, hi+1); 
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.longestPalindrome(""));
    }
}