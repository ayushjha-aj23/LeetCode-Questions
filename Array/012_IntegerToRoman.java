class Solution {
   
    // Method1: Optimised Approach - Using Direct Mapping With an Array 
    public String intToRoman(int num) {
        // Define Roman numeral symbols and their values
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",  "V", "IV", "I"};

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        // Construct the Roman numeral
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
}
