class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // Method 1: Naive Approach - Nested Loops
        /*
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];

                if(sum == k)
                    count++;
            }
        }
        return count;
        */

        // Method 2: HashMap 

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);

        int preSum =0;
        int count = 0;

        for(int i=0;i<nums.length;i++){

            preSum += nums[i];
            int removeSum = preSum - k;

            count += hashmap.getOrDefault(removeSum, 0);
            // Above code means that if remove Sum is present get its value 
            // i.e. number of times remove is present in hashmap ---> count = count + (value)
            // Ortherwise add 0 with count ---> count = count + 0;

            hashmap.put(preSum, hashmap.getOrDefault(preSum, 0)+1);
            // If in hashmap preSum is present then get Value and add 1 - result
            // If in hashmap preSum is not present then 0 and add 1 - result

            // From above 2 any 1 will work and then put in map - (preSum, result)
        }

        return count;
    }
}
