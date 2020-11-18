package Lesson2;

import java.util.ArrayList;
import java.util.Collections;

public class PartShakerSorting {
    public void start(ArrayList<Integer> arrayList, int quelque) {
        int left = 0, right = quelque;
        while (right <= arrayList.size() - 1 + quelque) {
            int l = left, r = right;
            while (l < r) {
                for (int i = l; i < r - 1; i++) {
                    if (arrayList.get(i) > arrayList.get(i + 1)) {
                        Collections.swap(arrayList, i, i + 1);
                    }
                }
                r--;
                for (int i = r; i > l; i--) {
                    if (arrayList.get(i - 1) > arrayList.get(i)){
                        Collections.swap(arrayList, i, i - 1);
                    }
                }
                l++;
            }
            left += quelque;
            right += quelque;
        }
    }
}
