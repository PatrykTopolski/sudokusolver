public class ColumnChecker implements Runnable {
    private char[][] board;
    private char charToPlace;
    private int col;
    private boolean result;

    public ColumnChecker(char[][] board, int col, char charToPlace){
        this.board = board;
        this.charToPlace = charToPlace;
        this.col = col;
        result = true;
    }

    public boolean getResult() { return result; }

    @Override
    public void run(){
        for (char[] placementRow: board) {
            if (charToPlace == placementRow[col]){
                result = false;
            }
        }

        if(Thread.interrupted()){
            col = 0;
            charToPlace = '.';
            result = true;
            return;
        }
    }
}
