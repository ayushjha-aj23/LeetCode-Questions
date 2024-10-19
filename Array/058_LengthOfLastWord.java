class Solution {
    public int lengthOfLastWord(String s) {
        

        // Step-1 Trim the string
        // Step-2 Reverse the string 
        // Step-3 Count till it finds a space character
        // Return Count
        
        s = s.trim();
        int n = s.length();
        int count = 0;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) != ' ')
                count++;
            else
                break;
        }
        return count;
    }
}
