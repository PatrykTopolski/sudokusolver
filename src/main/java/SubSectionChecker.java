public class SubSectionChecker implements Runnable {
    private char[][] board;
    private char charToPlace;
    private int row;
    private int col;
    private boolean result;

    public SubSectionChecker(char[][] board, int row, int col, char charToPlace){
        this.board = board;
        this.col = col;
        this.row = row;
        this.charToPlace = charToPlace;
        result = true;
    }

    public boolean getResult() { return result;}

    @Override
    public void run(){
        int regionSize = (int) Math.sqrt(board.length);

        int verticalBoxIndex = row / regionSize;
        int horizontalBoxIndex = col / regionSize;

        int topLeftOfSubBoxRow = regionSize * verticalBoxIndex;
        int topLeftOfSubBoxCol = regionSize * horizontalBoxIndex;

        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (charToPlace == board[topLeftOfSubBoxRow + i][topLeftOfSubBoxCol + j]) {
                    result = false;
                }
            }
        }
    }
}
