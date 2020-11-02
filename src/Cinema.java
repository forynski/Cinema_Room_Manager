package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each rows:");
        int seatsInEachRow = scanner.nextInt();

        int seats = rows * seatsInEachRow;
        int income = 0;

        if (seats <= 60) {
            income = seats * 10;
        } else if (seats > 60 && rows % 2 == 0) {
            income = (seats / 2) * 10 + (seats / 2) * 8;
        } else if (seats > 60 && rows % 2 == 1) {
            int frontRows = (rows - 1) / 2;
            int backRows = (rows + 1) / 2;
            income = frontRows * seatsInEachRow * 10 + backRows * seatsInEachRow * 8;
        }
        System.out.println("Total income:" + "\n" + "$" + income);
    }
}
