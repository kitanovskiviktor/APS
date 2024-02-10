package Leetcode;

import java.util.Scanner;

public class rotateRight {


    public static SLLNode<Integer> findLastNode(SLL<Integer> list) {

        SLLNode<Integer> tempNode = list.getFirst();
        while(tempNode.succ != null) {
            tempNode = tempNode.succ;
        }
        return tempNode;
    }

    public static void makeRotateRight(SLL<Integer> list, int n) {

        SLLNode<Integer> tempNode;

        for(int i = 0; i < n; i++) {
            tempNode = findLastNode(list);
            list.delete(findLastNode(list));
            list.insertFirst(tempNode.element);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        int n;
        n = scan.nextInt();
        makeRotateRight(list1, n);
    }
}