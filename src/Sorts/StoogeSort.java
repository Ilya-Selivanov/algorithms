package Sorts;

import Lesson2.Container;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class StoogeSort {
    public void start(ArrayList<Integer> arrayList, int left, int right, Container<Integer> integerContainer){
        integerContainer.setValue(integerContainer.getValue()+1);
        if(arrayList.get(left) > arrayList.get(right)){
            Collections.swap(arrayList, left, right);
        }
        if(left + 1 >= right) return;
        int third = (right - left + 1) / 3;
        start(arrayList, left, right - third, integerContainer);
        start(arrayList, left + third, right, integerContainer);
        start(arrayList, left, right - third, integerContainer);
    }
}
