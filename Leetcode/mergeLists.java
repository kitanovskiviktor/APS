package Leetcode;

import java.util.Scanner;

/*

Midterm Exercise @ FSCE

Test case:
5 7 9
1 1 4 5 6 8 9 4
Output: 5 7 1 1 9 4 5 6 8 9 4

1 2 3 4 5 6 7
8 9 10 11
Output: 1 2 8 9 3 4 10 11 5 6 7

 */

public class mergeLists {


    public static void mergeTwoLists(SLL<Integer> list1, SLL<Integer> list2) {

        SLLNode<Integer> tempNode;
        SLL<Integer> newList = new SLL<>();

        while(list1.length() > 0 && list2.length() > 0) {

            tempNode = list1.getFirst();
            newList.insertLast(list1.delete(tempNode));
            if(list1.length() != 0) {
                newList.insertLast(list1.delete(tempNode.succ));
            }

            tempNode = list2.getFirst();
            newList.insertLast(list2.delete(tempNode));
            if(list2.length() != 0) {
                newList.insertLast(list2.delete(tempNode.succ));
            }
        }

        SLLNode<Integer> temp = list1.getFirst();
        while(temp != null) {
            newList.insertLast(temp.element);
            temp = temp.succ;
        }
        temp = list2.getFirst();
        while(temp != null) {
            newList.insertLast(temp.element);
            temp = temp.succ;
        }
        System.out.println(newList);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        SLL<Integer> list2 = new SLL<Integer>();
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list2.insertLast(scan.nextInt());
        }
        mergeTwoLists(list1, list2);
    }
}