package Aufgabenblatt_06;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 *
 * Die Klasse SudokuField repräsentiert ein einzelnes Feld in einem Sudoku-Brett.
 * Jedes Feld kann einen numerischen Wert haben und kann als "fest" markiert sein,
 * was bedeutet, dass sein Wert nicht geändert werden kann (z.B. bei Vorgabewerten).
 */

public class SudokuField {
    // Der Wert des Sudoku-Feldes (0 bedeutet leer)
    private int value = 0;

    // Gibt an, ob das Feld fest ist (z.B. ein Startwert, der nicht geändert werden darf)
    private boolean fixed;

    public SudokuField(int value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }

    /**
     * Gibt den aktuellen Wert des Feldes zurück.
     *
     * @return int als numerischen Wert des Feldes. (0, wenn leer)
     */
    public int getValue() {
        return value;
    }

    /**
     * Setzt den Wert des Feldes auf den angegebenen Wert n, falls das Feld nicht fest ist.
     *
     * @param n der neue Wert, der gesetzt werden soll.
     */
    public void setValue(int n) {
        if (!fixed) {  // Überprüft, ob das Feld veränderbar ist
            value = n;
        }
    }

    /**
     * Löscht den Wert des Feldes, indem es auf 0 gesetzt wird (leerer Zustand),
     * falls das Feld nicht fest ist.
     */
    public void clear() {
        if (!fixed) {  // Überprüft, ob das Feld veränderbar ist
            value = 0;
        }
    }

    /**
     * Überprüft, ob das Feld fest ist.
     *
     * @return true, wenn das Feld fest ist, sonst false.
     */
    public boolean isFixed() {
        return fixed;
    }

    /**
     * Überprüft, ob das Feld leer ist (Wert gleich 0).
     *
     * @return true, wenn das Feld leer ist, sonst false.
     */
    public boolean isEmpty() {
        return value == 0;
    }
}