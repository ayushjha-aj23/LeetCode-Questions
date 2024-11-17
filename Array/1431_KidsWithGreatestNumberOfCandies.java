class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        
        // Use Arrays.stream() and max()
        int maxInList = Arrays.stream(candies).max().orElseThrow();

        for (int i = 0; i <candies.length; i++) {
            if(candies[i]+extraCandies >= maxInList)
                result.add(true);
            else
                result.add(false);
        }

        return result;        
    }
}
