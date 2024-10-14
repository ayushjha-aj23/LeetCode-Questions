class Solution {
    public String longestCommonPrefix(String[] strs) {
        // code here
        
        int n = strs.length; // Length or Number of Strings
        
        Arrays.sort(strs);  // Sort the strings by size(lengthwise)
        
        // prints the common prefix of the first and the 
        // last String of the set of strings 
        String result = commonPrefixUtil(strs[0], strs[n - 1]);
        
        if(result.length()==0)
            return "";
        else
            return result;
    }
    
    
    // A Utility Function to find the common prefix between 
    // first and last strings 
    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();
 
        // Compare str1 and str2 
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        
        return (result);
    }
    
}
