package Lesson3;

import Lesson2.AlmostSorting;
import Lesson2.Container;
import Lesson2.PartShakerSorting;
import Lesson2.ReverseQuickSorting;
import Sorts.*;

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
            System.out.println("5. Insertion sort.");
            System.out.println("6. Selection sort.");
            System.out.println("7. Double selection sort.");
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
                    Lesson2.Main.fillingOutArray(arrayList, 1000);
                    Lesson2.Main.show(arrayList);
                    System.out.println();
                    break;
                }
                case 2: {
                    Lesson2.Main.fillingOutArray(arrayList, 1000);
                    ReverseQuickSorting reverseSorting = new ReverseQuickSorting();
                    reverseSorting.start(arrayList, 0, arrayList.size() - 1);
                    Lesson2.Main.show(arrayList);
                    System.out.println();
                    break;
                }
                case 3: {
                    Lesson2.Main.fillingOutArray(arrayList, 1000);
                    PartShakerSorting partShakerSorting = new PartShakerSorting();
                    partShakerSorting.start(arrayList, 100);
                    Lesson2.Main.show(arrayList);
                    break;
                }
                case 4: {
                    Lesson2.Main.fillingOutArray(arrayList, 1000);
                    AlmostSorting almostSorting = new AlmostSorting();
                    almostSorting.start(arrayList);
                    Lesson2.Main.show(arrayList);
                    break;
                }
                case 5: {
                    Container<Integer> n = new Container<>(0);
                    InsertionSort insertionSort = new InsertionSort();
                    insertionSort.start(arrayList, n);
                    Lesson2.Main.show(arrayList);
                    System.out.println("\nКоличество шагов: " + n.getValue());
                    break;
                }
                case 6: {
                    Container<Integer> n = new Container<>(0);
                    SelectionSort selectionSort = new SelectionSort();
                    selectionSort.start(arrayList, n);
                    Lesson2.Main.show(arrayList);
                    System.out.println("\nКоличество шагов: " + n.getValue());
                    break;
                }
                case 7: {
                    Container<Integer> n = new Container<>(0);
                    DoubleSelectionSort doubleSelectionSort = new DoubleSelectionSort();
                    doubleSelectionSort.start(arrayList, n);
                    Lesson2.Main.show(arrayList);
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
}
