class Solution {
    public int maxArea(int[] height) {
        int left = 0;  // Start pointer at the beginning
        int right = height.length - 1;  // Start pointer at the end
        int maxArea = 0;  // To keep track of the maximum area
        
        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the area formed by the lines at the two pointers
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            
            // Update the maxArea if the current area is larger
            maxArea = Math.max(maxArea, area);
            
            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
        
    }
}
