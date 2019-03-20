package regularExpressionMatch;

public class Solution {
	   public boolean isMatch(String s, String p) {
		   if(p.isEmpty()) 	return s.isEmpty();
		   boolean firstMatched = (!s.isEmpty()) && (s.charAt(0) == p.charAt(0) || p.charAt(0)== '.');
		   if(p.length() >= 2 && p.charAt(1) == '*') {
			   return isMatch(s,p.substring(2)) || (firstMatched && isMatch(s.substring(1),p));
		   }else {
			   return firstMatched && isMatch(s.substring(1),p.substring(1));
		   }
		   
	   }  
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] testTexts = {"ab",""};
    	for(String testText: testTexts) {
    		System.out.println(testText + ": " + s.isMatch(testText, ".*c"));
    	}
    	
    }
}
