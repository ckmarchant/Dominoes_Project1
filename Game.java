import java.util.Scanner;

public class Game {
    public static void main(String[] args)
    {
        boolean played;
        boolean run = true;
        int pieceNo;

        // instantiate game objects
        Scanner keyboard = new Scanner(System.in);
        Dominoes stock = new Dominoes();
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        CRandom random = new CRandom(player1, player2, stock);
        Table table = new Table();

        System.out.println("\n\n*-------------------*");
        System.out.println("|  D O M I N O E S  |");
        System.out.println("*-------------------*\n\n");

        // choose first player
        Player player = player1.getTurn() == 1 ? player1 : player2;
        System.out.println("Player " + player.getPlayerNum() + "'s turn!\n");

        // print players hand
        System.out.println(player);

        // select a playable domino automatically
        DominoPiece domino = player.getPlayableDomino(table.lastPlayedDomino);
        pieceNo = domino.getPieceNo();
        table.setLastPlayedDomino(domino);
        played = table.playPiece(player, pieceNo);

        // enter into the game loop
        while(run)
        {
            System.out.println("\n---------------------------------------------------");

            // switch players
            table.switchTurns(player1, player2);
            player = player1.getTurn() == 1 ? player1 : player2;

            System.out.println("\nPlayer " + player.getPlayerNum() + "'s turn!");

            // print out the table
            System.out.println(table);

            // print players hand
            System.out.println(player);

            // select a playable domino automatically
            domino = player.getPlayableDomino(table.lastPlayedDomino);
            if(domino != null)
                pieceNo = domino.getPieceNo();
            table.setLastPlayedDomino(domino);

            // player enters -1 if cannot play a domino on the table
            if(domino == null)
                try{
                    while(!player.canPlay(table.getLastPlayedDomino()))
                        player.addDominoPiece(stock.getRandomDomino());

                    // print players hand
                    System.out.println("\n" + player);

                    // select a playable domino automatically
                    domino = player.getPlayableDomino(table.lastPlayedDomino);
                    pieceNo = domino.getPieceNo();
                    table.setLastPlayedDomino(domino);
                    played = table.playPiece(player, pieceNo);

                    while(!played) {
                        System.out.println("Invalid Piece. Select another piece.");

                        // select a playable domino automatically
                        domino = player.getPlayableDomino(table.lastPlayedDomino);
                        pieceNo = domino.getPieceNo();
                        table.setLastPlayedDomino(domino);
                        played = table.playPiece(player, pieceNo);
                    }
                } catch(Exception e) {
                    run = false;
                }
            else
                played = table.playPiece(player, pieceNo);

            while (!played) {
                System.out.println("Invalid Piece. Select another piece.");

                // select a playable domino automatically
                domino = player.getPlayableDomino(table.lastPlayedDomino);
                if(domino != null)
                    pieceNo = domino.getPieceNo();
                table.setLastPlayedDomino(domino);
                played = table.playPiece(player, pieceNo);
            }
            if(player.getHand().size() == 0)
                table.endGame(player1, player2);
        }
        table.endGame(player1, player2);
    }
}
