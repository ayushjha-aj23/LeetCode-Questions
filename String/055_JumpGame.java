class Solution {

    // Method 1: Recursion or Backtracking to check all the possible ways
    // By Recursion - O(2^n) in the worst case due to the recursive calls
    // Base Cases 
    // If the current index is equal to the last index, return true.
    // If the current index exceeds the length of the array, return false.
    
    /*
    public boolean canJump(int[] nums) {
        // Call the Helper Function 
        return canJumpHelper(nums, 0);
    }

    private boolean canJumpHelper(int[] nums, int index){

        // Base cases
        if(index==nums.length-1)
            return true;
        
        if(index>=nums.length)
            return false;
        

        int maxJump = nums[index];
        // Try all jumps from current index
        for(int i=1;i<=maxJump;i++){
            if(canJumpHelper(nums, index+i))  // if true call the same function 
                return true;
        }

        return false;
    }

    */

    // Method 2: Greedy Approach to efficiently determine 
    // if the last index is reachable in linear time. 

    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i=0;i<nums.length;i++){
            if(i>maxReach)
                return false; // Cannot reach this index

            maxReach = Math.max(maxReach, i+nums[i]);
            if(maxReach>=nums.length-1)
                return true;
        }

        return false;
    }
}
