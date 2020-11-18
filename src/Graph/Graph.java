package Graph;

import Lists.MyQueue;
import sun.misc.Queue;

import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {
    private final int maxVertex = 6;
    private int [][] mas;
    private Vertex[] vertexList;
    private int quantityVertex;
    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public Vertex getVertexList(int i) {
        return vertexList[i];
    }

    public int getQuantityVertex() {
        return quantityVertex;
    }

    public Graph(){
        vertexList = new Vertex[maxVertex];
        mas = new int[maxVertex][maxVertex];
        quantityVertex = 0;
    }

    public void addVertex(String name){
        vertexList[quantityVertex] = new Vertex(name);
        quantityVertex++;
    }

    public void addEdge(int start, int end){
        mas[start][end] = 1;
    }

    public int check(int v){
        for(int i = 0; i < quantityVertex; i++){
            if(mas[v][i] == 1 && vertexList[i].getVisited() == false){
                return i;
            }
        }
        return -1;
    }

    public void dfs(int index){
        System.out.println(vertexList[index].getName());
        vertexList[index].setVisited(true);
        stack.push(index);
        while (!stack.empty()){
            int neigh = check(stack.peek());
            if (neigh == -1){
                neigh = stack.pop();
            }else {
                System.out.println(vertexList[neigh].getName());
                vertexList[neigh].setVisited(true);
                stack.push(neigh);
            }
        }

        for (int i = 0; i < quantityVertex; i++){
            vertexList[i].setVisited(false);
        }
    }

    public void bfs(int index){
        System.out.println(vertexList[index].getName());
        vertexList[index].setVisited(true);
        queue.add(index);
        int vertex;
        while (!queue.isEmpty()){
           int temp = queue.remove();
           while ((vertex = check(temp)) != -1){
               System.out.println(vertexList[vertex].getName());
               vertexList[vertex].setVisited(true);
               queue.add(vertex);
           }
        }

        for (int i = 0; i < quantityVertex; i++){
            vertexList[i].setVisited(false);
        }
    }

    public void adjacencyList(){
        int k = 0;
        for(int i = 0; i < maxVertex; i++){
            k = 0;
            System.out.print(vertexList[i].getName()+": ");
            for (int j = 0; j < maxVertex; j++){
                if(mas[i][j] == 1){
                    if(k == 0){
                        System.out.print(vertexList[j].getName());
                        k++;
                    }
                    else  System.out.print(", " + vertexList[j].getName());
                }
            }
            System.out.print(" | ");
        }
        System.out.println();
    }

    public void adjacencyMatrix(){
        for (int i = 0; i < maxVertex; i++){
            System.out.print("\t" + vertexList[i].getName());
        }
        System.out.println();
        for (int i = 0; i < maxVertex; i++){
            System.out.print(vertexList[i].getName() + "\t");
            for (int j = 0; j < maxVertex; j++){
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
