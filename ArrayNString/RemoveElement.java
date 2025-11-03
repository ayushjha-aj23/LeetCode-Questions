
// LC-27

class Solution {

    // 1- Fast and Slow Pointer - BEST
    // Use two pointers:
    // fast → scans every element
    // slow → tracks position for non-val elements
    // When nums[fast] != val, copy it to nums[slow] and increment both.
    public int removeElement(int[] nums, int val) {

        int slow = 0;

        for(int fast=0; fast<nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    // 2-Two Pointer from both ends
    // Useful when order doesn’t matter.
    // Start two pointers: i at start and n as current array length
    // If nums[i] == val → replace with nums[n-1] and shrink n-- else, increment i.
    // Stop when i >= n.

    // 3- Using Extra Array (Not In-Place)
    // Create a new array and copy only non-val elements.

    // 4- Stream / Functional (Java 8+)
    // Convert to Stream and then filter and take out only those which are != val and store them toArray
    // Then back from that array to original array and output the size.
}
