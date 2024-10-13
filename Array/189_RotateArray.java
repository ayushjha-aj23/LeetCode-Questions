class Solution {
    public void rotate(int[] nums, int k) {

        // Method 1: Using TempArray 
        /*
        int n = nums.length;
        k = k % n;  // Ensure k is within the bounds of nums length

        // If k is 0 or nums length is 1, no need to rotate
        if (k == 0 || n <= 1) return;
        
        int[] tempArray = new int[k];

        // To Store the last K element in tempArray
        int a = 0;
        for(int i=nums.length-k;i<nums.length;i++){
           
            tempArray[a] = nums[i];
            a++;
        }

        // To shift the rest of the array to the right
        for(int i=nums.length-1;i>=k;i--){
            nums[i] = nums[i-k];
        }


        // Copy back K elements from tempArray to nums array starting from the beginning
        for(int i=0;i<k;i++){
            nums[i] = tempArray[i];
        }

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        */

        // Method 2: Reversing the array 
        // step1: Reverse the last K elements 
        // step2: Reverse the 1st N-K elements
        // step3: Reverse the whole array now

        int n = nums.length;
        k = k % n;
        int i, j;
        // Reverse last k numbers
        for (i = n - k, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // Reverse the first n-k terms
        for (i = 0, j = n - k - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // Reverse the entire array
        for (i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Print the rotated array
        for (int t = 0; t < n; t++) {
            System.out.print(nums[t] + " ");
        }


        // Method 3: If you only need to print the element directly and not from the array 
        // 1st Print from Kth Element to Last Element and then print 1st N-K Elements
        /*
        int n = nums.length;
        int K = k%n;

        // Early return if no rotation is needed
        if (k == 0 || n <= 1) return;

        // Create a new array to store the rotated values
        int[] rotatedArray = new int[n];

        for(int i=0;i<n;i++){

            // Print from Kth Element to Last Element
            if(i<K){
                // System.out.print(nums[n-K+i];
                rotatedArray[i] = nums[n - k + i];  // Last k elements
            }else{
                // System.out.print(nums[i-K]);
                rotatedArray[i] = nums[i - k];  // Remaining elements
            }
        }

        // Print the rotated array
        for(int i=0;i<n;i++){
            System.out.print(rotatedArray[i] + " ");
        }
        */
    }
}
