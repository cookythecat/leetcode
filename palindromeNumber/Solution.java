package palindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
    	Integer xx = x;
        String str = xx.toString();
        for(int i = 0; i < str.length()/2; i++){
            int counter = str.length() - 1 - i;
            if(str.charAt(i) != str.charAt(counter))   return false; 
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome(10));
    }
}