package Lesson2;

import java.util.ArrayList;
import java.util.Collections;

public class AlmostSorting {
    public void start(ArrayList<Integer> arrayList) {
        int l = 0; int r = arrayList.size();
        int flag = 0;
        while (l < r) {
            if(flag == 0){
                for (int i = l; i < r - 1; i++) {
                    if (arrayList.get(i) < arrayList.get(i + 1)){
                        Collections.swap(arrayList, i, i + 1);
                    }
                }
                r--;
                for (int i = r; i > l; i--) {
                    if (arrayList.get(i - 1) < arrayList.get(i)){
                        Collections.swap(arrayList, i, i - 1);
                    }
                }
                l++;
                flag++;
            }
            else {
                for (int i = l; i < r - 1; i++) {
                    if (arrayList.get(i) > arrayList.get(i + 1)){
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
        }
    }
}
