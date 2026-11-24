
class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            int product = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < nums.length; j++) 
            {
                product = product * nums[j];
                gcd = findGCD(gcd, nums[j]);
                lcm = findLCM(lcm, nums[j]);

                if (product == gcd * lcm) 
                {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public int findGCD(int a, int b)
    {
        if (b == 0) 
        {
            return a;
        }

        return findGCD(b, a % b);
    }
    public int findLCM(int a, int b) 
    {
        return (a / findGCD(a, b)) * b;
    }
}
