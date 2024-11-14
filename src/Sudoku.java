/**
 * Die Klasse Sudoku erstellt ein lösbares Sudoku.
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

        // Befüllt Sudoku mit Werten eines echten Sudokus und gibt es auf der Konsole aus.
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
        System.out.println("\nEin echtes, lösbares Sudoku: ");
        showSudoku(grid);
        System.out.println(conflictInRow(grid, 5,3));
        System.out.println(conflictInCol(grid, 5,3));
        
    }

    /**
     * Zeigt das übergebene Gitter auf der Konsole aus.
     * Wagerechte Trennlinien sind über die Konstante dividingLines anpassbar.
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

    static boolean correctInput(int row, int col, int num){
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
    * Diese Funktion prüft auf Konflikt in der Reihe der eingegeben Reihe.
    *
    * @param ist das zweidimensionale Gitter des Sudokus. (int[][])
    * @param row ist die zu ueberpruefenden Reihe. (int)
    * @param col ist die Spalte der Zahl steht, auf die die Reihe überprueft werden soll. (int)
    * return true, wenn Konflikt in der Reihe ist. False, wenn kein Konflikt in der Rehe ist, wenn das Feld leer ist oder wenn Ungueltige Werte für row oder col eingegeben wurden. (boolean) 
    */
    static boolean conflictInRow(int[][] grid, int row, int col) {
            if(!correctInput(row, col, grid[row][col])){
                return false;
            }

        int number = grid[row][col];
        for(int i = 0; i<grid.length;i++){
            if((grid[i][col] == number) && (i != row)){
                return true; 
            }
        }
        return false; 
        }   


    /**
    * Diese Funktion prüft auf Spaltenkonflikt der eingegeben Spalte.
    *
    * @param ist das zweidimensionale Gitter des Sudokus. (int[][])
    * @param row ist die Reihe der Zahl steht, auf die die Spalte überprueft werden soll. (int)
    * @param col ist die zu ueberpruefenden Spalte. (int)
    * return true, wenn Konflikt in der Spalte ist. False, wenn kein Konflikt in der Spalte ist, wenn das Feld leer ist oder wenn Ungueltige Werte für row oder col eingegeben wurden. (boolean)
    */
    static boolean conflictInCol(int[][] grid, int row, int col) {
        if(!correctInput(row, col, grid[row][col])){
            return false;
        }

    int number = grid[row][col];
    for(int i = 0; i<grid.length;i++){
        if((grid[row][i] == number) && (i != col)){
            return true; 
        }
    }
    return false; 
    }

    static boolean conflictInSquare(int[][] grid, int row, int col){
        return true; 
    }
}