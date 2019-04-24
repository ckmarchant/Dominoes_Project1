
public class DominoPiece extends Dominoes{

    private int pieceNo;
    private int available;
    protected int left;
    protected int right;

    public DominoPiece(int pieceNo, int left, int right) {
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

    public DominoPiece flipPiece(DominoPiece d) {
        int temp = left;
        d.left = right;
        d.right = temp;
        return d;
    }

    public String toString() {
        return "pieceNo = " + pieceNo + " \t[" + left + "|" + right + "]" + "\tAvailable = " + available + "\n";
    }
}
