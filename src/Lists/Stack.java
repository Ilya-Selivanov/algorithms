package Lists;

import java.util.ArrayList;

public class Stack<Type> {
    private ArrayList<Type> arrayList = new ArrayList<>();
    int size = 0;
    public void push(Type item){
        arrayList.add(item);
        size++;
    }

    public Type pop(){
        if(size == 0){
            System.out.println("Stack is empty.");
            return null;
        }
        size--;
        return arrayList.remove(arrayList.size()-1);
    }

    public Type top(){
        if(size == 0){
            System.out.println("Stack is empty.");
            return null;
        }
        return arrayList.get(arrayList.size()-1);
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public void show(){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + "\t");
        }
        System.out.println();
    }
}
