import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
  Main methods
*/
public class cs11aFinal {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    declareVariables();
    shuffle(middleSet);     //
    distribute(middleSet);  //

    do {
      for (int i = 1; i <= 4; i++){
        turns(i);
        System.out.println("Here are you cards...");
        showCards(i, subPlayer1[], subPlayer2[], subPlayer3[], subPlayer4[])
        System.out.println("Pick 1 card to put in the middle");
        int userinput = input.nextInt();
        checkChoosenNum(i);
        cardsToMiddle(i);
        turns(i);
        System.out.println("Tell other what is the card you put down");
        sayingCards(i);

      }
    } while (//check if array length != 0);
  }
}

/**
  Method for Declaring Variables
*/
  public static void declareVariables(){
    int userNumber = scanner.nextInt();//asking for the which player this is
    int userinput = scanner.nextLine(); //asking for the cards
    int n = 0;
    int[] player1 = new int [52];
    int[] subPlayer1 = Arrays.copyOfRange(player1, 0, n);
    int[] player2 = new int [52];
    int[] subPlayer2 = Arrays.copyOfRange(player2, 0, n);
    int[] player3 = new int [52];
    int[] subPlayer3 = Arrays.copyOfRange(player3, 0, n);
    int[] player4 = new int [52];
    int[] subPlayer4 = Arrays.copyOfRange(player4, 0, n);
    int[] CardsPlayed = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
    int[] subCardsPlayed = Arrays.copyOfRange(cardsPlayed, 0, n);
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

 /**
   Method for Shuffling the elements in middleSet with Fisher–Yates shuffle
 */
  public static void shuffle(int[] cardsPlayed) {
    int index, temp;
    Random random = new Random();
    for (int i = cardsPlayed.length - 1; i > 0; i--){
        index = random.nextInt(i + 1);
        temp = cardsPlayed[index];
        cardsPlayed[index] = cardsPlayed[i];
        cardsPlayed[i] = temp;
    }
  }

/**
  Distributing 13 elements per player
*/
  public static void distribute(int[] cardsPlayed) {
    for (int i = 0; i<cardsPlayed.length; i++){
      if(i<=12){
        for (int a = 0; a<=12; a++){
          player1[a]=cardsPlayed[i];
        }
      }else if(i>12 && i<=25){
        for (int b = 0; b<=12; b++){
          player2[b]=cardsPlayed[i];
        }
      }else if(i>25 && i<=38){
        for (int c = 0; c<=12; c++){
          player3[c]=cardsPlayed[i];
        }
      }else if(i>38 && i<=52){
        for (int d = 0; d<=12; d++){
          player4[d]=cardsPlayed[i];
        }
      }
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
    }
  }

  /**
  store cards into the player's array and update the count
  */
  public static void trackCards1 (int[] player1, int[] subPlayer1, int count1){
    int n = subPlayer1.length - 1;
    player1[n] = 0;
    count1++;
    trackTable();
  }

  public static void trackCards2 (int[] player2, int[] subPlayer2, int count2){
    int n = subPlayer2.length - 1;
    player2[n] = 0;
    count2++;
    trackTable();
  }

  public static void trackCards3 (int[] player3, int[] subPlayer3, int count3){
    int n = subPlayer3.length - 1;
    player3[n] = 0;
    count3++;
    trackTable();
  }

  public static void trackCards4 (int[] player4, int[] subPlayer4, int count4){
    int n = subPlayer4.length - 1;
    player4[n] = 0;
    count4++;
    trackTable();
  }

  public static void trackTable (int[] cardsPlayed, int[] subCardsPlayed, int countT){
    int n = 1 + subCardsPlayed.length;
    cardsPlayed[n] = userinput;   //what is userinput
    countT++;
  }

/**
  Method that prints out what cards the player have
*/
  public static int showCards(int userNumber, int[] subPlayer1, int[] subPlayer2, int[] subPlayer3,int[] subPlayer4) {
    if (userNumber==1){
      for (int i = 0; i<=subPlayer1.length; i++ ){
        return subPlayer1[i] + " "
      }
    } else if (userNumber==2){
      for (int i = 0; i<=subPlayer2.length; i++ ){
        return subPlayer2[i] + " "
      }
    } else if (userNumber==3){
      for (int i = 0; i<=subPlayer3.length; i++ ){
        return subPlayer3[i] + " "
      }
    } else (userNumber==4){
      for (int i = 0; i<=subPlayer4.length; i++ ){
        return subPlayer4[i] + " "
      }
    }
  }

/**
  Method to check if the number that user choose is shown in array
*/
  public static void checkChoosenNum(int userNumber, int[] subPlayer1, int[] subPlayer2, int[] subPlayer3,int[] subPlayer4){
    if (userNumber==1){
      trackCards1();
    } else if (userNumber==2){
      trackCards2();
    } else if (userNumber==3){
      trackCards3();
    } else if (userNumber==4){
      trackCards4();
    }
  }

  public static void cardsToMiddle (int userNumber) {
    if (userNumber==1){
      trackCards1();
    } else if (userNumber==2){
      trackCards2();
    } else if (userNumber==3){
      trackCards3();
    } else if (userNumber==4){
      trackCards4();
    }
  }


  public static void bsCaller (){
    if (cards.equals("bullshit")){
      System.out.printf("Who called bullshit? Enter 1 for player 1, 2 for player 2, 3 for player 3, 4 for player 4");
      int bsCaller = scanner.nextInt();
    }
  }
<<<<<<< HEAD
=======
}
public static void pass(){
    int midcount = 0;
}
>>>>>>> 610f650a3df69ff5dc50318fb929356dc46e36e7
