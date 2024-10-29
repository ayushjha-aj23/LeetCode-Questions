class Solution {

    // Method 1: Naive Approach - O(N2)
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int start = 0; start < n; start++) {
            int totalGas = 0;
            int totalCost = 0;
            boolean canTravel = true;
            
            for (int i = 0; i < n; i++) {
                int index = (start + i) % n; // Circular indexing
                totalGas += gas[index];
                totalCost += cost[index];
                
                if (totalGas < totalCost) {
                    canTravel = false;
                    break;
                }
            }
            
            if (canTravel)
                return start;
        }
        return -1; // No valid starting point found
    }
    */

    // Method 2: Optimised Approach
    public int canCompleteCircuit(int[] gas, int[] cost){
        int totalTank = 0;
        int currentTank = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            
            if (currentTank < 0) {
                startIndex = i + 1; // Move start index to next station
                currentTank = 0; // Reset current tank
            }
        }

        return totalTank >= 0 ? startIndex : -1; // Check if a solution exists
    }
}
