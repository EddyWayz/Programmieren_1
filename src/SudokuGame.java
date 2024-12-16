/**
 * Represents a Sudoku game with a 9x9 grid. The game allows inserting values and checking for conflicts.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class SudokuGame {
    private SudokuField[][] grid;
    private int numberOfStartValues;


    /**
     * Constructs a new Sudoku game with an empty 9x9 grid.
     * All fields are initially empty and mutable.
     */
    public SudokuGame() {
        grid = new SudokuField[9][9];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new SudokuField();
            }
        }
    }

    /**
     * Displays the current Sudoku grid on the console.
     * Empty fields are represented by ".".
     */
    public void showSudoku() {
        final String dividingLines = "-------------------------"; // Horizontal line for layout separation

        System.out.println(dividingLines); // Prints the top dividing line.

        // Prints the 9x9 Sudoku grid with vertical and horizontal separating lines.
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| "); // Starts the row with a vertical separator
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getValue() == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[i][j].getValue() + " "); // Prints the value.
                }
                if ((j + 1) % 3 == 0) {// Adds a vertical separator after every 3rd column
                    System.out.print("| ");
                }
            }
            if ((i + 1) % 3 == 0) {  // Adds a horizontal separator after every 3rd row
                System.out.print("\n" + dividingLines);
            }
            System.out.println();
        }
    }

    /**
     * Returns the number of initial values set in the Sudoku grid.
     *
     * @return The number of start values.
     */
    public int getNumberOfStartValues() {
        return numberOfStartValues;
    }

    /**
     * Sets a fixed initial value in the Sudoku grid.
     * Increases the count of start values if the entry is successful.
     *
     * @param row    The row (0-8) where the value is set.
     * @param col    The column (0-8) where the value is set.
     * @param number The fixed value (1-9) to set.
     */
    public void setStartValue(int row, int col, int number) {
        if (tryNumber(row, col, number)) {
            grid[row][col] = new SudokuField(number);
            numberOfStartValues++;
        }
    }

    /**
     * Inserts a number from 1 to 9 into the specified cell of the Sudoku grid.
     *
     * @param row The row (0-8) where the number will be inserted.
     * @param col The column (0-8) where the number will be inserted.
     * @param number The number (1-9) to insert.
     */
    public void insert(int row, int col, int number) {
        if (!correctInput(row, col, number)) {
            return;
        }
        grid[row][col].setValue(number);
    }

    /**
     * Checks whether the input for row, column, and number is valid.
     *
     * @param row The row in the Sudoku grid (0-8).
     * @param col The column in the Sudoku grid (0-8).
     * @param number The number to insert (1-9).
     * @return true if the input is valid; false otherwise.
     */
    private boolean correctInput(int row, int col, int number) {
        if ((row < 0) || (row > 8) || (col < 0) || (col > 8) || (number < 1) || (number > 9)) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Checks for a conflict in the specified row.
     *
     * @param row The row to check (0-8).
     * @param col The column where the number is located (0-8).
     * @return true if there is a conflict in the row; false otherwise.
     */
    private boolean conflictInRow(int row, int col) {
        if (!correctInput(row, col, grid[row][col].getValue())) {
            return false;
        } else if (grid[row][col].getValue() == 0) {
            return false;
        }

        int number = grid[row][col].getValue();
        for (int j = 0; j < grid[row].length; j++) {
            if ((grid[row][j].getValue() == number) && (j != col)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a conflict in the specified column.
     *
     * @param row The row where the number is located (0-8).
     * @param col The column to check (0-8).
     * @return true if there is a conflict in the column; false otherwise.
     */
    private boolean conflictInColumn(int row, int col) {
        if (!correctInput(row, col, grid[row][col].getValue())) {
            return false;
        } else if (grid[row][col].getValue() == 0) {
            return false;
        }

        int number = grid[row][col].getValue();
        for (int i = 0; i < grid.length; i++) {
            if ((grid[i][col].getValue() == number) && (i != row)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a conflict in the 3x3 square containing the specified cell.
     *
     * @param row The row (0-8).
     * @param col The column (0-8).
     * @return true if there is a conflict in the 3x3 square; false otherwise.
     */
    private boolean conflictInSquare(int row, int col) {
        if (correctInput(row, col, grid[row][col].getValue()) && grid[row][col].getValue() != 0) {
            int number = grid[row][col].getValue();

            // Determine the top-left corner of the 3x3 square.
            int tmpRow = row - (row % 3);
            int tmpCol = col - (col % 3);
            for (int i = tmpRow; i < tmpRow + 3; i++) {
                for (int j = tmpCol; j < tmpCol + 3; j++) {
                    if ((grid[i][j].getValue() == number) && (i != row) && (j != col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks the specified cell for any conflict in the row, column, or 3x3 square.
     *
     * @param row The row (0-8).
     * @param col The column (0-8).
     * @return true if there is any conflict; false otherwise.
     */
    private boolean anyConflict(int row, int col) {
        if (conflictInRow(row, col) || conflictInColumn(row, col) || conflictInSquare(row, col)) {
            return true;
        }
        return false;
    }


    /**
     * Attempts to insert a number into the specified cell and checks for conflicts.
     *
     * @param row  The row (0-8).
     * @param col  The column (0-8).
     * @param number The number (1-9) to insert.Q
     * @return true if the insertion was successful; false if a conflict was found.
     */
    public boolean tryNumber(int row, int col, int number) {
        if (!correctInput(row, col, number)) {
            return false;
        }
        if (grid[row][col].getValue() == 0) {
            insert(row, col, number); // Insert the value in the cell.
            if (anyConflict(row, col)) {
                grid[row][col].clear(); // Clears the cell if a conflict is found.
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
