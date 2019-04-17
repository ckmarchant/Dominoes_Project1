import java.util.*;

public class CRandom{

int[] p1Hand = new int[10];
int[] p2Hand = new int[10];
int[] remainder = new int[8];
public void CRandom()
{  
   Random r = new Random();

ArrayList<Integer> dList = new ArrayList<Integer>();
int i = 1;
while(i >= 28)
{
   dList.add(i);
}
Collections.shuffle(dList);

for(int j = 0; i < 10; i++)
{
   p1Hand[i] = dList.get(i);
}

for(int j = 10; i < 20; i++)
{
   p2Hand[i] = dList.get(i);
} 

for(int j = 20; i < 28; i++)
{
   remainder[i] = dList.get(i);
}
}


public int[] getHand1()
{
   return p1Hand;
}

public int[] getHand2()
{
   return p2Hand;
}

public int[] getRemains()
{
   return remainder;
}

}