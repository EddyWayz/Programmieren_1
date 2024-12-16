/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 *
 * Represents a single cell in a Sudoku board, which can hold a number
 * and be marked as fixed (unchangeable).
 */

public class SudokuField {
    /**
     * The value of the cell (0 means empty)
     */
    private int value;

    /**
     * Indicates if the cell is fixed (cannot be changed)
     */
    private boolean fixedValue;

    /**
     * Creates an empty Sudoku field with the value set to 0.
     * The field is mutable (not fixed).
     */
    public SudokuField() {
        this.value = 0;
        this.fixedValue = false;
    }

    /**
     * Creates a Sudoku field with a fixed initial value.
     *
     * @param number The fixed value stored in the field.
     */
    public SudokuField(int number) {
        this.value = number;
        this.fixedValue = true;
    }

    /**
     * Returns the current value of the cell.
     *
     * @return The current value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the cell's value if it is not fixed.
     *
     * @param number The new value.
     */
    public void setValue(int number) {
        if (!fixedValue) {  // Überprüft, ob das Feld veränderbar ist
            value = number;
        }
    }

    /**
     * Clears the field's value (sets it to 0), if the field is not fixed.
     */
    public void clear() {
        if (!fixedValue) {  // Überprüft, ob das Feld veränderbar ist
            value = 0;
        }
    }

    /**
     * Checks if the cell is fixed.
     *
     * @return true if fixed, otherwise false.
     */
    public boolean isFixed() {
        return fixedValue;
    }

    /**
     * Checks if the cell is empty.
     *
     * @return true if empty, otherwise false.
     */
    public boolean isEmpty() {
        return value == 0;
    }
}