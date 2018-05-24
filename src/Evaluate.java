/*
    Author: Ray Zhou
    E-mail: zhou.ray@gmail.com
    Spreadsheet challenge for Redmart
    14/02/2018
 */

import java.util.*;

public class Evaluate {

    private String[][] cellData;
    private HashMap<String, Float> cellAns = new HashMap<>();

    private ArrayDeque<Float> vals = new ArrayDeque<Float>();

    public Evaluate(String[][] inputArray){
        cellData = inputArray;
    }

    public Float evaluateCell(int row, int col){
       return evaluateCell(row, col, new HashSet<String>());
    }

    private Float evaluateCell(int row, int col, HashSet<String> visited){
        /*
            split cell by white space into ArrayList

            determine if input is
            1. another cell
            2. number (operand)
            3. operator

            a. if cell, check HashMap to see if evaluation already exist, else recursively search for a solution
            b. if number, look for next input
            c. if operator, apply operation to previous 2 numbers
        */

        if (visited.contains(HelperMethods.returnCellLabel(row,col + 1))){
            System.err.println("Error: cyclic dependencies in input data");
            System.exit(2);
        }

        ArrayList<String> content = new ArrayList<String>();

        content.addAll(Arrays.asList(cellData[row][col].split(" ")));

        visited.add(HelperMethods.returnCellLabel(row,col + 1));

        for (String element : content) {
            if (element.charAt(0) >= 'A' && element.charAt(0) <= 'Z') {
                if (cellAns.containsKey(element)) {
                    vals.addFirst(cellAns.get(element));
                } else {
                    vals.addFirst(evaluateCell(element.charAt(0) - 'A', Character.getNumericValue(element.charAt(1) - 1), visited));
                }

            } else if (element.charAt(0) == '+' || element.charAt(0) == '-' || element.charAt(0) == '*' || element.charAt(0) == '/') {

                // TODO: add default label to handle none of the below
                float v = vals.removeFirst();

                switch (element) {
                    case "+":
                        v = vals.removeFirst() + v;
                        break;
                    case "-":
                        v = vals.removeFirst() - v;
                        break;
                    case "*":
                        v = vals.removeFirst() * v;
                        break;
                    case "/":
                        v = vals.removeFirst() / v;
                        break;
                }

                vals.addFirst(v);

            } else{
                // TODO: check if number is valid or not

                vals.addFirst(Float.parseFloat(element));
            }

        }

        float ans = vals.removeFirst();
        cellAns.put(HelperMethods.returnCellLabel(row,col + 1), ans);

        return ans;
    }
}



