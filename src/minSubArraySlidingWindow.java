public class minSubArraySlidingWindow {
    public static int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= s) {
                minLen = Math.min(minLen, i - j + 1);
                currentSum -= nums[j];
                j++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0:minLen;
    }
    public static void main(String args[]){
        int[] in = {2,3,1,2,4,3};
        int ans = minSubArrayLen(7, in);
        System.out.println(">>> "+ans);
    }
}
