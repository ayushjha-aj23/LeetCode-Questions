class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows<=1 || numRows>=s.length())
            return s; // No ZigZag Needed 
        

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for(int i=0;i<rows.length;i++){
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            rows[currentRow].append(c);

            if(currentRow==0)
                goingDown = true;
            else if (currentRow == numRows - 1) 
                goingDown = false;
            
            currentRow += goingDown? 1:-1; // Move Up or Down
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows)
            result.append(row);


        return result.toString();
    }

    /*
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) {
            return s; // No zigzag needed
        }

        StringBuilder result = new StringBuilder();
        int cycleLength = 2 * numRows - 2; // Length of one complete zigzag cycle

        for (int row = 0; row < numRows; row++) {
            for (int j = 0; j + row < s.length(); j += cycleLength) {
                result.append(s.charAt(j + row)); // Vertical down
                if (row != 0 && row != numRows - 1 && j + cycleLength - row < s.length()) {
                    result.append(s.charAt(j + cycleLength - row)); // Diagonal up
                }
            }
        }
        return result.toString();
    }
    */
}
