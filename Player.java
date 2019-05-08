import java.util.ArrayList;

public class Player {

    private int playerNum;
    private ArrayList<DominoPiece> hand;
    private int turn;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.hand = new ArrayList<>();
        this.turn = 0;
    }

    /**
     * adds a domino to the current players hand
     * @param domino domino to add to the current players hand
     */
    public void addDominoPiece(DominoPiece domino) {
        hand.add(domino);
    }

    /**
     * removes the specified domino from the current players hand
     * @param pieceNo the domino number
     * @return the domino removed from the current players hand
     */
    public DominoPiece removeDominoPiece(int pieceNo) {
        DominoPiece domino = null;
        for(int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getPieceNo() == pieceNo) {
                domino = hand.get(i);
                hand.remove(i);
            }
        }
        return domino;
    }

    /**
     * @return the current players hand
     */
    public ArrayList<DominoPiece> getHand() {
        return hand;
    }

    /**
     * @param turn sets the turn of the player
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * @return the current players turn status
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @return the players number
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * checks to see if the current player has the specified domino in hand
     * @param pieceNo the domino number
     * @return true if the players hand contains the specified domino
     */
    public boolean hasDomino(int pieceNo) {
        for(DominoPiece domino : hand) {
            if(domino.getPieceNo() == pieceNo)
                return true;
        }
        return false;
    }

    /**
     * @param pieceNo the domino number
     * @return the specified domino from the current players hand
     */
    public DominoPiece getDomino(int pieceNo) {
        for(DominoPiece domino : hand) {
            if(domino.getPieceNo() == pieceNo)
                return domino;
        }
        return null;
    }

    public DominoPiece getPlayableDomino(DominoPiece lastPlayedDomino) {
        for(DominoPiece playerDomino : hand) {
            if(lastPlayedDomino == null)
                return playerDomino;
            else if(lastPlayedDomino.getRight() == playerDomino.getLeft() || lastPlayedDomino.getRight() == playerDomino.getRight())
                return playerDomino;
        }
        return null;
    }

    /**
     * checks to see if any domino in the players hand will match the most recently played domino on the table
     * @param lastPlayedDomino the most recently played domino on the table
     * @return true if the player can play any dominoes in hand
     */
    public boolean canPlay(DominoPiece lastPlayedDomino) {
        for(DominoPiece playerDomino : hand) {
            if(lastPlayedDomino.getRight() == playerDomino.getLeft() || lastPlayedDomino.getRight() == playerDomino.getRight())
                return true;
        }
        return false;
    }

    /**
     * @return String representation of the players current hand
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Player " + playerNum + "'s hand:\n");
        for(DominoPiece domino: hand)
            str.append(domino.toString() + "\n");
        return str.toString();
    }
}
