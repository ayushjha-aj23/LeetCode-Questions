class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int right = 0;

        for(int left=0;left<n;left++){
            if(nums[left] != 0){ // Reverse Approach 
                nums[right] = nums[left];

                if(left!=right)
                    nums[left] = 0;
                
                right++;
            }
        }
    }
}
