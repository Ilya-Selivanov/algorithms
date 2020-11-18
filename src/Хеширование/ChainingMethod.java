package Хеширование;

import Lists.LinkedRoster;

import java.util.ArrayList;

public class ChainingMethod {
    private LinkedRoster<Integer> linkedRoster;
    private ArrayList<LinkedRoster> arrayList;

    ChainingMethod(){
        linkedRoster = new LinkedRoster<>();
        arrayList = new ArrayList<>();
    }

    public ArrayList<LinkedRoster> getHash(ArrayList<Integer> arrayList, int n){
        ArrayList<LinkedRoster> hash = new ArrayList<>();
        for (int i = 0; i < n; i++){
            hash.add(new LinkedRoster());
        }
        for (int i = 0; i < arrayList.size(); i++) {
            hash.get(hashFunction(arrayList.get(i),n)).insert(arrayList.get(i), hash.get(hashFunction(arrayList.get(i), n)).size());
        }
        this.arrayList = hash;
        return hash;
    }

    private int hashFunction(int k, int n){
        int h = k%n;
        return h;
    }

    public void show(){
        for(int i  = 0; i < arrayList.size(); i++){
            System.out.print(i + ":\t");
            arrayList.get(i).show();
        }
    }
}
