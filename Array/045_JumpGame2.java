class Solution {

    // Method 1: Recursion Method - TC - O(2^N)
    /*
    public int jump(int[] nums) {
        return jumpHelper(nums, 0);
    }

    // Helper Method 
    private int jumpHelper(int[] nums, int index){
        if(index>=nums.length-1)
            return 0; // No Jumps

        int minJumps = Integer.MAX_VALUE;

        for(int i=1;i<=nums[index];i++){
            if(index+i < nums.length){
                int jumps = jumpHelper(nums, index+i);
                if(jumps != Integer.MAX_VALUE)
                    minJumps = Math.min(minJumps, jumps+1);
            }

        }

        return minJumps;
    }
    */


    // Method 2: Greedy Approach - TC - O(N)
    public int jump(int[] nums) {

        if(nums.length <=1)
            return 0;
        
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i=0;i<nums.length-1;i++){ // Will not consider last element as we have to reach their
            farthest = Math.max(farthest, i+nums[i]);


            // If we have reached the end of the current jump
            if(i==currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
}
