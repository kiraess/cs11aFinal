import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
  Main methods
*/
public class BSCardGame {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int[] player1 = new int [52];
    int[] player2 = new int [52];
    int[] player3 = new int [52];
    int[] player4 = new int [52];
    int[] cardsPlayed = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
    boolean play;

    printRules();
    TextIO.putf("Ready to play?");
    play = TextIO.getlnBoolean();

    shuffle(cardsPlayed);
    distribute(cardsPlayed, player1, player2, player3, player4);

    do{
      for (int i = 1; i <= 4; i++){
        showCards(i, player1, player2, player3, player4, cardsPlayed);
        chooseCard(i, player1, player2, player3, player4, cardsPlayed);
        sayCard();
        numBSCaller();
        checkBS();
      }
      playAgain(play);
    }while(play=true);

  }//main

  /**
   Shuffling the elements in cardsPlayed[] with Fisher–Yates shuffle
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
  public static void distribute(int[] cardsPlayed, int[] player1, int[] player2, int[] player3, int[] player4) {
    for (int i = 0; i<13; i++){
      player1[i]=cardsPlayed[i];
    }
    for (int i = 13; i<26; i++){
      player2[i-13]=cardsPlayed[i];
    }
    for (int i = 26; i<39; i++){
      player3[i-26]=cardsPlayed[i];
    }
    for (int i = 39; i<52; i++){
      player4[i-39]=cardsPlayed[i];
    }
    for (int i = 0; i<52; i++){
      cardsPlayed[i] = 0;
    }
  }

  /**
    Show the array of cards
  */
  public static void showCards(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int x;
    System.out.println("");
    System.out.println("Here are you cards...");
    if (userNumber==1){
      System.out.println("Player 1:");
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      for (int i = 0; i<x; i++ ){
        System.out.print(player1[i] + " ");
      }
    } else if (userNumber==2){
      System.out.println("Player 2:");
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      for (int i = 0; i<x; i++ ){
        System.out.print(player2[i] + " ");
      }
    } else if (userNumber==3){
      System.out.println("Player 3:");
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      for (int i = 0; i<x; i++ ){
        System.out.print(player3[i] + " ");
      }
    } else {
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      System.out.println("Player 4:");
      for (int i = 0; i<x; i++ ){
        System.out.print(player4[i] + " ");
      }
    }
  }

  /**
    Chooseing card to putting to middle
    check if the number is actually in array
  */
  public static void chooseCard(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    Scanner input = new Scanner(System.in);
    System.out.println("");
    System.out.println("Choose a card to put in middle");
    int userInput;
    if (userNumber==1){
      userInput = input.nextInt();
      checkCard(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==2){
      userInput = input.nextInt();
      checkCard(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==3){
      userInput = input.nextInt();
      checkCard(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else{
      userInput = input.nextInt();
      checkCard(userInput, 4, player1, player2, player3, player4, cardsPlayed);
    }
  }
  /**
    check if the number is actually in array
    move the all index down
  */
  public static void checkCard(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int count = 0;
    if (userNumber==1){
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    for_loop:
    for (int i = 0; i< x; i++){
      count++;
      if (player1[i] == userInput){
        toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
        break for_loop;
        }
      }
    }

    if (userNumber==2){
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    for_loop:
    for (int i = 0; i< x; i++){
      count++;
      if (player2[i] == userInput){
        toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
        break for_loop;
        }
      }
    }

    if (userNumber==3){
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    for_loop:
    for (int i = 0; i< x; i++){
      count++;
      if (player3[i] == userInput){
        toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
        break for_loop;
        }
      }
    }

  if (userNumber==4){
  x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
  for_loop:
  for (int i = 0; i< x; i++){
    count++;
    if (player4[i] == userInput){
      toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
      break for_loop;
      }
    }
  }
    } // method

  /**
    move number to middle
    move player elements down
    move middleSet element up
  */
  public static void toMiddle(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int y;
    if (userNumber==1){
      System.out.println("ToMiddle is working");
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      cardsPlayed[y] = player1[count];
      for (int i = count-1; i<x; i++ ) {
        player1[i] = player1[i+1];
      }
      player1[x-1] = 0;
    } else if (userNumber==2){
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      cardsPlayed[y] = player2[count];
      for (int i = count-1; i<x; i++ ) {
        player2[i] = player2[i+1];
      }
      player2[x-1] = 0;
    } else if (userNumber==3){
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      cardsPlayed[y] = player3[count];
      for (int i = count-1; i<x; i++ ) {
        player3[i] = player3[i+1];
      }
      player3[x-1] = 0;
    } else {
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      cardsPlayed[y] = player4[count];
      for (int i = count-1; i<x; i++ ) {
        player4[i] = player4[i+1];
      }
      player4[x-1] = 0;
    }
  }

  /**
    Track how many elements are there in the array
  */
  public static int arrayTracker(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int n = 0;
    if (userNumber==1){
      for (int i=0; i<player1.length; i++){
        if (player1[i] == 0){
          return n-1;
        }else {
          n++;
        }
      }
    } else if (userNumber==2){
      for (int i=0; i<player1.length; i++){
        if (player1[i] == 0){
          return n-1;
        }else {
          n++;
        }
      }
    } else if (userNumber==3){
        for (int i=0; i<player1.length; i++){
          if (player1[i] == 0){
            return n-1;
          }else {
            n++;
          }
        }
    } else if (userNumber==4){
        for (int i=0; i<player1.length; i++){
          if (player1[i] == 0){
            return n-1;
          }else {
            n++;
          }
        }
    } else {
        for (int i=0; i<player1.length; i++){
          if (player1[i] == 0){
            return n-1;
          }else {
            n++;
          }
        }
      }
      return n;
    }

    /**
    check if someone wants to call BS
    if BS is called, then check who calls
    */
  public static void BScaller(){
      TextIO.putf("Call Bullshit?%n");
      boolean call = TextIO.getlnBoolean();
      if (call==true){
        numBSCaller();
      } else {
        break;
      }
    }

    /**
    check who calls BS
    determines who gets the card
    */
  public static void numBScaller(){
      TextIO.putf("Who called Bullshit? Enter the number of the player%n");
      int userNumber = TextIO.getInt();
    }

    /**
    ask user what card he/she played
    */
  public static int sayCard(){
      TextIO.putf("What card did you just put in the middle?");
      int sayCard = TextIO.getInt();
      return sayCard;
    }

  public static void printRules(){
      TextIO.putf("Welcome to the world of Bullshit - the best game you will ever play %n");
      TextIO.putf("Here is the rule: %n");
      TextIO.putf("You must have 4 players for this game.%n");
      TextIO.putf("If you don't have enough players, drag some random people from the street to play with you.%n");
      TextIO.putf("If you have way too many players, try to take turns or tell them how you love them and let them leave.%n");
      TextIO.putf("Each player will get 13 cards at the beginning and the cards will be shown to the player once all cards are distributed.%n");
      TextIO.putf("Starting from player number 1, the game requires each players to put 1 card on the table.%n");
      TextIO.putf("The card should be facing down.%n");
      TextIO.putf("The player can choose to lie about the kind of the card played.%n");
      TextIO.putf("If you believe that the player is lying, you can choose to call Bullshit.%n");
      TextIO.putf("If the player is lying, he/she gets all the cards on the table.%n");
      TextIO.putf("if not, the player who call Bullshit takes all the cards.%n");
      TextIO.putf("The winner will be whoever run out the cards first.%n");
      TextIO.putf("Good luck!!%n");
    }

  public static void winner(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4){
      int i = 0;
      if (userNumber==1){
        if (player1[i]==0){
          TextIO.putf("Player 1 wins!!");
        }
      } else if (userNumber==2){
        if (player2[i]==0){
          TextIO.putf("Player 2 wins!!");
        }
      } else if (userNumber==3){
        if (player3[i]==0){
          TextIO.putf("Player 3 wins!!");
        }
      } else {
        if (player4[i]==0){
          TextIO.putf("Player 4 wins!!");
        }
      }
    }

  public static void playAgain(boolean play){
      TextIO.putf("Do you wanna play again?");
      play = TextIO.getlnBoolean();
    }

  public static void checkBS(){
      int y;
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      if(sayCard=cardsPlayed[y]){
        BSTrue(userNumber, player1, player2, player3, player4, cardsPlayed);
      }else{
        BSFalse(userNumber, player1, player2, player3, player4, cardsPlayed);
      }
    }

  public static void BSFalse(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
      int x;
      int y;
      int count=0;
      if(userNumber==1){ //caller
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player1[i] = cardsPlayed[count];
          count++;
        }

      }else if(userNumber==2){
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player2[i] = cardsPlayed[count];
          count++;
        }
      }else if(userNumber==3){
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player3[i] = cardsPlayed[count];
          count++;
        }
      }else if(userNumber==4){
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player4[i] = cardsPlayed[count];
          count++;
        }
      }
    }
    }

  public static void BSTrue(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
      int x;
      int y;
      int count=0;
      userNumber=userNumber-1;
      if(userNumber==1){ //player that is called
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player1[i] = cardsPlayed[count];
          count++;
        }
      }else if(userNumber==2){
          x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
          y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
          for(int i=x+1;i<=x+y;i++){
            player2[i] = cardsPlayed[count];
            count++;
          }
      }else if(userNumber==3){
          x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
          y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
          for(int i=x+1;i<=x+y;i++){
            player3[i] = cardsPlayed[count];
            count++;
          }
      }else if(userNumber==4){
          x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
          y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
          for(int i=x+1;i<=x+y;i++){
            player4[i] = cardsPlayed[count];
            count++;
          }
      }
    }
  }//class
