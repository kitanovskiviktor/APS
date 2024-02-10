package Leetcode;

import java.util.Scanner;

public class mergeNodes {

    public static void makeMergeNodes(SLL<Integer> list1) {

        SLLNode<Integer> tempNode = list1.getFirst();
        SLL<Integer> tempList = new SLL<>();
        int sum = 0;
        tempNode = tempNode.succ;
        while(tempNode != null) {
            if(tempNode.element.equals(0)) {
                tempList.insertLast(sum);
                sum = 0;
            }
            else {
                sum += tempNode.element;
            }
            tempNode = tempNode.succ;
        }
        System.out.println(tempList);
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
        makeMergeNodes(list1);
    }
}