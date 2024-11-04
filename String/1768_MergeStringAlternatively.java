class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());

        // Merge characters alternately
        for (int i = 0; i < n; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        // Append the remaining characters from the longer string
        if (word1.length() > n) {
            result.append(word1.substring(n));
        } else {
            result.append(word2.substring(n));
        }

        return result.toString();
    }
}
