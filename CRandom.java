import java.util.*;

public class CRandom{

      ArrayList<Integer> p1Hand = new ArrayList<Integer>();
      ArrayList<Integer> p2Hand = new ArrayList<Integer>();
      ArrayList<Integer> remainder = new ArrayList<Integer>();
   public void CRandom()
   {  

      ArrayList<Integer> dList = new ArrayList<Integer>();
      int i = 1;
      while(i >= 28)
      {
         dList.add(i);
      }
      Collections.shuffle(dList);
   
      for(int j = 0; i < 10; i++)
      {
         p1Hand.add(dList.get(i));
      }
   
      for(int j = 10; i < 20; i++)
      {
         p2Hand.add(dList.get(i));
      } 
   
      for(int j = 20; i < 28; i++)
      {
         p1Hand.add(dList.get(i));
      }
   }


   public ArrayList<Integer> getHand1()
   {
      return p1Hand;
   }

   public ArrayList<Integer> getHand2()
   {
      return p2Hand;
   }


   public ArrayList<Integer> getRemainder()
   {
      return remainder;
   }


}