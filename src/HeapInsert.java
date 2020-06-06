import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapInsert {
    /*
        Max Heap insert complexity is O(nLog n)

        Formula to insert a child i+1 and i+2
        to find child's parent i/2 until it reaches to ultimate parent
     */

    static void maxHeapInsert(int[] inputArray){
        List<Integer> maxHeap = new ArrayList<>();
        for(int element:inputArray){
            if(maxHeap.size()==0){
                maxHeap.add(element);  // 10
                continue;
            } else {
                maxHeap.add(element);  // 40, 45 , 30 , 10
            }
            int counter = maxHeap.size(); //3 , 4
            for(int i=0; i<counter; i++){
                int indices = (counter)/2; //4/2 =2 , 3/2=1
                if(element>maxHeap.get(indices-1)){ // 45, 40
                    int temp = maxHeap.get(indices-1);
                    maxHeap.set(indices-1, element);
                    maxHeap.set(counter-1, temp);  // 40, 10 , 30
                }
                counter = indices;
            }
            System.out.println("MaxHeap: "+ Arrays.toString(maxHeap.toArray()));
        }
    }

    public static void main(String args[]){
        int[] heapInput = {10, 40, 30, 45, 15, 33, 90};
        maxHeapInsert(heapInput);
    }
}
