import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluateTest {

    private String[][] cellData1, cellData2;
    private double[][] cellData1ans, cellData2ans;

    @Before
    public void setUp() throws Exception {
        cellData1 = new String[][]{
                {"A2", "4 5 *", "A1"},
                {"A1 B2 / 2 +", "3", "39 B1 B2 * /"}
        };

        cellData2 = new String[][]{
                {"2 3 *", "C3 C1 -", "C1 B1 -"},
                {"A1 B2 +", "7 1 -", "8 1 +"},
                {"A1 B3 +", "4 5 * 2 /", "6 2 -"}
        };

        cellData1ans = new double[][]{
                {20, 20, 20},
                {8.66667, 3.00000, 1.50000}
        };

        cellData2ans = new double[][]{
                {6, -11, 3},
                {12, 6, 9},
                {15, 10, 4}
        };

    }

    @Test
    public void TestEvaluateCell() {

        Evaluate evaluate = new Evaluate(cellData1);
        for (int i = 0; i < cellData1.length; i++) {
            for (int j = 0; j < cellData1[0].length; j++) {
                float val = evaluate.evaluateCell(i, j);
                assertEquals("Fail on " + i + " " + j ,String.format("%.5f", val), String.format("%.5f", cellData1ans[i][j]));
            }
        }
    }

    @Test
    public void TestEvaluateCell2() {

        Evaluate evaluate = new Evaluate(cellData2);
        for (int i = 0; i < cellData2.length; i++) {
            for (int j = 0; j < cellData2[0].length; j++) {
                float val = evaluate.evaluateCell(i, j);
                assertEquals("Fail on " + i + " " + j ,String.format("%.5f", val), String.format("%.5f", cellData2ans[i][j]));
            }
        }
    }
}