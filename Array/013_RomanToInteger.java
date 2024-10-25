class Solution {

    // Method 1: Naive Approach
    /*
    public int romanToInt(String s) {
        int total = 0;
        int preValue = 0;

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            int value = getRoman(c);

            if(value<preValue)
                total -= value; // Subtract if the current value is less than previous
            else
                total += value; // Otherwise, add it
            
            preValue = value;
        }

        return total;
    }

    private int getRoman(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;

            default: return 0;
        }
    }
    */

    // Method 2: Using Map
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (char c : s.toCharArray()) {
            int value = romanMap.get(c);

            if (value > prevValue) {
                total += value - 2 * prevValue; // Subtract twice the previous value
            } else {
                total += value;
            }
            prevValue = value;
        }

        return total;
    }

}
