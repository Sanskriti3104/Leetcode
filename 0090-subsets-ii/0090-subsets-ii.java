import java.util.*;

class Solution {
    static void findSubset(int idx, int[] nums, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<>(subset)); // Add the current subset (including empty)

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue; // Skip duplicates
            subset.add(nums[i]);
            findSubset(i + 1, nums, result, subset);
            subset.remove(subset.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        findSubset(0, nums, result, new ArrayList<>());
        return result;
    }
}
