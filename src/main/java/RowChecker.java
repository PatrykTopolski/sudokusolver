public class RowChecker implements Runnable {
    private char[][] board;
    private char charToPlace;
    private int row;
    private boolean result;

    public RowChecker(char[][] board, int row, char charToPlace){
        this.board = board;
        this.row = row;
        this.charToPlace = charToPlace;
        result = true;
    }

    public boolean getResult() { return result; }

    @Override
    public void run(){
        for (int i = 0; i < board[row].length; i++) {
            if (charToPlace == board[row][i]) {
                result = false;
            }
        }
    }
}
