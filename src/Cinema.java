package cinema;

import java.util.Arrays;

public class Cinema {

    public static void main(String[] args) {
        String[][] myArray = {
                {"Cinema:"},
                {" ", "1", "2", "3", "4", "5", "6", "7", "8"},
                {"1", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"2", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"3", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"4", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"5", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"6", "S", "S", "S", "S", "S", "S", "S", "S"},
                {"7", "S", "S", "S", "S", "S", "S", "S", "S"}
        };

        for (int i = 0; i < myArray.length; i++)
            System.out.println(Arrays.toString(myArray[i])
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
    }
}
