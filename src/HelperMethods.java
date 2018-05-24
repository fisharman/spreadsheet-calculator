/*
    Author: Ray Zhou
    E-mail: zhou.ray@gmail.com
    Spreadsheet challenge for Redmart
    14/02/2018
 */

public class HelperMethods {

    public static String returnCellLabel(int row, int col){
        StringBuilder key = new StringBuilder();
        key.append((char) ('A' + row));
        key.append(col);
        return key.toString();
    }
}
