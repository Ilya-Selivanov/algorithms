package ExchangeTask;

import Lesson2.Container;
import Sorts.InsertionSort;
import Sorts.QuickSort;
import Sorts.ShakerSort;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList<>();
        int sum;
        do {
            System.out.println("Enter scrip: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            sum = scanner.nextInt();
        } while (sum < 0);
        boolean bool = true;
        System.out.println("Enter nominal.");
        scanner.nextLine();
        String string = scanner.nextLine();
        String number = "";
        for(int i = 0; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i))){
                number += string.charAt(i);
            }
            else if(!number.isEmpty()){
                coins.add(Integer.parseInt(number));
                System.out.println(Integer.parseInt(number));
                number = "";
            }
        }
        if(!number.isEmpty()) coins.add(Integer.parseInt(number));
        Container<Integer> n = new Container<>(0);
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.start(coins, n);
        for(int i = 0; i < coins.size(); i++){
            System.out.print("\t" + coins.get(i));
        }
        System.out.println();
        int[] ints = new int[sum + 1];
        int[] certificate = new int[sum + 1];
        greedyMinCoins(coins, sum);
        System.out.println();
        minCoins(coins, ints, certificate, sum);
    }

    public static void minCoins(ArrayList<Integer> coins, int[] s, int[] certificate, int sum) {
        s[0] = 0;
        for (int i = 1; i <= sum; i++) {
            s[i] = sum + 1;
            for (int j = 0; j < coins.size(); j++) {
                if (i - coins.get(j) >= 0 && s[i - coins.get(j)] + 1 < s[i]) {
                    s[i] = s[i - coins.get(j)] + 1;
                    certificate[i] = coins.get(j);
                }
            }
        }
        System.out.print("Оптимальный вариант: ");
        if(s[sum] >= sum) System.out.print("Не удалось розменять.");
        else {
            recout(sum, certificate);
            System.out.print(" " + s[sum] + " - всего монет.");
        }
    }

    public static void greedyMinCoins(ArrayList<Integer> arrayList, int sum){
        int s = sum;
        ArrayList<Integer> coins = new ArrayList<>();
        for(int i = arrayList.size() - 1; i >= 0; i--){
            if(s <= 0) break;
            while (arrayList.get(i) <= s){
                s -= arrayList.get(i);
                coins.add(arrayList.get(i));
            }
        }
        System.out.print("Жадный алгоритм: ");
        if(s != 0) System.out.print("Не удалось розменять.");
        else{
            for(int i = 0; i < coins.size(); i++){
                System.out.print(coins.get(i));
                if(i != coins.size()-1) System.out.print("+");
            }
            System.out.println(" " + coins.size() + " - всего монет.");
        }
    }

    public static void recout(int i, int[] p) {
        if (i == 0) return;
        recout(i - p[i], p);
        if (i - p[i] > 0) System.out.print("+");
        System.out.print(p[i]);
    }
}
