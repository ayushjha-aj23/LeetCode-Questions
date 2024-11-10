class Solution {

    // Method 1: Hashing Approach
    /* 
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer, Integer> TwoSum = new HashMap<Integer, Integer>();

        for(int i=1;i<=numbers.length;i++){ // 1-Based Indexing
            int num = numbers[i-1];
            int complement = target-num;
            if(TwoSum.containsKey(complement))
                return new int[]{TwoSum.get(complement),i};
            
            TwoSum.put(num, i);
        }
        return new int[]{};
    }
    */

    // Method 2: 2-Pointer Approach
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                return new int[] { left + 1, right + 1 };  // Return 1-based indices
            } else if (currentSum < target) {
                left++;  // Move left pointer to the right to increase sum
            } else {
                right--;  // Move right pointer to the left to decrease sum
            }
        }
        
        // Since the problem guarantees exactly one solution, 
        // we should never reach here.
        return new int[] {};  
    }
}
