package Heapify;

import Lesson2.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        Heap<Integer> heap = new Heap();
        while (true){
            System.out.println("1. Создать массив.");
            System.out.println("2. Добаавить элемент.");
            System.out.println("3. Удалить эелемент с максимальным приоритетом.");
            System.out.println("4. Максимальный элемент.");
            System.out.println("5. Increase Key.");
            System.out.println("6. Печать heap.");
            System.out.println("7. Выход.");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    fillArray(arrayList);
                    showArray(arrayList);
                    heap.createHeap(arrayList);
                    break;
                }
                case 2:{
                    System.out.println("Введтите значение: ");
                    int value = scanner.nextInt();
                    heap.add(value);
                    break;
                }
                case 3:{
                    try {
                        System.out.println(heap.deleteMax());
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Нет элементов в куче.");
                    }
                    break;
                }
                case 4:{
                    try {
                        System.out.println(heap.getMax());
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Нет элементов в куче.");
                    }
                    break;
                }
                case 5:{
                    heap.increaseKey();
                    break;
                }
                case 6:{
                    try {
                        heap.printHeap();
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Нет элементов в куче.");
                    }
                    break;
                }
                case 7:{
                    System.exit(0);
                    break;
                }
            }
        }
    }
    private static void fillArray(ArrayList<Integer> arrayList){
        arrayList.clear();
        int number;
        for(int i = 0; i < 10; i++){
            number = (int)(Math.random()*98 + 1);
            while (!checkArrayElement(arrayList, number)){
                number = (int)(Math.random()*98 + 1);
            }
            arrayList.add(number);
        }
    }

    private static boolean checkArrayElement(ArrayList<Integer> arrayList, int number) {
        boolean bool = true;
        for(int i = 0; i < arrayList.size(); i++){
            try {
                bool = arrayList.get(i) == number ? false : null;
            }catch (NullPointerException e){}
        }
        return bool;
    }

    private static void showArray(ArrayList<Integer> arrayList){
        for(int i : arrayList){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

