package Lists;


import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedRoster<Integer> linkedRoster = new LinkedRoster<>();
        Stack<Integer> stack = new Stack<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyDeque<Integer> myDeque = new MyDeque<>();
        while (true) {
            System.out.println("1. List.");
            System.out.println("2. Stack.");
            System.out.println("3. MyQueue.");
            System.out.println("4. Deque.");
            System.out.println("5. Exit.");
            int n = scanner.nextInt();
            boolean bool = true;
            switch (n) {
                case 1: {
                    while (bool) {
                        System.out.println("1. Insert.");
                        System.out.println("2. Delete.");
                        System.out.println("3. Show.");
                        System.out.println("4. Lookup.");
                        System.out.println("5. Prev.");
                        System.out.println("6. Next.");
                        System.out.println("7. Size.");
                        System.out.println("8. Exit.");
                        System.out.print("Select point: ");
                        int num = scanner.nextInt();
                        switch (num) {
                            case 1: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                System.out.println("Enter position: ");
                                int position = scanner.nextInt();
                                linkedRoster.insert(value, position);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter position: ");
                                int position = scanner.nextInt();
                                System.out.println(linkedRoster.delete(position));
                                break;
                            }
                            case 3: {
                                linkedRoster.show();
                                break;
                            }
                            case 4: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                linkedRoster.lookUp(value);
                                break;
                            }
                            case 5: {
                                System.out.println("Enter position: ");
                                int position = scanner.nextInt();
                                System.out.println("Prev: " + linkedRoster.prev(position));
                                break;
                            }
                            case 6: {
                                System.out.println("Enter position: ");
                                int position = scanner.nextInt();
                                System.out.println("Next: " + linkedRoster.next(position));
                                break;
                            }
                            case 7: {
                                linkedRoster.size();
                                break;
                            }
                            case 8: {
                                bool = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    while (bool) {
                        System.out.println("1. Push.");
                        System.out.println("2. Pop.");
                        System.out.println("3. Top.");
                        System.out.println("4. Show.");
                        System.out.println("5. Exit.");
                        System.out.print("Select point: ");
                        int num = scanner.nextInt();
                        switch (num) {
                            case 1: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                stack.push(value);
                                break;
                            }
                            case 2: {
                                System.out.println(stack.pop());
                                break;
                            }
                            case 3: {
                                System.out.println(stack.top());
                                break;
                            }
                            case 4: {
                                stack.show();
                                break;
                            }
                            case 5: {
                                bool = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    while (bool) {
                        System.out.println("1. Enqueue.");
                        System.out.println("2. Deque.");
                        System.out.println("3. Front.");
                        System.out.println("4. Show.");
                        System.out.println("5. Exit.");
                        System.out.print("Select point: ");
                        int num = scanner.nextInt();
                        switch (num) {
                            case 1: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                queue.enqueue(value);
                                break;
                            }
                            case 2: {
                                System.out.println(queue.deque());
                                break;
                            }
                            case 3: {
                                System.out.println(queue.front());
                                break;
                            }
                            case 4: {
                                queue.show();
                                break;
                            }
                            case 5: {
                                bool = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    while (bool) {
                        System.out.println("1. Push back.");
                        System.out.println("2. Push front.");
                        System.out.println("3. Pop back.");
                        System.out.println("4. Pop front.");
                        System.out.println("5. Back.");
                        System.out.println("6. Front.");
                        System.out.println("7. Front.");
                        System.out.println("8. Exit.");
                        System.out.print("Select point: ");
                        int num = scanner.nextInt();
                        switch (num) {
                            case 1: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                myDeque.pushBack(value);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter item: ");
                                int value = scanner.nextInt();
                                myDeque.pushFront(value);
                                break;
                            }
                            case 3: {
                                System.out.println(myDeque.popBack());
                                break;
                            }
                            case 4: {
                                System.out.println(myDeque.popFront());
                                break;
                            }
                            case 5: {
                                System.out.println(myDeque.back());
                                break;
                            }
                            case 6:{
                                System.out.println(myDeque.front());
                                break;
                            }
                            case 7:{
                                myDeque.show();
                                break;
                            }
                            case 8:{
                                bool = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }

            }
        }
    }
}
