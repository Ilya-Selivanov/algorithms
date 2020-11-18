package Lesson2;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseQuickSorting {
    public void start(ArrayList<Integer> arrayList, int left, int right) {
        if (arrayList.size() == 0 || arrayList == null) return;
        if (left > right) return;
        int l = left;
        int r = right;
        int partition = arrayList.get((left + right) / 2);
        while (l <= r) {
            while (arrayList.get(l) > partition) l++;
            while (arrayList.get(r) < partition) r--;
            if (l <= r) {
                Collections.swap(arrayList, l, r);
                l++;
                r--;
            }
        }
        if (left < r) start(arrayList, left, r);
        if (right > l) start(arrayList, l, right);
    }
}
