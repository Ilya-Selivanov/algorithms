package Lists;

import java.util.ArrayList;

public class MyQueue<Type> {
    private ArrayList<Type> arrayList= new ArrayList();
    int size = 0;
    public void enqueue(Type item){
        arrayList.add(item);
        size++;
    }
    public Type deque(){
        if(size == 0){
            System.out.println("Queue is empty.");
            return null;
        }
        size--;
        return arrayList.remove(0);
    }
    public Type front(){
        if(size == 0){
            System.out.println("Queue is empty.");
            return null;
        }
        return arrayList.get(0);
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        else return false;
    }

    public void show(){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + "\t");
        }
        System.out.println();
    }
}
