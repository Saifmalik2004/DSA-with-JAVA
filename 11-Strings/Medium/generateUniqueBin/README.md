README.md: Find Different Binary String Problem
Problem Description
Given an array nums containing n unique binary strings (strings with only '0' or '1'), each of length n, find a binary string of length n that is not present in nums. Return any such string.
Key Details

Input: An array nums of n unique binary strings, each of length n.
Output: A binary string of length n that does not exist in nums.
Constraints:
1 <= n <= 16
All strings in nums are unique and contain only '0' or '1'.


Examples:
Input: nums = ["01", "10"]
Output: "11" (or "00", as neither is in nums)


Input: nums = ["00", "01"]
Output: "11" (or "10")


Input: nums = ["111", "011", "001"]
Output: "101" (or any other string not in nums)





Intuition
Since nums has n unique strings of length n, and there are 2^n possible binary strings of length n, there are many strings not in nums. The solution uses a clever trick: create a new string where each character differs from the corresponding character in each string of nums. This ensures the new string is unique.
For example, if nums = ["01", "10"]:

Take the opposite of the first character of nums[0] ('0' → '1').
Take the opposite of the second character of nums[1] ('0' → '1').
Result: "11", which is different from both "01" and "10".

Approach: Cantor's Diagonal Method
The solution constructs a binary string by taking the opposite bit of the i-th character of the i-th string in nums.
Steps:

Create a StringBuilder to build the result string.
For each index i from 0 to n-1:
Check the i-th character of nums[i].
If it’s '0', append '1' to the result.
If it’s '1', append '0' to the result.


Return the resulting string.

Java Code:
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return ans.toString();
    }
}

Why It Works:

The new string differs from nums[i] at position i (e.g., if nums[i][i] = '0', the new string has '1' at position i).
This guarantees the new string is different from every string in nums.
Since there are 2^n possible strings and only n are in nums, a different string always exists.

Time and Space Complexity:

Time Complexity: O(n), as we loop through n characters once.
Space Complexity: O(n) for the StringBuilder to store the result.

Example Walkthrough
For nums = ["01", "10"]:

At i = 0: nums[0][0] = '0', so append '1'.
At i = 1: nums[1][1] = '0', so append '1'.
Result: "11", which is not in nums.

Edge Cases

n = 1: If nums = ["0"], the result is "1". If nums = ["1"], the result is "0".
Large n (n = 16): The approach remains efficient, as it only processes n characters.
All strings unique: The problem guarantees this, so no duplicates in nums.

Testing
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test case 1
        String[] nums1 = {"01", "10"};
        System.out.println("Output 1: " + sol.findDifferentBinaryString(nums1)); // "11" or "00"
        // Test case 2
        String[] nums2 = {"00", "01"};
        System.out.println("Output 2: " + sol.findDifferentBinaryString(nums2)); // "11" or "10"
        // Test case 3
        String[] nums3 = {"111", "011", "001"};
        System.out.println("Output 3: " + sol.findDifferentBinaryString(nums3)); // e.g., "101"
    }
}

Why This Solution is Best
