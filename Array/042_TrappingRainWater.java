class Solution {

    // Method 1: Naive Approach 
    /*
    public int trap(int[] height) {
        
        int n = height.length;
        int totalWater = 0;

        for(int i=0;i<n;i++){
            // Find the maximum element on its left
            int leftMax = 0;
            for(int j=0;j<=i;j++) 
                leftMax = Math.max(leftMax, height[j]);
            // Find the maximum element on its right
            int rightMax = 0;
            for(int j=i;j<n;j++)
                rightMax = Math.max(rightMax, height[j]);
            
            // Update the totalWater
            totalWater += Math.max(0, Math.min(leftMax, rightMax)-height[i]);
        }
        return totalWater;
    }
    */

    // Method 2: Optimised Approach - Using Two Pointer 
    // At each step:
    // 1. If the left height is less than or equal to the right height, we can       calculate trapped water at the left pointer and move it right.
    // 2. Otherwise, calculate trapped water at the right pointer and move it left.

    // The trapped water at each pointer can be calculated similarly:
    // trapped_water = max⁡(0,current_max−height[𝑝𝑜𝑖𝑛𝑡𝑒𝑟]);

    public int trap(int[] height) {
        int left=0, right=height.length-1;
        int leftMax=0, rightMax=0;
        int totalWater = 0;


        while(left<right){
            if(height[left]<=height[right]){
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }
        return totalWater;
    }
}
