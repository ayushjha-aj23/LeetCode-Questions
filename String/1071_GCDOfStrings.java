class Solution {

    // Method 1: Naive Approach - O(N2)
    /*
    public String gcdOfStrings(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();

         // Step 1: Find the GCD of the lengths of str1 and str2
        int minLength = Math.min(n, m);

        // Step 2: Check divisibility starting from the smallest valid length
        for (int len = minLength; len > 0; len--) {
            String candidate = str1.substring(0, len); // take a prefix of length 'len'
            // Check if 'candidate' divides both 'str1' and 'str2'
            if (canDivide(str1, candidate) && canDivide(str2, candidate)) {
                return candidate; // Return the largest valid divisor
            }
        }
        return ""; // No valid divisor found
    }

    // Helper function that check if 's' is a multiple of 't' or not
    private static boolean canDivide(String s, String t){
        if(s.length()%t.length() != 0)
            return false; // If length of 's' is not a multiple of 't', it can't divide 's'
        
        int repeatCount = s.length()/t.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<repeatCount;i++)
            sb.append(t);

        return sb.toString().equals(s);
    }
    */

    public String gcdOfStrings(String str1, String str2) {
        // Step 1: If str1 + str2 is not equal to str2 + str1, there's no common divisor
        if (!(str1 + str2).equals(str2 + str1)) {
    return ""; // If the concatenated strings don't match, there's no common divisor
    }

        // Step 2: Find the greatest common divisor (GCD) of the lengths of the two strings
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: The candidate string is the prefix of str1 of length 'gcdLength'
        String candidate = str1.substring(0, gcdLength);

        // Step 4: Check if this candidate divides both strings (it's guaranteed if str1 + str2 == str2 + str1)
        return candidate;
    }

    // Method to compute the GCD of two numbers (using Euclidean algorithm)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
