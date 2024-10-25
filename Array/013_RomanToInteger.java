class Solution {
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
}
