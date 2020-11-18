package Хеширование;

import java.util.ArrayList;

public class DivisionMethod {

    private ArrayList<Integer> hash;

    public ArrayList<Integer> getHash(ArrayList<Integer> arrayList, int n) {
        ArrayList<Integer> hash = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hash.add(hashFunction(arrayList.get(i), n));
        }
        this.hash = hash;
        return hash;
    }

    private int hashFunction(int k, int n){
        int h = k%n;
        return h;
    }

    public int getCollision(){
        int n = 10;
        for (int i = 0; i < hash.size(); i++){
            if(checkRepeatingElementsInArray(hash, hash.get(i), i));
            for (int j = 0; j < hash.size(); j++){
                if (checkRepeatingElementsInArray(hash, hash.get(j), j)) {

                    if (hash.get(i) == hash.get(j) && i != j) n++;
                }
            }
        }
        return n;
    }

    private boolean checkRepeatingElementsInArray(ArrayList<Integer> arrayList, int elements, int n){
        boolean bool = true;
        for(int i = 0; i < n; i++){
            if(arrayList.get(i) == elements) bool = false;
        }
        return bool;
    }
}
