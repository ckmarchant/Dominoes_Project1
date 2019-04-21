
public class DominoPiece {

    private int playerID;
    private int pieceNo;
    private int available;
    private int left;
    private int right;

    public DominoPiece(int pieceNo, int left, int right) {
        playerID = 0;
        this.available = 1;
        this.pieceNo = pieceNo;
        this.left = left;
        this.right = right;
    }

    public boolean isAvailable() {
        return available == 1;
    }

    public void setAvailable(int n) {
        available = n;
    }

    public String toString() {
        return "pieceNo = " + pieceNo + " \t[" + left + "|" + right + "]" + "\tAvailable = " + available + "\n";
    }
}
