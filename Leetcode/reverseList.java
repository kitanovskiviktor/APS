package Leetcode;

import java.util.Scanner;

public class reverseList {

    public static void makeReverseList(SLL<Integer> list1) {

        SLLNode<Integer> temp1 = list1.getFirst();
        SLL<Integer> reversedList = new SLL<>();

        while(temp1 != null) {
            reversedList.insertFirst(temp1.element);
            temp1 = temp1.succ;
        }

        System.out.println(reversedList);
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
        makeReverseList(list1);
    }
}