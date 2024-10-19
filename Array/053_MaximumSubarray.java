class Solution {
    public int maxSubArray(int[] nums) {

        // Case 1: If all the elements in the array are +ve then maxSum---> Sum of all elements
        // Case 2: If all the elements in the array are -ve then maxSum---> Largest Element of array
        // Case 3: If +ve and -ve both types of numbers are present 


        // Method 1: Naive Approach - TC - O(N2)
        // check sum of all the subarrays and if current sum > previous max sum so far then update 
        // maxSum by current sum

        /*
        int result = nums[0];

        // Outer loop for starting point of subarray
        for(int i=0;i<nums.length;i++){
            int currSum = 0;
            // Inner loop for ending point of subarray
            for(int j=i;j<nums.length;j++){
                currSum = currSum + nums[j];
                // Check if current sum is greater than result or not
                result = Math.max(result, currSum);
            }
        }

        return result; 
        */

        // Method 2: Kadane's Algorithm - O(N)

        int result = nums[0]; // Initialize with the 1st element
        
        int maxEndingHere = nums[0]; // Initial current max subarray sum
        
        
        for(int i=1;i<nums.length;i++){
            
            // Update maxEndingHere 
            maxEndingHere = Math.max(nums[i], maxEndingHere+nums[i]);
            
            // Update maxSoFar if maxEndingHere is greater
            result = Math.max(result, maxEndingHere);
        }
        
        return result;

    }
}
