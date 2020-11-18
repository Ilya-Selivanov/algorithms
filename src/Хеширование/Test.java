package Хеширование;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DivisionMethod divisionMethod = new DivisionMethod();
        MultiplicationMethod multiplicationMethod = new MultiplicationMethod();
        ChainingMethod chainingMethod  = new ChainingMethod();
        ArrayList<Integer> test = new ArrayList<>();
        ArrayList hash = new ArrayList<>();
        fillingOutArray(test, 100);
        show(test);
        System.out.println("Метод деления.");
        hash = divisionMethod.getHash(test, 10);
        show(hash);
        System.out.println("Количество колизий: " + divisionMethod.getCollision());
        hash = divisionMethod.getHash(test, 100);
        show(hash);
        System.out.println("Количество колизий: " + divisionMethod.getCollision());
        hash = divisionMethod.getHash(test, 101);
        show(hash);
        System.out.println("Количество колизий: " + divisionMethod.getCollision());
        System.out.println("Метод умножения.");
        hash = multiplicationMethod.getHash(test, 10);
        show(hash);
        System.out.println("Количество колизий: " + multiplicationMethod.getCollision());
        hash = multiplicationMethod.getHash(test, 100);
        show(hash);
        System.out.println("Количество колизий: " + multiplicationMethod.getCollision());
        System.out.println("Метод цепочек: ");
        hash = chainingMethod.getHash(test, 10);
        chainingMethod.show();
        System.out.println("Линейны метод: ");
        hash = multiplicationMethod.linearMethod(test, 10);
        show(hash);

    }

    public static void fillingOutArray(ArrayList<Integer> arrayList, int quantity) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int number;
        boolean bool;
        integerArrayList.add((int)(Math.random()*999));
        for (int i = 1; i < quantity; i++) {
            do{
                bool = false;
                number = (int) (Math.random() * 999);
                for (int j = 0; j < i; j++) {
                    if (integerArrayList.get(j) == number) bool = true;
                }
            }while (bool);
            integerArrayList.add(number);
        }
        arrayList.clear();
        arrayList.addAll(integerArrayList);
    }

    public static void show(ArrayList<Integer> arrayList) {
        System.out.println();
        for (int i : arrayList){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
