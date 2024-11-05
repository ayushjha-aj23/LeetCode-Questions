class Solution {

    // Method 1: Naive Approach 
    /*
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty and the adjacent plots are empty
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;  // Plant a flower here
                    count++;
                    if (count >= n) {
                        return true;  // If we have planted enough flowers, return true
                    }
                }
            }
        }
        return count >= n;  // If we could plant enough flowers
    }
    */


    // Method 2: Optimised Approach 
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while (i < flowerbed.length) {
            // Check if the current plot is empty and the adjacent plots are empty
            if (flowerbed[i] == 0) {
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;  // Plant a flower here
                    count++;
                    if (count >= n) {
                        return true;  // If we have planted enough flowers, return true
                    }
                    i += 2;  // Skip the next plot because it cannot have a flower
                } else {
                    i++;  // Move to the next plot if we can't plant here
                }
            } else {
                i++;  // Move to the next plot if the current plot is already occupied
            }
        }
        return count >= n;  // If we managed to plant enough flowers
    }
}
