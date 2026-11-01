
class Solution {
    public int minMoves(int[] nums) {

        int min = nums[0];
        int sum = 0;

        // Find minimum and sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // Calculate minimum moves
        return sum - (min * nums.length);
    }
}
