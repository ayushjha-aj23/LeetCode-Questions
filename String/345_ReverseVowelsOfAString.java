class Solution {

    // Method 1: Naive Approach 
    // Step 1- Extract the vowels from the string.
    // Step 2- Reverse the list of vowels.
    // Step 3- Reconstruct the string, replacing the vowels in their original positions with the reversed vowels.

    /*
    public String reverseVowels(String s) {
        // Step 1: Collect all vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: Reverse the list of vowels
        Collections.reverse(vowels);

        // Step 3: Reconstruct the string with reversed vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    */

    public String reverseVowels(String s) {  
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Move left pointer to the next vowel
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            
            // Move right pointer to the previous vowel
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            
            // Swap vowels at left and right
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
