package Heapify;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable> {
    private ArrayList<T> arrayList = new ArrayList<>();
    private int size = 0;
    private boolean aBoolean = true;

    public void add(T data) {
        System.out.println(getSize());
        int i = getSize();
        int parent = (i - 1) / 2;
        arrayList.add(data);

        while (i > 0 && arrayList.get(parent).compareTo(arrayList.get(i)) < 0) {
            T temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(i));
            i = parent;
            parent = (i - 2) / 2;
        }
        size++;
        createHeap(this.arrayList);
    }

    public void createHeap(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
        size = arrayList.size();
        for (int i = getSize()/2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapify(int i) {
        int leftChild;
        int rightChild;
        int largestChild;
        while (true) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;
            if(aBoolean == true) {
                if (leftChild < getSize() && arrayList.get(leftChild).compareTo(arrayList.get(largestChild)) > 0) {
                    largestChild = leftChild;
                }

                if (rightChild < getSize() && arrayList.get(rightChild).compareTo(arrayList.get(largestChild)) > 0) {
                    largestChild = rightChild;
                }

                if (largestChild == i) {
                    break;
                }
            }
            else {
                if (leftChild < getSize() && arrayList.get(leftChild).compareTo(arrayList.get(largestChild)) < 0) {
                    largestChild = leftChild;
                }

                if (rightChild < getSize() &&  arrayList.get(rightChild).compareTo(arrayList.get(largestChild)) < 0) {
                    largestChild = rightChild;
                }

                if (largestChild == i) {
                    break;
                }
            }
            T temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(largestChild));
            arrayList.set(largestChild, temp);
            i = largestChild;
        }
    }

    public void printHeap(){
        if(getSize() != 0) {
            int space = 32;
            int roof = 1;
            int k = 0;
            for (T i : arrayList) {
                for (int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                System.out.print(i);
                for (int j = 0; j < space - 2; j++) {
                    System.out.print(" ");
                }
                k++;
                if (k == roof) {
                    System.out.println();
                    space /= 2;
                    roof *= 2;
                    k = 0;
                }
            }
            System.out.println();
        }
        else System.out.println("Нет элементов в куче.");
    }


    public T deleteMax() {
        T max = arrayList.get(0);
        arrayList.set(0, arrayList.get(getSize() - 1));
        arrayList.remove(getSize() - 1);
        size--;
        heapify(0);
        return max;
    }

    public T getMax() {
        return arrayList.get(0);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void increaseKey(){
        if(aBoolean == true) aBoolean = false;
        else aBoolean = true;
        createHeap(arrayList);
    }

}
