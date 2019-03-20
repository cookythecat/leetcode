package zigzagConversion;

class Solution {
    public String convert(String s, int numRows) {

        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        int index = 0;
        int length = s.length();
        while(index <  length){
            // i is row index, index is string index
            for(int i = 0; i < numRows && index < length; index++, i++){
                sbs[i].append(s.charAt(index));
            }
            for(int i = numRows - 2; i > 0 && index < length; index++, i--){
                sbs[i].append(s.charAt(index));
            }
        }
        String result = "";
        for(StringBuilder sb : sbs){
            result = result.concat(sb.toString());
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.convert("abcd",4));
    }
}