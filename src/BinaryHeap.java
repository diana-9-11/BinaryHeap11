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

    public int getLeftChildIndex(int index){
        int left = index * 2 + 1;
        if(left<size) return left;
        return -1;
    }
    public int getRightChildIndex(int index){
        int right = index * 2 + 2;
        if(right<size) return right;
        return -1;
    }
    public int getParentIndex(int index){
        if(index != 0){
            return (index - 1) / 2;
        }
        return -1;
    }

    public void swap(int i, int j){
        data[i] += data[j];
        data[j] = data[i] - data[j];
        data[i] -= data[j];
    }

    public void heapifyUp(int index){
        while (getParentIndex(index)!=-1 && data[getParentIndex(index)]<data[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    public void insert(int value){
        ensureCapacity();
        data[size] = value;
        size++;
        heapifyUp(size-1);
    }

    public void printData(){
        System.out.println(Arrays.toString(data));
    }
    //poll will return the value of the processed node and remove it from the heap
    public int poll(){
        //swap first and the last elements
        int result = data[0];
        swap(0, size-1);
        data[size-1] = 0;
        size--;
        heapifyDown(0);
        return result;
    }

    public void heapifyDown(int index){
        //zlotizost O log(n) since we are only going in one direction
        while(index!=-1){
            if(getLeftChildIndex(index)==-1)break;
            int greaterChild = getLeftChildIndex(index);
            if(getRightChildIndex(index)!= -1 && data[getRightChildIndex(index)]>data[greaterChild]) {
                greaterChild = getRightChildIndex(index);
            }
            if(data[index]<data[greaterChild]){
                swap(index, greaterChild);
                index = greaterChild;
            }
            else{ break;}
        }
    }
}
