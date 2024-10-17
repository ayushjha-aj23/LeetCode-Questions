class Solution {
    public int majorityElement(int[] nums) {
        
        // Boyer-Moore Voting Algorithm in TC - O(N)
        // The approach consists of two main steps: 
        // finding a candidate for the majority element and then 
        // validating whether that candidate is indeed the majority element.


        //Dry Run - nums = [1, 2, 3, 2, 4, 2, 2]
        //          nums = 1,   2      3      2      4      2      2
        //     candidate = 1    1      3      3      4      4      2                 
        //         score = 0,1  1-1,0  0+1,1  1-1,0  0+1,1  1-1,0  1

        int candidate = -1;  // This will give the candidate 
        int score = 0;
        // Step 1: Find the candidate
        for (int num : nums) {
            if (score == 0) {
                candidate = num;
            }
            score += (num == candidate) ? 1 : -1;
        }

        // Step 2: Validate the candidate
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        // Check if the candidate is indeed the majority element
        if (count > nums.length / 2) {
            return candidate;
        }

        return -1;
    }
}


