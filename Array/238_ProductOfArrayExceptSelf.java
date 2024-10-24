class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        // Method 1: Two-Pass Method (Left and Right Products)
        /*
        int n = nums.length;

        int[] output = new int[n];

        // Initialize the product with 1
        output[0] = 1;

        // Step 1: Calculate left products
        for(int i=1;i<n;i++){
            output[i] = output[i-1]*nums[i-1];
        }

        // Step 2: Calculate the right product and finalize the output
        int rightProduct = 1;
        for(int i=n-1;i>=0;i--){
            output[i] *= rightProduct;
            rightProduct *= nums[i]; 
        } 
        
        return output;
        */

        // Method 2: Single Pass with Constant Space
        
        int n = nums.length;
        int[] output = new int[n];

        // Initialize the output array
        output[0] = 1;

        // Calculate left products directly in output array
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Calculate right products and finalize the output in a single pass
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output; 
    }
}
