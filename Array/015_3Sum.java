class Solution {

    // Step 1: Sort the Array
    // Step 2: Fix one Element - arr[i] and find pair arr[j] and arr[k]
    // Step 3: Initialize 2 Pointers -> left from i+1 and right from end of array
    // Step 4: Calculate the sum
            // a. If sum = 0, add the triplet to the result.
            // b. If sum < 0, left++ to increase the sum
            // c. If sum > 0, right++ to decrease the sum
    // Step 5: Skip Duplicates where left = right
    // Step 6: Avoid Duplicates for i
    // Step 7: Return unique triplet
    
    // Edge Cases
    // 1. No Triplet Found
    // 2. Multiple Identical Triplets
    // 3. All elements are 0

    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        // Step 1
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            // Step 3
            int left = i+1, right = nums.length-1;

            while(left<right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                
                    // check for left and right duplicate
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;

                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                }
                else if(sum<0)
                    left++;
                else if(sum>0)
                    right--; 
            }
        }

        return result;
    }
}
