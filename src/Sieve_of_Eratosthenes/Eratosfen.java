package Sieve_of_Eratosthenes;

public class Eratosfen {
    boolean bool = false;

    public void run(int anInt) {
        for (int i = 2; i < anInt; i++)
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    break;
                else if (i == j + 1)
                    System.out.println(i);
            }
    }
}
