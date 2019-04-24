import java.util.*;
public class CPlayer extends CRandom{

   Random r = new Random();
   int turnOrder = r.nextInt(2);
   int player1Turn = -turnOrder * 1;
   ArrayList<DominoPiece> playedPieces = new ArrayList<DominoPiece>();
   DominoPiece dom = new DominoPiece(-1,-1,-1);
   int choice = -1;
   public void CPlayer()
   {
   
   }

   public void selectDomino()
   {
   
      while(choice == -1)
      {
         Scanner userIn = new Scanner(System.in);
         System.out.println("Select a domino to start using a domino from your hand. Check the table for the IDs of each domino");
      
         String line = userIn.nextLine();
      
         if(player1Turn == 1)
         {
            choice = p1Hand.get(p1Hand.indexOf(Integer.parseInt(line)));
         }
         else if(player1Turn == -1)
         {
            choice = p2Hand.get(p2Hand.indexOf(Integer.parseInt(line)));
            
         }
         if(choice == -1)
         {
            System.out.println("That domino either does not exist or is not currently in your hand");
         }
      
      }
      
      if (playedPieces.isEmpty()) playedPieces.add(dom.getDominoPiece(choice));
      else  
      {
         DominoPiece lastPc = playedPieces.get(playedPieces.size());
         if(lastPc.right == dom.getDominoPiece(choice).left) 
         {
         playedPieces.add(dom.getDominoPiece(choice));
         p1Hand.remove(new Integer(choice));
         p2Hand.remove(new Integer(choice));
         }
         
         else if(lastPc.right == dom.getDominoPiece(choice).right)
         {
          playedPieces.add(dom.flipPiece(dom.getDominoPiece(choice)));
          p1Hand.remove(new Integer(choice));
          p2Hand.remove(new Integer(choice));
         }
         else System.out.println("The chosen domino can't be connected to the last domino. Choose a different one.");
      }

   }

}