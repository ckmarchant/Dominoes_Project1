import java.util.Collections;
import java.util.Random;

public class CRandom
{
    public CRandom(Player player1, Player player2, Dominoes stock)
    {
        pickFirstPlayer(player1, player2);
        distributeDominoPieces(player1, player2, stock);
    }

    /**
     * randomly selects the player who will start first
     * @param player1 first player
     * @param player2 second player
     */
    public void pickFirstPlayer(Player player1, Player player2) {
        Random r = new Random();
        int randomNum = r.nextInt(2);
        if(randomNum == 0)
            player1.setTurn(1);
        else
            player2.setTurn(1);
    }

    /**
     * distributes 10 dominoes to each player
     * @param player1 first player
     * @param player2 second player
     * @param stock the starting 28 dominoes
     */
    public void distributeDominoPieces(Player player1, Player player2, Dominoes stock) {
        Collections.shuffle(stock.getStock());
        for(int i = 0; i < 20; i++) {
            if(i < 10 && stock.getStock().get(i).isAvailable()) {
                player1.addDominoPiece(stock.getStock().get(i));
                stock.getStock().get(i).setAvailable(0);
            }
            else if(i >= 10 && i < 20 && stock.getStock().get(i).isAvailable()) {
                player2.addDominoPiece(stock.getStock().get(i));
                stock.getStock().get(i).setAvailable(0);
            }
        }
    }
}
