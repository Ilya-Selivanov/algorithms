package HeapSort;

import Heapify.Heap;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {
    Heap heap = new Heap();
    public void start(ArrayList<Integer> arrayList){
        heap.createHeap(arrayList);
        int size = arrayList.size();
        while (size - 1 >= 0) {
            Collections.swap(arrayList, 0, size-1);
            size--;
            heap.setSize(heap.getSize() - 1);
            heap.heapify(0);
        }
    }
}
