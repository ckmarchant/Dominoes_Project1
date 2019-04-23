import java.util.*;
public class CPlayer extends CRandom{

   Random r = new Random();
   int player1Turn = r.nextInt(2);
   ArrayList<Dominoes> playedPieces = new ArrayList<Dominoes>();
   int choice = -1;
   public void CPlayer()
   {
   
   }

   public int selectDomino()
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
         else if(player1Turn == 0)
         {
            choice = p2Hand.get(p2Hand.indexOf(Integer.parseInt(line)));
            
         }
         if(choice == -1)
         {
            System.out.println("That domino either does not exist or is not currently in your hand");
         }
      
      }
       if(player1Turn == 1) player1Turn = 0;
       else player1Turn = 1;

      return choice; 
   }

   public void setDomino()
   {
      if (playedPieces.isEmpty()) playedPieces.add(choice);
      else {

      }
      }
   }


}