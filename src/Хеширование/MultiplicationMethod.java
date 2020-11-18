package Хеширование;

import java.util.ArrayList;

public class MultiplicationMethod {
    private double A;
    private ArrayList<Integer> hash;
    MultiplicationMethod(){
        this.A = (Math.sqrt(5) - 1)/2;
    }

    public ArrayList<Integer> getHash(ArrayList<Integer> arrayList, int n){
        ArrayList<Integer> hash = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++){
            hash.add(hashFunction(arrayList.get(i), n));
        }
        this.hash = hash;
        return hash;
    }

    private int hashFunction(int k, int n){
        int h = (int) (n*((k*A)%1));
        return h;
    }

    public int getCollision(){
        int n = 10;
        for (int i = 0; i < hash.size(); i++){
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

    public ArrayList<Integer> linearMethod(ArrayList<Integer> arrayList, int n){
        ArrayList<Integer> hash = new ArrayList<>();
        createArray(hash, n);
        for (int i = 0; i < arrayList.size(); i++){
            insertElement(hash, arrayList.get(i), n);
        }
        this.hash = hash;
        return hash;
    }


    private void insertElement(ArrayList<Integer> arrayList, int element, int n){
        if(arrayList.get(hashFunction(element, n))== 0) arrayList.set(hashFunction(element, n), element);
        else {
            for (int i = 0; i < n; i++) {
                if (hashFunction(element, n) == i) {
                    for (int j = i; ; j++) {
                        if (j >= arrayList.size()) increaseArray(arrayList);
                        if (arrayList.get(j) == 0) {
                            arrayList.set(j, element);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void createArray(ArrayList<Integer> arrayList, int n){
        for(int i = 0; i < n; i++){
            arrayList.add(0);
        }
    }

    private void increaseArray(ArrayList<Integer> array){
        array.add(0);
    }

}
