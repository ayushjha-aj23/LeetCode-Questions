class Solution {
    public int removeDuplicates(int[] nums) {

        // If nums is empty then return 
        if(nums.length==0)
            return 0;
        
        int k = 0 ; // Count of unique elements
        int n = nums.length;

        for(int i=0;i<n;i++){

            // Count occurence of nums[i]
            int count = 1;
            while(i+1<n && nums[i] == nums[i+1]){
                count++;
                i++;
            } 

            // Add atmost 2 occurences
            for(int j=0; j< Math.min(2, count); j++){
                nums[k] = nums[i];
                k++;
                // OR in 1 line => nums[k++] = nums[i];
            }
        }
        return k;

        // Method 2: 
        /*
        int k=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
        */
    }
}
