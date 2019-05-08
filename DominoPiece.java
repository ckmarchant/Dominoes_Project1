public class DominoPiece {

    private int pieceNo;
    private int available;
    private int left;
    private int right;

    public DominoPiece(int pieceNo, int left, int right) {
        this.available = 1;
        this.pieceNo = pieceNo;
        this.left = left;
        this.right = right;
    }

    /**
     * @return true if the domino is available
     */
    public boolean isAvailable() {
        if(available == 1)
            return true;
        else return false;
    }

    /**
     * @param n value 0 or 1 to set availability of domino
     */
    public void setAvailable(int n) {
        available = n;
    }

    /**
     * flips the left and right values of the dominoes
     */
    public void flipPiece() {
        int temp = left;
        left = right;
        right = temp;
    }

    /**
     * @return availability of domino
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @return the domino number
     */
    public int getPieceNo() {
        return pieceNo;
    }

    /**
     * @return the left-side value of the domino
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return the right-side value of the domino
     */
    public int getRight() {
        return right;
    }

    /**
     * @return String representation of the domino
     */
    public String toString() {
        return "pieceNo = " + pieceNo + " \t[" + left + "|" + right + "]";
    }
}
