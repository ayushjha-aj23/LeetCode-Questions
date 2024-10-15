class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Using Two Pointers
        // left pointer points to new index where we can add the new unique value
        // right pointer will traverse the whole array to look for unique values.

        // start left and right with 1 because at index 0 it will be unique, and sorted as well
        int left = 1; 
        int right = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[right]!=nums[right-1]){
                nums[left] = nums[right];
                left++;
            }  
            right++;
        }

        // left will contain the number of unique values 
        return left;
    }
}
