package Lesson2;

import Sorts.QuickSort;
import Sorts.ShakerSort;
import Sorts.StoogeSort;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean bool = true;
        while (bool) {
            System.out.println();
            System.out.println("1. Random");
            System.out.println("2. Reverse sort.");
            System.out.println("3. Part sort.");
            System.out.println("4. Almost sort.");
            System.out.println("5. Quick sort.");
            System.out.println("6. Stooge sort.");
            System.out.println("7. Shaker sort.");
            System.out.println("8. Exit.");
            int number;
            do {
                System.out.println("Enter point:");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Enter point:");
                }
                number = scanner.nextInt();
            } while (number <= 0);
            switch (number) {
                case 1: {
                    fillingOutArray(arrayList, 1000);
                    show(arrayList);
                    System.out.println();
                    break;
                }
                case 2: {
                    fillingOutArray(arrayList, 1000);
                    ReverseQuickSorting reverseSorting = new ReverseQuickSorting();
                    reverseSorting.start(arrayList, 0, arrayList.size() - 1);
                    show(arrayList);
                    System.out.println();
                    break;
                }
                case 3: {
                    fillingOutArray(arrayList, 1000);
                    PartShakerSorting partShakerSorting = new PartShakerSorting();
                    partShakerSorting.start(arrayList, 100);
                    show(arrayList);
                    break;
                }
                case 4: {
                    fillingOutArray(arrayList, 1000);
                    AlmostSorting almostSorting = new AlmostSorting();
                    almostSorting.start(arrayList);
                    show(arrayList);
                    break;
                }
                case 5:{
                    Container<Integer> n = new Container<>(0);
                    QuickSort quickSort = new QuickSort();
                    quickSort.start(arrayList, 0, arrayList.size()-1, n);
                    show(arrayList);
                    System.out.println("\nКоличество шагов: " + n.getValue());
                    break;
                }
                case 6:{
                    Container<Integer> n = new Container<>(0);
                    StoogeSort stoogeSort = new StoogeSort();
                    stoogeSort.start(arrayList, 0, arrayList.size()-1, n);
                    show(arrayList);
                    System.out.println("\nКоличество шагов: " + n.getValue());
                    break;
                }
                case 7:{
                    Container<Integer> n = new Container<>(0);
                    ShakerSort shakerSort = new ShakerSort();
                    shakerSort.start(arrayList, n);
                    show(arrayList);
                    System.out.println("\nКоличество шагов: " + n.getValue());
                    break;
                }
                case 8: {
                    bool = false;
                    break;
                }
            }
        }
    }

    public static void fillingOutArray(ArrayList<Integer> arrayList, int quelque) {
        int n = 0;
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int number;
        boolean bool;
        integerArrayList.add((int)(Math.random()*9999));
        for (int i = 1; i < quelque; i++) {
            do{
                bool = false;
                number = (int) (Math.random() * 9999);
                n++;
                for (int j = 0; j < i; j++) {
                    if (integerArrayList.get(j) == number) bool = true;
                }
            }while (bool);
            integerArrayList.add(number);
        }
        arrayList.clear();
        arrayList.addAll(integerArrayList);
        System.out.println("Количество повторов: " + n);
    }

    public static void show(ArrayList arrayList) {
        System.out.println();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }
    }
}
