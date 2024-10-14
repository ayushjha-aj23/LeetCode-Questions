class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Points to the last valid element in nums1
        int i = m-1;
        // Points to the last valid element in nums2
        int j = n-1;
        // Points to the last position in nums1 
        int k = m+n-1;


        // While there are elements to compare in both the arrays 
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // No need to copy remaining elements from nums1 since they're already in place

        // If there are remaining elements in nums2 fill them directly 
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
