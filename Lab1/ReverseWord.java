package Lab1;
/*
For a given word entered from standard input, print it reversed. On input in the first line, the number of words that will be entered is given.
In the following lines, the words are entered.
*/
import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        StringBuilder obratno = new StringBuilder(word);
        obratno.reverse();
        System.out.println(obratno);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int brojZborovi = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i<brojZborovi; i++){
            String zbor = scanner.nextLine();
            printReversed(zbor);
        }
    }
}