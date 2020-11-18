package Sieve_of_Eratosthenes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Eratosfen eratosfen = new Eratosfen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int a;
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        eratosfen.run(scanner.nextInt());
    }
}
