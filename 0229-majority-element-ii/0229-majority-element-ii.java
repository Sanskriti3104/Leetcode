class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // 1st pass: find potential candidates
        for (int i = 0; i < nums.length; i++) {
            if (el1 == nums[i]) {
                count1++;
            } else if (el2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                el1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                el2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: verify counts
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == el1) count1++;
            else if (num == el2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(el1);
        if (count2 > nums.length / 3) result.add(el2);

        return result;
    }
}
