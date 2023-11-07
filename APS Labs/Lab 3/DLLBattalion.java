package com.example.lab3_zadaca3;
import java.util.Scanner;

class DLLNode<E> {
    protected E element;
    protected com.example.lab3_zadaca3.DLLNode<E> pred, succ;
    public DLLNode(E elem, com.example.lab3_zadaca3.DLLNode<E> pred, com.example.lab3_zadaca3.DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class DLL<E> {
    private com.example.lab3_zadaca3.DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void insertFirst(E o) {
        com.example.lab3_zadaca3.DLLNode<E> ins = new com.example.lab3_zadaca3.DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            com.example.lab3_zadaca3.DLLNode<E> ins = new com.example.lab3_zadaca3.DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, com.example.lab3_zadaca3.DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        com.example.lab3_zadaca3.DLLNode<E> ins = new com.example.lab3_zadaca3.DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, com.example.lab3_zadaca3.DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        com.example.lab3_zadaca3.DLLNode<E> ins = new com.example.lab3_zadaca3.DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            com.example.lab3_zadaca3.DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                com.example.lab3_zadaca3.DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        } else
            return null;
    }

    public E delete(com.example.lab3_zadaca3.DLLNode<E> node) {
        if (node == first) {
            return deleteFirst();
        }
        if (node == last) {
            return deleteLast();
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    public com.example.lab3_zadaca3.DLLNode<E> find(E o) {
        if (first != null) {
            com.example.lab3_zadaca3.DLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int getSize() {
        int listSize = 0;
        com.example.lab3_zadaca3.DLLNode<E> tmp = first;
        while(tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            com.example.lab3_zadaca3.DLLNode<E> tmp = first;
            ret += tmp.toString();
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            com.example.lab3_zadaca3.DLLNode<E> tmp = last;
            ret += tmp.toString();
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += "<->" + tmp.toString();
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public com.example.lab3_zadaca3.DLLNode<E> getFirst() {
        return first;
    }

    public com.example.lab3_zadaca3.DLLNode<E> getLast() {

        return last;
    }

    public void setFirst(com.example.lab3_zadaca3.DLLNode<E> node) {
        this.first = node;
    }

    public void setLast(com.example.lab3_zadaca3.DLLNode<E> node) {
        this.last = node;
    }

    public void mirror() {

        com.example.lab3_zadaca3.DLLNode<E> tmp = null;
        com.example.lab3_zadaca3.DLLNode<E> current = first;
        last = first;
        while(current!=null) {
            tmp = current.pred;
            current.pred = current.succ;
            current.succ = tmp;
            current = current.pred;
        }

        if(tmp!=null && tmp.pred!=null) {
            first=tmp.pred;
        }
    }
}

public class DLLBattalion {

    //TODO: implement function
    public static void battalion(com.example.lab3_zadaca3.DLL<Integer> list, int a, int b) {

        com.example.lab3_zadaca3.DLLNode<Integer> tempNode = list.getFirst();
        com.example.lab3_zadaca3.DLLNode<Integer> endNode = null;
        com.example.lab3_zadaca3.DLLNode<Integer> startNode = null;
        int counter = 0;
        if(list.getFirst().element.equals(a) && list.getLast().element.equals(b)) {
            list.mirror();
            return;
        }
        while(tempNode != null) {
            if(counter !=0 && !tempNode.element.equals(b)) {
                counter++;
            }
            if(tempNode.element.equals(a)) {
                startNode = tempNode;
                counter++;
            }
            if(tempNode.element.equals(b)) {
                endNode = tempNode;
                counter++;
                break;
            }
            tempNode = tempNode.succ;
        }

        while(counter > 1) {
            tempNode = endNode;
            com.example.lab3_zadaca3.DLLNode<Integer> tNode = tempNode.pred;
            list.delete(endNode);
            list.insertBefore(tempNode.element, startNode);
            endNode = tNode;
            counter--;
        }

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        com.example.lab3_zadaca3.DLL<Integer> list = new com.example.lab3_zadaca3.DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        battalion(list, a, b);

        System.out.println(list);
        System.out.println(list.toStringR());


    }
}
