public class Sudoku {
  public static void main(String[] args) {
    int[][] grid = new int[9][9];
    
    // Printet leeres Sudoku-Gitter
    System.out.println("Leeres Sudoku: ");
    showSudoku(grid);

    // Befüllt Sudoku mit Werten eines echten Sudokus und gibt es auf der Konsole aus
    insert(grid,0,1,3);
    insert(grid,0,7,7);
    insert(grid,1,3,5);
    insert(grid,1,8,8);
    insert(grid,2,4,4);
    insert(grid,3,1,5);
    insert(grid,3,1,5);
    insert(grid,3,4,3);
    insert(grid,4,6,9);
    insert(grid,4,8,2);
    insert(grid,5,5,7);
    insert(grid,6,0,1);
    insert(grid,6,2,9);
    insert(grid,6,3,2);
    insert(grid,7,0,2);
    insert(grid,7,5,6);
    insert(grid,7,6,3);
    insert(grid,8,7,4);
    System.out.println("\nEin echtes, lösbares Sudoku: ");
    showSudoku(grid);
    
  }
  
  /**
  * Zeigt das übergebene Gitter auf der Konsole aus. 
  * Wagerechte Trennlinien sind über die Konstante dividingLines anpassbar.
  *@param int[][] grid ist das auszugebende Gitter.
  */
   static void showSudoku(int[][] grid){
    final String dividingLines = "-------------------------";
     
    System.out.println(dividingLines);
    for(int i = 0; i < grid.length; i++){
      System.out.print("| ");
      for(int j = 0; j < grid[i].length; j++){
        if(grid[i][j] == 0){
          System.out.print(". ");
        } else {
          System.out.print(grid[i][j] + " ");
        }
        if((j+1) % 3 == 0){
          System.out.print("| ");
        }
      }

      if((i+1)%3 == 0){
        System.out.print("\n"+dividingLines);
      }
      System.out.println();
    }
  }
  
  /**
  *
  */
  static void insert(int[][] grid, int row, int col, int num){
    if((row < 0) || (row > 8) || (col < 0) || (col > 8) || (num < 1) || (num > 9)){
      System.out.println("Fehler: ");
      return; 
    } 
    grid[row][col] = num; 
  }
}
