public class TrappingRainWater {
    static int[] arr = new int[] { 0,1,2,0,0,2,3,2,0,4 };//0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1

    static int findTrappingSpace(int length){

        int left[] = new int[length];
        int right[] = new int[length];
        int result = 0;

        left[0] = arr[0];
        System.out.println("Left array:");
        for(int i=1; i<length;i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
            System.out.print(left[i] + " ");
        }

        System.out.println("\n"+"Right array:");

        right[length - 1] = arr[length - 1];
        for(int i=length - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], arr[i]);
            System.out.print(right[i] + " ");
        }
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - arr[i];
            System.out.println("\n"+Math.min(left[i], right[i]) + " << >> " +arr[i] +" <<result>>"+result);
        }

        return result;
    }


    // Driver method to test the above function
    public static void main(String[] args)
    {
        System.out.println("Maximum water that can be accumulated is " + findTrappingSpace(arr.length));
    }
}
