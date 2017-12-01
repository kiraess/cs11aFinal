import java.util.Random;

public class cs11aFinal{
  public static void main(String[] args){
    System.out.println("Hello World");
    int[] middleSet = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
    int[] player1 = new int[52];
    int[] player2 = new int[52];
    int[] player3= new int[52];
    int[] player4 = new int[52];

    shuffle(middleSet);
    distribute(middleSet);
    }
  }

/**
  Shuffling the elements in middleSet with Fisher–Yates shuffle
*/
  public static void shuffle(int[] middleSet) {
    int index, temp;
    Random random = new Random();
    for (int i = middleSet.length - 1; i > 0; i--)
    {
        index = random.nextInt(i + 1);
        temp = middleSet[index];
        middleSet[index] = middleSet[i];
        middleSet[i] = temp;
    }
  }

/**
  Distributing 13 elements per player
*/
  public static void distribute(int[] middleSet) {
    //use instance method would be easier to distribute 13 elements to each array
    for (int i = 1; )


  }

/**
  BS Not Effictive
*/
  public static void bsFail(int[] middleSet, int[] player1, int[] player2, int[] player3, int[] player4){
    //use instance method would be hella easier
  }

}

/* for (int i = 0; i < middleSet.length; i++){
     System.out.print(middleSet[i] + " ");
