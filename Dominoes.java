import java.util.ArrayList;

public class Dominoes
{
    private ArrayList<DominoPiece> stock;

    public Dominoes() {
        int pieceNo = 1;
        stock = new ArrayList<DominoPiece>();
        for(int i = 0; i <= 6; i++) {
            for(int j = i; j < 7; j++) {
                if(i == 0) stock.add(new DominoPiece(pieceNo, j, j));
                if(i == 1) stock.add(new DominoPiece(pieceNo, j, j - 1));
                if(i == 2) stock.add(new DominoPiece(pieceNo, j, j - 2));
                if(i == 3) stock.add(new DominoPiece(pieceNo, j, j - 3));
                if(i == 4) stock.add(new DominoPiece(pieceNo, j, j - 4));
                if(i == 5) stock.add(new DominoPiece(pieceNo, j, j - 5));
                if(i == 6) stock.add(new DominoPiece(pieceNo, j, j - 6));
                pieceNo++;
            }
        }
    }

    /**
     * @return the 28 dominoes
     */
    public ArrayList<DominoPiece> getStock() {
        return stock;
    }

    /**
     * @return a random available domino
     */
    public DominoPiece getRandomDomino() {
        for(int i = 0; i <= stock.size(); i++) {
            if(stock.get(i).isAvailable()) {
                stock.get(i).setAvailable(0);
                return stock.get(i);
            }
        }
        return null;
    }

    /**
     * @return String representation of the 28 dominoes
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(DominoPiece domino: stock)
                str.append(domino.toString() + "\tAvailable = " + domino.getAvailable() + "\n");
        str.append("\n");
        return str.toString();
    }
}

