class Solution {

    // TC - O(2^n.n^2) and SC - O(n)
    // Approach - Using BitMasking
    public boolean checkEqualPartitions(int[] nums, long target) {

        int n = nums.length;
        int totalPossibleCases = 1 << n; // Used to calculate the total no. of subsets

        /*
        E.g. nums = [3, 1, 2] then n = 3
        1 in binary is 0001
        1 << 3 becomes -> 1000 (in decimal is 8)
        So, total 8 subsets are possible if nums contains 3 elements
        */ 

        // Also, we will exclude 2 cases -> [], [1,2,3] (Empty Set and Containing all)
        for(int mask=0; mask<totalPossibleCases-1; mask++){
            long prod1 = 1;
            long prod2 = 1;
            List<Integer> validMask = new ArrayList<>();


            // Build subset1 
            for(int i=0; i<n; i++){
                if ((mask & (1 << i)) != 0) {
                    prod1 *= nums[i];
                    validMask.add(i);
                }
            }

            if(prod1!=target) continue;
            
            for(int i=0; i<n; i++){
                if(!validMask.contains(i))
                    prod2 *= nums[i];
            }

            if(prod2 == target) return true;
        }

        return false;
    }
}
