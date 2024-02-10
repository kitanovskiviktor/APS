package Leetcode;

import java.util.Scanner;

public class removeNthFromEnd {

    public static void makeRemoveNthFromEnd(SLL<Integer> list, int n) {

        SLLNode<Integer> tempNode = list.getFirst();
        int diff = list.length() - n;
        int counter = 1;

        while(tempNode != null) {
            if(counter == diff && tempNode.succ != null) {
                list.delete(tempNode.succ);
            }
            else {
                list.delete(tempNode);
            }
            counter++;
            tempNode = tempNode.succ;
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
        makeRemoveNthFromEnd(list1, n);
    }
}