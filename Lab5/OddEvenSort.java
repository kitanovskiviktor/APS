package Lab5;

/*
Given a sequence of N natural numbers. It is necessary to sort the sequence so that in the first part of the sequence the odd numbers from it will be sorted in ascending order, and in the second part the even numbers will be sorted in descending order.

In the first line of the input, the number of elements in the array N is given, and in the second line, the numbers are given. The output should print the sorted array.

Class Name: OddEvenSort
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    private static void bubbleSort(int[] arr, boolean ascending, int dolzina) {
        int n = dolzina;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && arr[j] >= arr[j + 1]) || (!ascending && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void oddEvenSort(int a[], int n)
    {
        // Vasiot kod tuka

        int [] neparniNiza = new int[n];
        int [] parniNiza = new int[n];

        int neparniCnt = 0;
        int parniCnt = 0;

        for(int i = 0; i<n; i++) {
            if(a[i] % 2 == 0) {
                parniNiza[parniCnt++] = a[i];
            }
            else {
                neparniNiza[neparniCnt++] = a[i];
            }
        }

        bubbleSort(neparniNiza, true, neparniCnt);
        bubbleSort(parniNiza, false, parniCnt);

        for(int i=0; i<neparniCnt; i++) {
            a[i] = neparniNiza[i];
        }

        int j = 0;
        for(int i=neparniCnt; i<n; i++) {
            a[i] = parniNiza[j++];
        }

    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}
