class Solution {


    // Method 1: StringBuilder Approach 
    /*
    public boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();

        // Filter the input string
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // Check if the filtered string is a palindrome
        String filteredStr = filtered.toString();
        String reversedStr = filtered.reverse().toString();
        return filteredStr.equals(reversedStr);
    }
    */

    // Method 2: Two Pointer Approach
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
}
