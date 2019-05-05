
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

    public ArrayList<DominoPiece> getAvailablePieces() {
        ArrayList<DominoPiece> availableDominoes = new ArrayList<DominoPiece>();
        for(DominoPiece domino: stock) {
            if(domino.isAvailable())
                availableDominoes.add(domino);
        }
        return availableDominoes;
    }

    public ArrayList<DominoPiece> getStock() {
        return stock;
    }

    public DominoPiece getDominoPiece(int id) {
        DominoPiece domino = stock.get(id);
        domino.setAvailable(0);
        return domino;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(DominoPiece domino: stock)
                str.append(domino.toString());
        return str.toString();
    }

    public static void main(String[] args)
    {
        Dominoes dominoes = new Dominoes();
//        System.out.print(dominoes + "\n");
//
//        dominoes.getDominoPiece(1).setAvailable(0);
//        dominoes.getDominoPiece(3).setAvailable(0);
//        dominoes.getDominoPiece(5).setAvailable(0);
//        dominoes.getDominoPiece(7).setAvailable(0);
//        dominoes.getDominoPiece(9).setAvailable(0);
//
//        System.out.print(dominoes.getAvailablePieces());
    }
}

