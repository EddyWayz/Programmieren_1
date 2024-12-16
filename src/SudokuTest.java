/**
 * A test class for the {@link SudokuGame} class.
 * It demonstrates setting fixed values, attempting to insert numbers,
 * and printing the Sudoku grid.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class SudokuTest {
    /**
     * The main method to run the Sudoku game test.
     * It sets initial values, tries to insert numbers into each cell,
     * and displays the resulting Sudoku grid.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        /** Create a new Sudoku game instance. */
        SudokuGame sudoku = new SudokuGame();

        sudoku.setStartValue(0,0,9);
        sudoku.setStartValue(0,1,7);
        sudoku.setStartValue(0,2,5);
        sudoku.setStartValue(0,3,3);
        sudoku.setStartValue(0,4,1);

        // Attempt to insert a value into a fixed field to check immutability.
        sudoku.insert(0,0,4); // Should not change the fixed value.

        // Attempt to insert the lowest value into every field from the top-left corner to the bottom-right corner.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int zahl = 0;    // Initialize with 0 so the loop starts correctly.
                boolean success;

                do {
                    zahl++;
                    success = sudoku.tryNumber(row, col, zahl);
                } while (!success && zahl <= 9);
            }
        }
        sudoku.showSudoku();
    }
}
