/**
 * Die Klasse Sudoku erstellt ein gefuelltes Sudoku-Feld.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = new int[9][9]; // Erstellt ein leeres 9x9 Sudoku-Gitter.

        // Printet leeres Sudoku-Gitter.
        System.out.println("Leeres Sudoku: ");
        showSudoku(grid);

        for (int i = 0; i < grid.length; i++) { // Schleife durch die Reihen des Gitters
            for (int j = 0; j < grid.length; j++) { // Schleife durch die Spalten des Gitters
                int count = 1; // Einzutragende Zahl, beginnend bei 1
                // Schreibt Zahl von 1 bis 9 ins Feld, sofern es moeglich ist.
                while(grid[i][j] == 0 && count <= 9){
                    tryNumber(grid, i,j, count); // Versucht, die Zahl einzutragen.
                    count++; // Erhoeht die Zahl und versucht es erneut, falls notwendig.
                }
            }
        }

        System.out.println("Unvollstaendiges, aber konfliktfreies Sudoku:");
        showSudoku(grid); // Gibt das resultierende Sudoku aus.
    }

    /**
     * Gibt das uebergebene Gitter auf der Konsole aus.
     * Wagerechte Trennlinien sind ueber die Konstante dividingLines anpassbar.
     *
     * @param grid ist das auszugebende Gitter. (int[][])
     */
    static void showSudoku(int[][] grid) {
        final String dividingLines = "-------------------------"; // Trennlinie fuer das Layout

        System.out.println(dividingLines); // Zeigt die obere Trennlinie an.

        // Erstellt das 3x3 Sudoku Feld mit senkrechten und waagerechten Trennlinien.
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| "); // Beginn der Reihe mit senkrechter Trennlinie
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(". "); // Zeigt "." an, wenn das Feld leer ist.
                } else {
                    System.out.print(grid[i][j] + " "); // Zeigt die Zahl an.
                }
                if ((j + 1) % 3 == 0) { // Jede 3. Spalte bekommt eine zusaetzliche senkrechte Trennlinie
                    System.out.print("| ");
                }
            }
            if ((i + 1) % 3 == 0) { // Jede 3. Reihe bekommt eine zusaetzliche waagerechte Trennlinie
                System.out.print("\n" + dividingLines);
            }
            System.out.println();
        }
    }

    /**
     * ueberprueft, ob die Eingabe fuer Reihe, Spalte und Zahl korrekt ist.
     *
     * @param row Die Reihe im Sudoku (0-8).
     * @param col Die Spalte im Sudoku (0-8).
     * @param num Die einzutragende Zahl (1-9).
     * @return true, wenn die Eingabe korrekt ist; false, wenn nicht.
     */
    static boolean correctInput(int row, int col, int num) {
        if ((row < 0) || (row > 8) || (col < 0) || (col > 8) || (num < 1) || (num > 9)) {
            return false; // Gibt false zurueck, wenn die Eingaben ungueltig sind.
        } else {
            return true; // Gibt true zurueck, wenn die Eingaben gueltig sind.
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
            return; // Beendet die Methode, wenn die Eingabe ungueltig ist.
        }
        grid[row][col] = num; // Setzt die Zahl in das entsprechende Feld.
    }

    /**
     * Diese Funktion prueft auf Konflikt in der Reihe der eingegebenen Reihe.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row  ist die zu ueberpruefende Reihe. (int)
     * @param col  ist die Spalte, in der die zu ueberpruefende Zahl steht. (int)
     * @return true, wenn Konflikt in der Reihe ist; false, wenn nicht.
     */
    static boolean conflictInRow(int[][] grid, int row, int col) {
        if (!correctInput(row, col, grid[row][col])) {
            return false; // Gibt false zurueck, wenn die Eingabe ungueltig ist.
        } else if(grid[row][col] == 0) {
            return false;
        }

        int number = grid[row][col]; // Speichert die Zahl, die ueberprueft wird.
        for (int j = 0; j < grid[row].length; j++) {
            if ((grid[row][j] == number) && (j != col)) {
                return true; // Gibt true zurueck, wenn ein Konflikt in der Reihe gefunden wird.
            }
        }
        return false; // Gibt false zurueck, wenn kein Konflikt in der Reihe gefunden wird.
    }

    /**
     * Diese Funktion prueft auf Spaltenkonflikt in der angegebenen Spalte.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row  ist die Reihe, in der die zu ueberpruefende Zahl steht. (int)
     * @param col  ist die zu ueberpruefende Spalte. (int)
     * @return true, wenn ein Konflikt in der Spalte vorliegt; false, wenn nicht.
     */
    static boolean conflictInColumn(int[][] grid, int row, int col) {
        if (!correctInput(row, col, grid[row][col])) {
            return false; // Gibt false zurueck, wenn die Eingabe ungueltig ist.
        } else if(grid[row][col] == 0) {
            return false;
        }

        int number = grid[row][col]; // Speichert die Zahl, die ueberprueft wird.
        for (int i = 0; i < grid.length; i++) {
            if ((grid[i][col] == number) && (i != row)) {
                return true; // Gibt true zurueck, wenn ein Konflikt in der Spalte gefunden wird.
            }
        }
        return false; // Gibt false zurueck, wenn kein Konflikt in der Spalte gefunden wird.
    }

    /**
     * ueberprueft das uebergebene Feld auf Konflikt im 3x3-Quadrat.
     *
     * @param grid ist das 9x9 Sudoku-Feld. (int[][])
     * @param row ist die Reihe. (int)
     * @param col ist die Spalte. (int)
     * @return true, wenn ein Konflikt im 3x3-Quadrat vorliegt; sonst false.
     */
    static boolean conflictInSquare(int[][] grid, int row, int col) {
        if (correctInput(row, col, grid[row][col]) || grid[row][col] == 0) {
            int number = grid[row][col]; // Speichert die Zahl, die ueberprueft wird.

            // Ermittelt die Koordinaten des Feldes links oben von dem jeweiligen 3x3 Feld.
            int tmpRow = row - (row % 3);
            int tmpCol = col - (col % 3);
            for (int i = tmpRow; i < tmpRow + 3; i++) {
                for (int j = tmpCol; j < tmpCol + 3; j++) {
                    if ((grid[i][j] == number) && (i != row) && (j != col)) {
                        return true; // Gibt true zurueck, wenn ein Konflikt im 3x3 Quadrat gefunden wird.
                    }
                }
            }
        }
        return false; // Gibt false zurueck, wenn kein Konflikt im 3x3 Quadrat gefunden wird.
    }

    /**
     * ueberprueft das uebergebene Feld (row, col) auf mindestens einen Konflikt.
     *
     * @param grid ist das zweidimensionale Gitter des Sudokus. (int[][])
     * @param row  ist die Reihe des einzugebenen Feldes. (int)
     * @param col  ist die Spalte des einzugebenen Feldes. (int)
     * @return true, wenn mindestens ein Reihen- oder Spaltenkonflikt besteht oder wenn das 3x3 Feld des eingegebenen Feldes einen Konflikt beinhaltet; sonst false.
     */
    static boolean isConflict(int[][] grid, int row, int col) {
        if (conflictInRow(grid, row, col) || conflictInColumn(grid, row, col) || conflictInSquare(grid, row, col)) {
            return true; // Gibt true zurueck, wenn ein Konflikt in der Reihe, Spalte oder 3x3 Quadrat vorliegt.
        }
        return false; // Gibt false zurueck, wenn kein Konflikt vorliegt.
    }

    /**
     * Traegt eine Zahl in das Feld (row, col) und ueberprueft, ob ein Konflikt dabei entsteht.
     *
     * @param grid ist das 9x9 Sudoku-Feld. (int[][])
     * @param row ist die Reihe. (int)
     * @param col ist die Spalte. (int)
     * @param zahl ist die einzutragende Zahl. (int)
     * @return true, wenn das Eintragen erfolgreich war; false, wenn es einen Fehler gab.
     */
    static boolean tryNumber(int[][] grid, int row, int col, int zahl) {
        if (!correctInput(row, col, zahl)) {
            return false; // Falscher Input, daher wird false zurueckgegeben.
        }
        if (grid[row][col] == 0) { // Prueft, ob das Feld leer ist.
            insert(grid, row, col, zahl); // Traegt die Zahl in das Feld ein.
            if (isConflict(grid, row, col)){ // Prueft, ob ein Konflikt entsteht.
                grid[row][col] = 0; // Setzt das Feld zurueck, wenn ein Konflikt gefunden wurde.
                return false; // Gibt false zurueck, wenn ein Konflikt entsteht.
            }
            return true; // Gibt true zurueck, wenn das Eintragen erfolgreich war.
        } else {
            return false; // Gibt false zurueck, wenn das Feld nicht leer ist.
        }
    }
}
