public class app {

    public static char[][] GRID_TO_SOLVE = {
            {'9','.','.','1','.','.','.','.','5'},
            {'.','.','5','.','9','.','2','.','1'},
            {'8','.','.','.','4','.','.','.','.'},
            {'.','.','.','.','8','.','.','.','.'},
            {'.','.','.','7','.','.','.','.','.'},
            {'.','.','.','.','2','6','.','.','9'},
            {'2','.','.','3','.','.','.','.','6'},
            {'.','.','.','2','.','.','9','.','.'},
            {'.','.','1','9','.','4','5','7','.'},
    };



    public static void main(String[] args) {
        SudokuBoard board = new SudokuBoard(GRID_TO_SOLVE);
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board.getBoard());
        board.display();
    }

}
