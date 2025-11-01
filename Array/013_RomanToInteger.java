class Solution {

    // Naive Approach - Using Switch 
    // Use switch to get Roman values directly.
    /*
    public int romanToInt(String s) {
        
        int total = 0;
        int preValue = 0;
        int value = 0;

        for(int i=s.length()-1; i>=0; i--){
            value = getInt(s.charAt(i));
            if(value<preValue)
                total -= value;
            else 
                total += value;

            preValue = value;
        }
        return total;
    }

    private int getInt(char c){
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

    // Optimised Using HashMap - Right to Left  
    // Start from the end of the string.
    // Keep track of the  last seen value.
    // If current value < last value → subtract
    // else → add.
    
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int total = 0;
        int value = 0;
        int preValue = 0;

        for(int i=s.length()-1; i>=0; i--){
            value = hashMap.get(s.charAt(i));

            if(value<preValue)
                total -= value;
            else
                total += value;
            
            preValue = value;
        }

        return total;
    }
    

    // Optimised Using HashMap - Left to Right  
    // For each character, compare with the next one.
    // If current < next → subtract current.
    // Else → add current.
    /*
    public int romanToInt(String s) {
        
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int total = 0;
        int currentValue = 0;
        // int preValue = 0;

        for(int i=0; i<s.length(); i++){
            value = hashMap.get(s.charAt(i));

            // Next in Range && currentValue < nextValue
            if(i+1 < s.length() && currentValue<hashMap.get(s.charAt(i+1)))
                total -= value;
            else
                total += value;
        }

        return total;
    }
    */
}
