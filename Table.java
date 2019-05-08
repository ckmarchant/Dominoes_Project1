import java.util.ArrayList;

public class Table extends Dominoes
{
    ArrayList<DominoPiece> table = new ArrayList<DominoPiece>();
    DominoPiece lastPlayedDomino = null;

    /**
     * checks conditions to see if domino can be played on the table
     * @param player current player
     * @param pieceNo domino number
     * @return true if the domino has been played on the table
     */
    public boolean playPiece(Player player, int pieceNo) {
        if(player.hasDomino(pieceNo) && isPlayable(player, pieceNo) || table.size() == 0) {
            if(lastPlayedDomino.getRight() == player.getDomino(pieceNo).getRight() && table.size() != 0)
                player.getDomino(pieceNo).flipPiece();
            lastPlayedDomino = player.getDomino(pieceNo);
            table.add(lastPlayedDomino);
            player.removeDominoPiece(pieceNo);
            return true;
        }
        else
            return false;
    }

    /**
     * checks to see if the domino is playable on the most recently placed domino
     * @param player current player
     * @param pieceNo domino number
     * @return true if the domino can be played on the table
     */
    public boolean isPlayable(Player player, int pieceNo) {
        if(lastPlayedDomino.getRight() == player.getDomino(pieceNo).getRight() || lastPlayedDomino.getRight() == player.getDomino(pieceNo).getLeft())
            return true;
        else
            return false;
    }

    /**
     * switches the turns of the players
     * @param player1 first player
     * @param player2 second player
     */
    public void switchTurns(Player player1, Player player2) {
        if(player1.getTurn() == 1) {
            player1.setTurn(0);
            player2.setTurn(1);
        }
        else {
            player1.setTurn(1);
            player2.setTurn(0);
        }
    }

    /**
     * @param domino the most recently played domino
     */
    public void setLastPlayedDomino(DominoPiece domino) {
        lastPlayedDomino = domino;
    }

    /**
     * @return the most recently played domino
     */
    public DominoPiece getLastPlayedDomino() {
        return lastPlayedDomino;
    }

    /**
     * calls determine winner to end the game
     * @param player1 first player
     * @param player2 second player
     */
    public void endGame(Player player1, Player player2) {
        determineWinner(player1, player2);
    }

    /**
     * determines who the winner of the game will be
     * @param player1 first player
     * @param player2 second player
     */
    public void determineWinner(Player player1, Player player2) {
        Player winner = player1;
        Player loser = player2;
        if(player1.getHand().size() > player2.getHand().size()) {
            winner = player2;
            loser = player1;
        }
        System.out.println("\n\n*-------------------*");
        System.out.println("| G A M E  O V E R  |");
        System.out.println("*-------------------*\n\n");
        System.out.println("1st place: Player " + winner.getPlayerNum());
        System.out.println("2nd place: Player " + loser.getPlayerNum());
        System.out.println("\n" + loser);

        int move = 1;
        System.out.println("Table Sequence:");
        System.out.println("Move " + move + ":\t\t                       -->  " + table.get(0));
        for(int i = 0; i < table.size()-1; i++) {
            if(i > 8)
                System.out.println("Move " + move + ":\t" + table.get(i) + "  -->  " + table.get(i + 1));
            else
                System.out.println("Move " + move + ":\t\t" + table.get(i) + "  -->  " + table.get(i + 1));
            move++;
        }
        System.exit(0);
    }

    /**
     * @return String representation of the table
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nTable:\n");
        for(DominoPiece domino: table)
            str.append("[" + domino.getLeft() + "|" + domino.getRight() + "]");
        str.append("\n");
        return str.toString();
    }
}
