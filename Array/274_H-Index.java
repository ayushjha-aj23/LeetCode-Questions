class Solution {

    // What is h-index
    // It aims to quantify both the number of publications 
    // and the number of citations those publications have received.
    // A researcher has an h-index of ℎ
    // They have published at least ℎ that have each been cited at least h times.
    // For example, if a researcher has an h-index of 5, 
    // it means they have published at least 5 papers, each cited at least 5 times.
    

    // Method - 1: Naive Approach - TC -O(N2)
    // We will count how many papers have at least h citations. 
    
    /*
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int h=n;h>=0;h--){
            int count = 0;
            for(int citation : citations){
                if(citation >= h)
                    count++;
            }

            if(count>=h)
                return h;
        }
        return 0;
    }
    */

    // Method 2: The optimized approach uses sorting and 
    // then counts the number of citations efficiently.  TC - O(Nlog N)
    // Now, we can iterate through it to 
    // find the maximum h such that there are at least h papers with at least h citations.
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        for(int i=0;i<n;i++){
            // Calculate the number of papers that have atleast (n-i) citations

            int h = n-i; // Potential h-index

            if(citations[i]>=h)
                return h;
        }
        return 0;
    }
}
