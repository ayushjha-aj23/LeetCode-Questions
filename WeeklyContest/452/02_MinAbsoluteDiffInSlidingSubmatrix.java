class Solution {

    // TC - Outer Loop will take -> (m-k+1)(n-k+1)
    // Inserting in TreeSet is -> log k and Traversal is -> k^2
    // So, total TC -> O((m-k+1)(n-k+1).k^2 log k)

    // SC - Spcae per submatrix - k^2 and ans[][] will take O((m−k+1)(n−k+1)) 
    // So, total SC -> O(k^2+ (m−k+1)(n−k+1))
    public int[][] minAbsDiff(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m-k+1][n-k+1];

        for(int i=0; i<=m-k; i++){
            for(int j=0; j<=n-k; j++){

                // Using Treeset to store sorted unique elements in k*k order
                TreeSet<Integer> treeSet = new TreeSet<>();


                // Collect all the elements in current k*k matrix
                for(int x=i; x<i+k; x++){
                    for(int y=j; y<j+k; y++){
                        treeSet.add(grid[x][y]);
                    }
                }

                // Find the min absolute diff betweeen the consecutive unique sorted elements 
                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;

                for(Integer val: treeSet){
                    if(prev!= null){
                        minDiff = Math.min(minDiff, Math.abs(val-prev));
                    }
                    prev = val;
                }

                // If only 1 unique value, minDiff stay Integer.MAX_VALUE means 0 diff
                ans[i][j] = minDiff == Integer.MAX_VALUE? 0:minDiff;

            }
        }

        return ans;
    }
}
