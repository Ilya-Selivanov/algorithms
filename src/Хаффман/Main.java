package Хаффман;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    class Node implements Comparable<Node>{
        final int sum;
        String code;

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }

        void buildCode(String code){
            this.code = code;
        }
    }
    class InternalNode extends  Node{
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class  LeafNode extends Node{
        char symbol;

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String line = scanner.next();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c) + 1);
            }else {
                hashMap.put(c,1);
            }
        }
        for (Map.Entry<Character, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Map<Character, Node> charNode = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNode.put(entry.getKey(), node);
            priorityQueue.add(node);
        }
        int sum = 0;
        while (priorityQueue.size() > 1){
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if(hashMap.size() == 1){
            sum = line.length();
        }
        System.out.println(hashMap.size() + " "+sum);
        Node root  = priorityQueue.poll();
        if(hashMap.size() == 1){
            root.code = "0";
        }
        else {
            root.buildCode("");
        }
        String result = "";
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            result += charNode.get(c).code;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
