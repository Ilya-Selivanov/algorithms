package Graph;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();
        graph.addVertex("A"); //0
        graph.addVertex("B"); //1
        graph.addVertex("C"); //2
        graph.addVertex("D"); //3
        graph.addVertex("E"); //4
        graph.addVertex("F"); //5
        graph.addEdge(0,1); //AB
        graph.addEdge(1,2); //BC
        graph.addEdge(2,3); //CD
        graph.addEdge(0,4); //AE
        graph.addEdge(0,5); //AF
        while (true) {
            System.out.println("1. BFS.");
            System.out.println("2. DFS.");
            System.out.println("3. Список смежности.");
            System.out.println("4. Матрица смежности.");
            System.out.println("5. Выход.");
            int n = scanner.nextInt();
            switch (n){
                case 1:{
                    graph.bfs(0);
                    break;
                }
                case 2:{
                    graph.dfs(0);
                    break;
                }
                case 3:{
                    graph.adjacencyList();
                    break;
                }
                case 4:{
                    graph.adjacencyMatrix();
                    break;
                }
                case 5:{
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
