package Sorts;

import Lesson2.Container;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    public void start(ArrayList<Integer> arrayList, int left, int right, Container<Integer> n) {
        if (arrayList.size() == 0 || arrayList == null) return;
        if (left > right) return;
        int l = left;
        int r = right;
        int partition = arrayList.get((left + right) / 2);
        while (l <= r) {
            while (arrayList.get(l) < partition) {
                n.setValue(n.getValue()+1);
                l++;
            }
            while (arrayList.get(r) > partition) {
                n.setValue(n.getValue()+1);
                r--;
            }
            if (l <= r) {
                Collections.swap(arrayList, l, r);
                l++;
                r--;
            }
        }
        if (left < r) start(arrayList, left, r, n);
        if (right > l) start(arrayList, l, right, n);
    }
}
