public class SudokuSolver {

    /*
  Sudoku Solver - LeetCode: https://leetcode.com/problems/sudoku-solver/
  This code passes all Leetcode test cases as of Oct. 22nd 2019
*/

    private Timer timer;
    private final char EMPTY_ENTRY = '.';

    public SudokuSolver(){
        timer = new Timer();
    }

    public Timer getTimer() {
        return timer;
    }

    public void solveSudoku(char[][] board) {
        timer.setStartTime(System.currentTimeMillis());
        canSolveSudokuFromCell(0, 0, board);
        timer.setEndTime(System.currentTimeMillis());
    }

    private boolean canSolveSudokuFromCell(int row, int col, char[][] board) {
        if (col == board[row].length) {
            col = 0;
            row++;

            if (row == board.length) {
                return true;
            }
        }

        // Skip entries already filled out. They already have a value in them.
        if (board[row][col] != EMPTY_ENTRY) {
            return canSolveSudokuFromCell(row, col + 1, board);
        }
        //start to iterate from 1 to 9 and check each value - is it valid in this place
        for (int value = 1; value <= board.length; value++) {
            char charToPlace = (char) (value + '0');
            if (canPlaceValue(board, row, col, charToPlace)) {
                board[row][col] = charToPlace;
                //recursive call for method on next cell
                if (canSolveSudokuFromCell(row, col + 1, board)) {
                    return true;
                }
                board[row][col] = EMPTY_ENTRY;
            }
        }
        return false;
    }

    private boolean canPlaceValue(char[][] board, int row, int col, char charToPlace) {
        // Thread to check column of the placement
        ColumnChecker colCheck = new ColumnChecker(board, col, charToPlace);
        Thread checkColumnThread = new Thread(colCheck);
        checkColumnThread.start();
        if (!colCheck.getResult()){
            return false;
        };

        // Thread to check row of the placement
       RowChecker rowChecker = new RowChecker(board, row, charToPlace);
       Thread rowCheckThread = new Thread(rowChecker);
       rowCheckThread.start();
       if(!rowChecker.getResult()){
           return false;
       }

        // Check region constraints - get the size of the sub-box
       SubSectionChecker sectionChecker = new SubSectionChecker(board, row, col, charToPlace);
       Thread sectionCheckThread = new Thread(sectionChecker);
       sectionChecker.run();
       if(!sectionChecker.getResult()){
           return false;
       }

        return true;
    }
}
