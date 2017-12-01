import java.util.Scanner;
import lib.StringArray;
import java.util.Arrays;

public class Methods{
  public static void main(String[] args){
    int userNumber = scanner.nextInt();//asking for the which player this is
    String cards = scanner.nextLine(); //asking for the cards
    int n = 0;
    String[] userinput = cards.split("\\s+");
    String[] player1 = new String [51];
    String[] subPlayer1 = Arrays.copyOfRange(player1, 0, n);
    String[] player2 = new String [51];
    String[] subPlayer2 = Arrays.copyOfRange(player2, 0, n);
    String[] player3 = new String [51];
    String[] subPlayer3 = Arrays.copyOfRange(player3, 0, n);
    String[] player4 = new String [51];
    String[] subPlayer4 = Arrays.copyOfRange(player4, 0, n);
    String[] cardsPlayed = new String [51];
    String[] subCardsPlayed = Arrays.copyOfRange(cardsPlayed, 0, n);
    int numPlayer1=0;
    int numPlayer2=0;
    int numPlayer3=0;
    int numPlayer4=0;
    int count1=subPlayer1.length;
    int count2=subPlayer2.length;
    int count3=subPlayer3.length;
    int count4=subPlayer4.length;
    int countT=0;


  }
}

/**
keep track of who's turn it is during the game
*/
public static void turns(int userNumber){
  if (userNumber==1){
    trackCards1();
  } else if (userNumber==2){
    trackCards2();
  } else if (userNumber==3){
    trackCards3();
  } else if (userNumber==4){
    trackCards4();
  } else {
    if (cards.equals("bullshit")){
      bsCaller();
    } else {
      pass(); //need the method for pass
    }
  }
}

/**
store cards into the player's array and update the count
*/
public static void trackCards1 (String[] player1, String[] subPlayer1, int count1){
  int n = 1 + subPlayer1.length;
  player1[n] = userinput;
  count1++;
  trackTable();
}

public static void trackCards2 (String[] player2, String[] subPlayer2, int count2){
  int n = 1 + subPlayer2.length;
  player2[n] = userinput;
  count2++;
  trackTable();
}

public static void trackCards3 (String[] player3, String[] subPlayer3, int count3){
  int n = 1 + subPlayer3.length;
  player3[n] = userinput;
  count3++;
  trackTable();
}

public static void trackCards4 (String[] player4, String[] subPlayer4, int count4){
  int n = 1 + subPlayer4.length;
  player4[n] = userinput;
  count4++;
  trackTable();
}

public static void trackTable (String[] cardsPlayed, String[] subCardsPlayed, int countT){
  int n = 1 + subCardsPlayed.length;
  cardsPlayed[n] = userinput;
  countT++;
}

public static void bsCaller (){
  if (cards.equals("bullshit")){
    System.out.printf("Who called bullshit? Enter 1 for player 1, 2 for player 2, 3 for player 3, 4 for player 4");
    int bsCaller = scanner.nextInt();
  }
}



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
