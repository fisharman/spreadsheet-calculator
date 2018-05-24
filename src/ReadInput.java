/*
    Author: Ray Zhou
    E-mail: zhou.ray@gmail.com
    Spreadsheet challenge for Redmart
    14/02/2018
 */

import java.util.Scanner;

public class ReadInput {

    public static String[][] readCell(){
        Scanner input = new Scanner(System.in);

        try {
            int n = input.nextInt();
            int m = input.nextInt();
            input.nextLine();

            String[][] cellData = new String[m][n];

            // create array list of strings to store input in grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cellData[i][j] = input.nextLine();
                }
            }

            return cellData;
        }
        catch (Exception e){
            // Simple exception handling...
            System.err.print("Error: invalid input");
        }

        return null;

    }
}
