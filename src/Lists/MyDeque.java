package Lists;

import java.util.LinkedList;

public class MyDeque<Type> {
    private LinkedRoster<Type> linkedList = new LinkedRoster<>();
    int size = 0;
    public void pushBack(Type item){
        linkedList.insert(item, size);
        size++;
    }

    public void pushFront(Type item){
        linkedList.insert(item, 0);
        size++;
    }

    public Type popBack(){
        if(size == 0){
            System.out.println("Deque is empty.");
            return null;
        }
        size--;
        return linkedList.delete(size);
    }

    public Type popFront(){
        if(size == 0){
            System.out.println("Deque is empty.");
            return null;
        }
        size--;
        return linkedList.delete(0);
    }

    public Type front(){
        if(size == 0){
            System.out.println("Deque is empty.");
            return null;
        }
        return linkedList.get(0);
    }

    public Type back(){
        if(size == 0){
            System.out.println("Deque is empty.");
            return null;
        }
        return linkedList.get(size - 1);
    }
    public void show(){
        if(size == 0){
            System.out.println("Deque is empty.");
            return ;
        }
        linkedList.show();
    }
}
