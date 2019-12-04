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

    public static char[][] mostDifficultSudoku = {
            {'8','.','.','.','.','.','.','.','.'},
            {'.','.','3','6','.','.','.','.','.'},
            {'.','7','.','.','9','.','2','.','.'},
            {'.','5','.','.','.','7','.','.','.'},
            {'.','.','.','.','4','5','7','.','.'},
            {'.','.','.','1','.','.','.','3','.'},
            {'.','.','1','.','.','.','.','6','8'},
            {'.','.','8','5','.','.','.','1','.'},
            {'.','9','.','.','.','.','4','.','.'},
    };



    public static void main(String[] args){
        SudokuBoard board = new SudokuBoard(GRID_TO_SOLVE);
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board.getBoard());
        board.display();
        System.out.println("Time taken to process: " + solver.getTimer().countDurationTime());

    }

}
