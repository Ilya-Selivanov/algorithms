package Sorts;

import Lesson2.Container;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public void start(ArrayList<Integer> arrayList, Container<Integer> container){
        int min, i, j;
        for(i = 0; i < arrayList.size()-1; i++){
            container.setValue(container.getValue()+1);
            min = i;
            for(j = i+1; j < arrayList.size(); j++){
                container.setValue(container.getValue()+1);
                if(arrayList.get(j) < arrayList.get(min)) min = j;
            }
            Collections.swap(arrayList, i, min);
        }
    }
}
