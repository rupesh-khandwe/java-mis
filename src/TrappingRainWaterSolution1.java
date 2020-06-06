public class TrappingRainWaterSolution1 {

      static int findTrapSpaceForWater(int[] inputArray, int length){
          // { 0, 1, 2, 0, 0, 2, 3, 2, 0 };
          int trapSpace=0;
          int leftMaxWall = 0, rightMaxWall = 0;
          int leftPointer = 0, rightPointer = length-1;

          while(leftPointer <= rightPointer){
              if(inputArray[leftPointer] < inputArray[rightPointer]){
                  if(inputArray[leftPointer]>leftMaxWall)
                      leftMaxWall = inputArray[leftPointer];
                  else
                      trapSpace += leftMaxWall - inputArray[leftPointer];
                  leftPointer++;
              } else {
                  if(inputArray[rightPointer]>rightMaxWall)
                      rightMaxWall = inputArray[rightPointer];
                  else
                      trapSpace += rightMaxWall - inputArray[rightPointer];
                  rightPointer--;
              }
          }
          return trapSpace;
      }

        /* Driver program to test above function */
        public static void main(String[] args)
        {
            int arr[] = { 0, 1, 2, 0, 0, 2, 3, 1, 3 };
            int n = arr.length;
            System.out.println("Maximum water that "
                    + "can be accumulated is "
                    + findTrapSpaceForWater(arr, n));
        }

}
