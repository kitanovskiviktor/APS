package Leetcode;

import java.util.Scanner;

public class deleteDuplicates {

    public static void makeDeleteDuplicates(SLL<Integer> list1) {

        SLLNode<Integer> temp1 = list1.getFirst();
        SLLNode<Integer> temp2;

        while(temp1 != null) {

            temp2 = temp1.succ;
            while(temp2 != null) {
                if(temp1.element.equals(temp2.element)) {
                    list1.delete(temp2);
                }
                temp2 = temp2.succ;
            }
            temp1 = temp1.succ;
        }

        System.out.println(list1);
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
        makeDeleteDuplicates(list1);
    }
}