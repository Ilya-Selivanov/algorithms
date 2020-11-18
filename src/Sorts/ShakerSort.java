package Sorts;

import Lesson2.Container;

import java.util.ArrayList;
import java.util.Collections;

public class ShakerSort {
    public void start(ArrayList<Integer> arrayList, Container<Integer> integerContainer) {
        int left = 0; int right = arrayList.size()-1;
        int l = left, r = right;
        while (l < r) {
            for (int i = l; i < r - 1; i++) {
                integerContainer.setValue(integerContainer.getValue()+1);
                if (arrayList.get(i) > arrayList.get(i + 1)) {
                    Collections.swap(arrayList, i, i + 1);
                }
            }
            r--;
            for (int i = r; i > l; i--) {
                integerContainer.setValue(integerContainer.getValue()+1);
                if (arrayList.get(i - 1) > arrayList.get(i)) {
                    Collections.swap(arrayList, i, i - 1);
                }
            }
            l++;
        }
    }
}
