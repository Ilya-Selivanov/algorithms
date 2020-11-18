package Sorts;

import Lesson2.Container;

import java.util.ArrayList;
import java.util.Collections;

public class DoubleSelectionSort {
    public void start(ArrayList<Integer> arrayList, Container<Integer> container){
        int min, max, i, j;
        int size = arrayList.size();
        for(i = 0; i < size-1; i++){
            container.setValue(container.getValue()+1);
            max = i;
            min = i;
            for(j = i+1; j < size; j++){
                container.setValue(container.getValue()+1);
                if(arrayList.get(j) < arrayList.get(min)) min = j;
                if(arrayList.get(j) > arrayList.get(max)) max = j;
            }
            Collections.swap(arrayList, i, min);
            Collections.swap(arrayList, size-1, max);
            size--;
        }
    }
}
