/*
    Author: Ray Zhou
    E-mail: zhou.ray@gmail.com
    Spreadsheet challenge for Redmart
    14/02/2018
 */

public class Spreadsheet {
    public static void main(String[] args) {

        String[][] cellData = ReadInput.readCell();
        if (cellData != null) {

            Evaluate evaluate = new Evaluate(cellData);

            // print m n
            System.out.println(cellData.length + " " + cellData[0].length);


            for (int i = 0; i < cellData.length; i++) {
                for (int j = 0; j < cellData[0].length; j++) {
                    float val = evaluate.evaluateCell(i, j);
                    System.out.println(String.format("%.5f", val));
                }
            }

        } else {
            System.exit(1);
        }
    }
}