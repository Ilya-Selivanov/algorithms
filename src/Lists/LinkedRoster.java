package Lists;

import Backpack.Item;

public class LinkedRoster<Type> {
    private Node<Type> lastNode;
    private Node<Type> firstNode;
    private int size = 0;

    private class Node<Type> {
        private Type item;
        private Node<Type> next;
        private Node<Type> prev;

        Node(Type item, Node<Type> next, Node<Type> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public Type getItem() {
            return item;
        }

        public void setItem(Type item) {
            this.item = item;
        }

        public Node<Type> getNext() {
            return next;
        }

        public void setNext(Node<Type> next) {
            this.next = next;
        }

        public Node<Type> getPrev() {
            return prev;
        }

        public void setPrev(Node<Type> prev) {
            this.prev = prev;
        }
    }

    public void insert(Type item, int position) {
        if (size == 0) {
            Node<Type> node = new Node<>(item, null, null);
            firstNode = lastNode = node;
            size++;
        } else if (position > size - 1) {
            Node<Type> node = new Node<>(item, null, lastNode);
            lastNode.next = node;
            lastNode = node;
            size++;
        } else if (position == 0) {
            Node<Type> node = new Node<>(item, firstNode, null);
            firstNode.prev = node;
            firstNode = node;
            size++;
        } else {
            if (position <= size / 2) {
                Node p = firstNode;
                for (int i = 0; i < position; i++) {
                    p = p.next;
                }
                Node<Type> node = new Node(item, p, p.prev);
                p.prev.next = node;
                p.prev = node;
                size++;
            } else if (position > size / 2) {
                Node p = lastNode;
                for (int i = size - 1; i > position; i--) {
                    p = p.prev;
                    System.out.println(p.item);
                    System.out.println("S = " + size);
                }
                Node<Type> node = new Node(item, p, p.prev);
                p.prev.next = node;
                p.prev = node;
                size++;
            }
        }
    }

    public Type delete(int position) {
        if (size == 0) {
            System.out.println("List is empty!");
            return null;
        }
        Node result = null;
        if (position > size) {
            System.out.println("Item does not exist.");
        }else if(size == 1){
            result = firstNode;
            firstNode = lastNode = null;
            size--;
        }else if (position == 0) {
                result = firstNode;
                firstNode = firstNode.next;
                firstNode.prev = null;
                size--;
        } else if (position > size) {
            System.out.println("Item does not exist.");
        } else if (position == size - 1) {
            result = lastNode;
            lastNode.prev.next = null;
            lastNode = lastNode.prev;
            size--;
        } else {
            if (position <= size / 2) {
                Node p = firstNode;
                for (int i = 0; i < position; i++) {
                    p = p.next;
                }
                result = p;
                Node copy = p.prev;
                p.prev.next = p.next;
                p.next.prev = copy;
                size--;
            }
            if (position > size / 2) {
                Node p = lastNode;
                for (int i = size - 1; i > position; i--) {
                    p = p.prev;
                }
                result = p;
                Node copy = p.prev;
                p.prev.next = p.next;
                p.next.prev = copy;
                size--;
            }
        }
        return (Type)result.item;
    }

    public void lookUp(int value) {
        if (size == 0) {
            System.out.println("List is empty!");
            return;
        } else {
            Node p = firstNode;
            do {
                if (p.item.equals(value)) {
                    System.out.println("Item: " + p.item);
                    System.out.println("Next: " + p.next.item);
                    System.out.println("Prev: " + p.prev.item);
                }
                p = p.next;
            } while (p != null);
        }
    }

    public Type get(int position){
        if (size == 0) {
            System.out.println("List is empty!");
            return null;
        }

        Node p = null;
        if (position <= size / 2) {
            p = firstNode;
            for (int i = 0; i < position; i++) {
                p = p.next;
            }
        } else if (position > size / 2) {
            p = lastNode;
            for (int i = size - 1; i > position; i--) {
                p = p.prev;
            }
        }
        return (Type) p.item;
    }

    public Type prev(int position) {
        if (size == 0) {
            System.out.println("List is empty!");
            return null;
        }
        if (position == 0) return null;
        Node p = null;
        if (position <= size / 2) {
            p = firstNode;
            for (int i = 0; i < position; i++) {
                p = p.next;
            }
        } else if (position > size / 2) {
            p = lastNode;
            for (int i = size - 1; i > position; i--) {
                p = p.prev;
            }
        }
        return (Type) p.prev.item;
    }

    public Type next(int position) {
        if (size == 0) {
            System.out.println("List is empty!");
            return null;
        }
        if(position == size-1) return null;
        Node p = null;
        if (position <= size / 2) {
            p = firstNode;
            for (int i = 0; i < position; i++) {
                p = p.next;
            }
        } else if (position > size / 2) {
            p = lastNode;
            for (int i = size - 1; i > position; i--) {
                p = p.prev;
            }
        }
        return (Type) p.next.item;
    }

    public int size(){
        return size;
    }

    public void show() {
        if (size == 0) {
            System.out.println("list is empty.");
            return;
        }
        Node p = firstNode;
        do {
            System.out.print(p.item + "\t");
            p = p.next;
        } while (p != null);
        System.out.println();
    }

}
