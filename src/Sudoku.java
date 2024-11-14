/**
 * Die Klasse Sudoku erstellt ein loesbares Sudoku.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = new int[9][9];

        // Printet leeres Sudoku-Gitter.
        System.out.println("Leeres Sudoku: ");
        showSudoku(grid);

        // Befuellt Sudoku mit Werten eines echten Sudokus und gibt es auf der Konsole aus.
        insert(grid, 0, 1, 3);
        insert(grid, 0, 7, 7);
        insert(grid, 1, 3, 5);
        insert(grid, 1, 8, 8);
        insert(grid, 2, 4, 4);
        insert(grid, 3, 1, 5);
        insert(grid, 3, 4, 3);
        insert(grid, 4, 6, 9);
        insert(grid, 4, 8, 2);
        insert(grid, 5, 5, 7);
        insert(grid, 5, 3, 2);
        insert(grid, 6, 0, 1);
        insert(grid, 6, 2, 9);
        insert(grid, 6, 3, 2);
        insert(grid, 7, 0, 2);
        insert(grid, 7, 5, 6);
        insert(grid, 7, 6, 3);
        insert(grid, 8, 7, 4);
        insert(grid, 0, 0, 2);
        System.out.println("\nEin echtes, loesbares Sudoku: ");
        showSudoku(grid);
        System.out.println(isConflict(grid, 6, 0));
    }

    /**
     * Zeigt das uebergebene Gitter auf der Konsole aus.
     * Wagerechte Trennlinien sind ueber die Konstante dividingLines anpassbar.
     *
     * @param grid ist das auszugebende Gitter. (int[][])
     */
    static void showSudoku(int[][] grid) {
        final String dividingLines = "-------------------------";

        System.out.println(dividingLines); // oberen wagerechten Trennlinien.

        // Erstellt das 3*3 Sudoku Feld mit senkrechten und wagerechten Trennlinien.
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            if ((i + 1) % 3 == 0) {
                System.out.print("\n" + dividingLines);
            }
            System.out.println();
        }
    }

    static boolean correctInput(int row, int col, int num) {
        if ((row < 0) || (row > 8) || (col < 0) || (col > 8) || (num < 1) || (num > 9)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Diese Funktion schreibt eine Zahl von 1 bis 9 in ein bestimmtes Feld des Sudokus.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row  ist die Reihe, in die die Zahl eingeschrieben werden soll. (int)
     * @param col  ist die Spalte, in die die Zahl eingeschrieben werden soll. (int)
     * @param num  ist die einzuschreibende Zahl von 1 bis 9. (int)
     */
    static void insert(int[][] grid, int row, int col, int num) {
        if (!correctInput(row, col, num)) {
            return;
        }
        grid[row][col] = num;
    }

    /**
     * Diese Funktion prueft auf Konflikt in der Reihe der eingegeben Reihe.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row ist die zu ueberpruefenden Reihe. (int)
     * @param col ist die Spalte der Zahl steht, auf die die Reihe ueberprueft werden soll. (int)
     *            return true, wenn Konflikt in der Reihe ist. False, wenn kein Konflikt in der Reihe ist, wenn das Feld leer ist oder wenn Ungueltige Werte fuer row oder col eingegeben wurden. (boolean)
     */
    static boolean conflictInRow(int[][] grid, int row, int col) {
        if (!correctInput(row, col, grid[row][col])) {
            return false;
        }

        int number = grid[row][col];
        for (int i = 0; i < grid.length; i++) {
            if ((grid[i][col] == number) && (i != row)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Diese Funktion prueft auf Spaltenkonflikt der eingegeben Spalte.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row ist die Reihe der Zahl steht, auf die die Spalte ueberprueft werden soll. (int)
     * @param col ist die zu ueberpruefenden Spalte. (int)
     *            return true, wenn Konflikt in der Spalte ist. False, wenn kein Konflikt in der Spalte ist, wenn das Feld leer ist oder wenn Ungueltige Werte fuer row oder col eingegeben wurden. (boolean)
     */
    static boolean conflictInCol(int[][] grid, int row, int col) {
        if (!correctInput(row, col, grid[row][col])) {
            return false;
        }

        int number = grid[row][col];
        for (int i = 0; i < grid.length; i++) {
            if ((grid[row][i] == number) && (i != col)) {
                return true;
            }
        }
        return false;
    }


    static boolean conflictInSquare(int[][] grid, int row, int col) {
        if (correctInput(row, col, grid[row][col])) { // 1 als num, damit es nicht wegen der 0 im Array false ausgibt.
            int number = grid[row][col];

            // Ermittelt die Koordinaten des Feldes links oben von dem jeweiligen 3x3 Feld.
            int tmpRow = row - (row % 3);
            int tmpCol = col - (col % 3);
            for (int i = tmpRow; i < tmpRow + 3; i++) {
                for (int j = tmpCol; j < tmpCol + 3; j++) {
                    if ((grid[i][j] == number) && (i != row) && (j != col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Ueberprueft das uebergebene Feld(row, col) auf mindestens einen Konflikt.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row ist die Reihe des einzugebenen Feldes. (int)
     * @param col ist die Spalte des einzugebenen Feldes. (int)
     * @return true, wenn mindestens ein Reihen- oder Spaltenkonflikt besteht oder wenn das 3x3 Feld des eingegebenen Feldes einen Konflikt beinhaelt. Sonst false. (boolean)
     */
    static boolean isConflict(int[][] grid, int row, int col) {
        if (conflictInRow(grid, row, col) || conflictInCol(grid, row, col) || conflictInSquare(grid, row, col)) {
            return true;
        }
        return false;
    }
}