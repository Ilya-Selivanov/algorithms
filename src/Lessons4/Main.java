package Lessons4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        System.out.println("Введите суму: ");
        int S, num;
        do {
            System.out.println("Enter point:");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Enter point:");
            }
            S = scanner.nextInt();
        } while (S <= 0);
        System.out.println(S);
        System.out.println("Введите номиналы монет: ");

    }
}
