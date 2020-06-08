public class SlidingWindowProblem1 {
    /*
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
    of which the sum ≥ s. If there isn't one, return 0 instead.

    Example:
        Input: s = 7, nums = [2,3,1,5,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currSum=0;
        int innerCounter=0;
        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];
            while(currSum>=s){
                minLength = Math.min(minLength, i + 1 - innerCounter);
                currSum-=nums[innerCounter];
                innerCounter++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    public static void main(String args[]){
        int[] inputNums= {2,3,1,2,4,3};
        int finalSum = 7;
        int minLen = minSubArrayLen(finalSum, inputNums);
        System.out.println("minimal length of a contiguous subarray: "+ minLen);
    }
}
