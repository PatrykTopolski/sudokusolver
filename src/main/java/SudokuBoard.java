public class SudokuBoard {
    private char[][] board;
    public static final char EMPTY = '.'; // empty cell
    public static final int SIZE = 9; // size of our Sudoku grids

    public SudokuBoard(char[][] board) {
        this.board = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }
}
