class Solution {

    // Method 1: Naive Approach - Using Nested Loops
    // Step1: Initialization: Start with an array candies where each child initially gets one candy.
    // Step2: Forward Pass: Traverse from left to right. If a child has a higher rating than the previous child, increment their candy count accordingly.
    // Step3: Backward Pass: Traverse from right to left. If a child has a higher rating than the next child, ensure their candy count is higher than the next child's count.

    
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
    
        // Initial distribution of 1 candy to each child
        Arrays.fill(candies, 1);

        // Forward pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
    
    
        // Backward pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) 
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    
    
        // Calculate total candies
        int totalCandies = 0;
        for (int c : candies)
            totalCandies += c;
    
        return totalCandies;
    }
}
