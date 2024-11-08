// Naive Approach
// Step 1: Define Boundaries:
//  a. Set up boundaries for the top, bottom, left, and right edges of the matrix.
// Step 2: Iterate in Spiral Order:
//  a. Traverse the top row from left to right, then move the top boundary down.
//  b. Traverse the right column from top to bottom, then move the right boundary left.
//  c. Traverse the bottom row from right to left (if still in bounds), then move the bottom boundary up.
//  d. Traverse the left column from bottom to top (if still in bounds), then move the left boundary right.
// Step 3: Repeat Until Boundaries Overlap.

// Time Complexity: 𝑂(𝑚×𝑛)O(m×n) where 𝑚 is the number of rows and𝑛is the number of columns.
// Space Complexity: 𝑂(𝑚×𝑛)O(m×n) for storing the output array.
    
    
// Function to return a list of integers denoting spiral traversal of matrix.
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();

        int left = 0; 
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;

        while(left<=right && top<=bottom){
            
        // Step 1: Left to Right ---> (1,1), (1,2), (1,3) --- Row is fixed i.e. "top"
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;

        // Step 2: Top to Bottom ---> (1,5), (2,5), (3,5) --- Column is fixed i.e. "right"
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

        // Step 3: Right to Left ---> (5,5), (5,4), (5,3) --- Row is fixed i.e. "bottom"
            // Additional Check - Traverse from right to left
            if (top <= bottom) {    
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

        // Step 4: Bottom to Top ---> (5,1), (4,1), (3,1) --- Column is fixed i.e. "left"
            // Traverse from bottom to top
            if (left <= right) {    
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result; 
    }
}
