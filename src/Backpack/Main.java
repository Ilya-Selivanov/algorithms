package Backpack;

import Sorts.ShakerSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите объем рюкзака: ");
        ArrayList<Item> items = new ArrayList<>();
        int volume = scanner.nextInt();
        while (true) {
            System.out.println("1. Добавить предмет.");
            System.out.println("2. Заполнить рюкзак.");
            System.out.println("3. Выход.");
            int n;
            do {
                System.out.println("Enter point:");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Enter point:");
                }
                n = scanner.nextInt();
            } while (n <= 0);
            switch (n) {
                case 1: {
                    int coast, weight;
                    System.out.print("Введите ценнсоть: ");
                    coast = scanner.nextInt();
                    System.out.print("Введите вес: ");
                    weight = scanner.nextInt();
                    Item item = new Item(coast, weight);
                    items.add(item);
                    break;
                }
                case 2: {
                    for (int i = 0; i < items.size() - 1; i++) {
                        for (int j = 1; j < items.size(); j++) {
                            if (items.get(i).getValue() > items.get(j).getValue()) {
                                Collections.swap(items, i, j);
                            }
                        }
                    }
                    System.out.println("Оптимальный алгоритм: " + maxCoast(items, volume));
                    System.out.println("Жадный алгоритм: " + greedyMaxCoast(items, volume));
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Error.");
                    break;
                }
            }
        }
    }

    public static int maxCoast(ArrayList<Item> arrayList, int volume) {
        int n = arrayList.size();
        int dp[][] = new int[volume + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= volume; w++) {
                if (arrayList.get(j - 1).getWeight() <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - arrayList.get(j - 1).getWeight()][j - 1] + arrayList.get(j - 1).getCoast());
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }
//        ArrayList<Integer> answer = new ArrayList<>();
//        findItem(arrayList,dp, answer,volume,n);
        return dp[volume][n];
    }

    public static int greedyMaxCoast(ArrayList<Item> arrayList, int volume) {
        int v = volume;
        int sum = 0;
        ArrayList<Item> array = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (v <= 0) break;
            if (arrayList.get(i).getWeight() <= v) {
                v -= arrayList.get(i).getWeight();
                sum += arrayList.get(i).getCoast();
            }
        }
        return sum;
    }
//    public static void findItem(ArrayList<Item> arrayList, int[][] Db, ArrayList<Integer> answer, int k, int s){
//        if(Db[k][s] == 0) return;
//        if(Db[k-1][s] == Db[k][s]) findItem(arrayList, Db,answer,k-1,s);
//        else {
//            findItem(arrayList, Db, answer,k-1,s-arrayList.get(k).getWeight());
//            answer.add(k);
//        }
//    }

}
