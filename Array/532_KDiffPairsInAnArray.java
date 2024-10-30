class Solution {

    // We have 3 Approaches to Solve the Problem
    // 1. Naive Approach - Nested Loops - O(N2)
    // 2. Two Pointer Approach -
    // 3. HashMap Using count


    // Method 3: Using HashMap
    // Issue - Let's say we have 
    // nums = [3 1 4 1 5] and K = 2 so Correct Output here is 2 (3,1) and (3, 5)
    // This will not give the unique output because - 3,1 and 3,1 will also be counted 2time
    /*
    public int findPairs(int[] nums, int K) {
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i=0;i<n;i++){

            if(frequencyMap.containsKey(nums[i]-K))
                count += frequencyMap.get(nums[i]-K);
            
            if(frequencyMap.containsKey(nums[i]+K))
                count += frequencyMap.get(nums[i]+K);
            
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0)+1);
        }

        return count;
    }
    */

    // 
    public int findPairs(int[] nums, int K) {
        if (K < 0) return 0; // Absolute difference cannot be negative

        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashSet<Integer> uniquePairs = new HashSet<>(); // Change to store unique numbers

        for (int num : nums) {
            // Update frequency of the current number
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.keySet()) {
            if (K == 0) {
                // For K == 0, count only if the number appears more than once
                if (frequencyMap.get(num) > 1) {
                    uniquePairs.add(num); // Only add the number itself
                }
            } else {
                if (frequencyMap.containsKey(num + K)) {
                    uniquePairs.add(num); // Add the base number for the pair
                }
            }
        }

        return uniquePairs.size(); // Return the count of unique pairs
    }
}
