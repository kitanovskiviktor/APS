package Lab1;
/*
For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence.
Print the transformed array to standard output.
*/

import java.util.Scanner;

public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        int[] krajnaNiza = new int[n];
        int j = 0;
        for(int i = 0; i<n; i++) {
            if(arr[i] == 0) {
                krajnaNiza[j] = arr[i];
                j++;
            }
        }
        for(int i = 0; i<n; i++) {
            if(arr[i] != 0) {
                krajnaNiza[j] = arr[i];
                j++;
            }
        }
        System.out.println("Transformiranata niza e:");
        for(int i = 0; i<n; i++) {
            System.out.print(krajnaNiza[i] + " ");
        }
    }

    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int brojka = scanner.nextInt();
        int [] niza = new int[brojka];

        for(int i = 0; i<brojka; i++) {
            niza[i] = scanner.nextInt();
        }
        scanner.close();
        pushZerosToBeginning(niza, brojka);
    }
}
