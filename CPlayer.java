
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class CPlayer extends CRandom {
   
   CRandom cr = new CRandom();
   Random r = new Random();
   boolean player1Turn = r.nextBoolean(); 
   ArrayList<DominoPiece> playedPieces = new ArrayList<DominoPiece>();
   DominoPiece dom = null;
   DominoPiece lastPc = null;
   private int choice = -1;
   
   Scanner userIn = new Scanner(System.in);
   public void CPlayer()
   {
      boolean playable = false;
         
      if(player1Turn && lastPc != null)
      {
         for(int i = 0; i < p1Hand.size(); i++)
         {
            if(lastPc.getRight() == dom.getDominoPiece(p1Hand.get(i)).left || lastPc.getRight() == dom.getDominoPiece(p1Hand.get(i)).right)
            {
               playable = true;
               break;
            }
         }
        
      }
      else if(!player1Turn && lastPc != null)
      {
         for(int i = 0; i < p2Hand.size(); i++)
         {
            if(lastPc.getRight() == dom.getDominoPiece(p2Hand.get(i)).left || lastPc.getRight() == dom.getDominoPiece(p2Hand.get(i)).right)
            {
               playable = true;
               break;
            }
         }
      
      }
   
      if(!playable)
      {
         System.out.println("You have no playable pieces. Take a piece from the stock and end your turn.");
            
         int piece = userIn.nextInt();
            
         if(player1Turn) p1Hand.add(remainder.get(remainder.indexOf(piece)));
         else p2Hand.add(remainder.get(remainder.indexOf(piece)));
         
         player1Turn = !player1Turn;
      }
   }

   public void selectDomino()
   {
   
      while(choice == -1)
      {
         
         System.out.println("Select a domino to start using a domino from your hand. Check the table for the IDs of each domino");
      
         int line = userIn.nextInt();
      
         if(player1Turn)
         {
            choice = p1Hand.get(p1Hand.indexOf(line));
         }
         else
         {
            choice = p2Hand.get(p2Hand.indexOf(line));
            
         }
         if(choice == -1)
         {
            System.out.println("That domino either does not exist or is not currently in your hand");
         }
      
      }
      
      if (playedPieces.isEmpty()) playedPieces.add(dom.getDominoPiece(choice));
      else  
      {
         lastPc = playedPieces.get(playedPieces.size());
         if(lastPc.getRight() == dom.getDominoPiece(choice).left)
         {
            playedPieces.add(dom.getDominoPiece(choice));
            p1Hand.remove(choice);
            p2Hand.remove(choice);
            player1Turn = !player1Turn;
         }
         
         else if(lastPc.getRight() == dom.getDominoPiece(choice).right)
         {
            playedPieces.add(dom.flipPiece(dom.getDominoPiece(choice)));
            p1Hand.remove(choice);
            p2Hand.remove(choice);
            player1Turn = !player1Turn;
         }
         else System.out.println("The chosen domino can't be connected to the last domino. Choose a different one.");
      }
      for(int i = 0; i < playedPieces.size(); i++)
      {
         System.out.println("The currently played dominoes: " + (playedPieces.get(i).toString()));
      }
   }
   public void checkWinner() 
   {
      int winner = 0;
      
      if(p1Hand.size() == 0)
      {
         System.out.println("Player 1 wins! Congratulations!");
         System.exit(0);
      }
      if(p2Hand.size() == 0)
      {
         System.out.println("Player 2 wins! Congratulations!");
         System.exit(0);
      }
   }

}