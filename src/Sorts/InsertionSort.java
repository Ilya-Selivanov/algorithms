package Sorts;

import Lesson2.Container;

import java.util.ArrayList;

public class InsertionSort {
    public void start(ArrayList<Integer> arrayList, Container<Integer> container){
        for(int i = 1; i < arrayList.size(); i++){
            container.setValue(container.getValue()+1);
            int i2 = i;
            int element = arrayList.get(i);
            for(int j = i - 1; j >= 0 && element < arrayList.get(j); j--, i2--){
                container.setValue(container.getValue()+1);
                if(arrayList.get(j) > element) {
                    arrayList.set(i2, arrayList.get(j));
                }
            }
            arrayList.set(i2, element);
        }
    }
}
