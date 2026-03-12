public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.insert(50);
        heap.insert(33);
        heap.insert(80);
        heap.insert(10);
        heap.insert(65);
        heap.printData();
        heap.poll();
        heap.poll();
        heap.printData();
    }
}
