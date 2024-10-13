//Level - Medium

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        // Result Set
        List<List<Integer>> powerSet = new ArrayList<>();
        // Temporary Set
        ArrayList<Integer> tempSet = new ArrayList<>();
        
        int start = 0;
        backTrack(powerSet, tempSet, nums, start);
        
        return powerSet;
    }
    
    public static void backTrack(List<List<Integer>> powerSet, 
            ArrayList<Integer> tempSet, int[] nums, int start)
    {
        // Add TempSet to the powerSet
        powerSet.add(new ArrayList<>(tempSet));
        
        
        // For Loop
        for(int i=start;i<nums.length;i++){
            
            // Include the number
            tempSet.add(nums[i]);
            
            // BackTrack the new tempSet
            backTrack(powerSet, tempSet, nums, i+1);
            
            // Not Including the number
            tempSet.remove(tempSet.size()-1);
        }
    }
}

