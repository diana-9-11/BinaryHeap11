import java.util.Arrays;

public class BinaryHeap {
    //Binary max heap implementation
    int[] data;
    int size; //current number of elements in the heap
    public BinaryHeap() {
        data = new int[10]; //initial capacity of 10, can be increased later
        size = 0;
    }

    public void ensureCapacity(){
        if(data.length == size){
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
