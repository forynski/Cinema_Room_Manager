package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each rows:");
        int seatsInEachRow = scanner.nextInt();

        int[][] myArray = new int[rows][seatsInEachRow];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < seatsInEachRow; j++)
                myArray[i][j] = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInEachRow; j++) {
                System.out.print(myArray[i][j]);
            }
            System.out.println();
        }
    }
}
