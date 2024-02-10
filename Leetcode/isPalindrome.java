package Leetcode;

import java.util.Scanner;

public class isPalindrome {

    public static boolean checkIsPalindrome(SLL<Integer> list1) {

        SLLNode<Integer> temp1 = list1.getFirst();
        SLLNode<Integer> temp2;
        SLL<Integer> tempList = new SLL<>();

        while(temp1 != null) {
            tempList.insertFirst(temp1.element);
            temp1 = temp1.succ;
        }

        temp1 = list1.getFirst();
        temp2 = tempList.getFirst();

        while(temp1 != null) {
            if(!temp1.element.equals(temp2.element)) {
                return false;
            }
            temp2 = temp2.succ;
            temp1 = temp1.succ;
        }
        return true;
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
        System.out.println(checkIsPalindrome(list1));
    }
}