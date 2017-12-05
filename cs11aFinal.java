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

    shuffle(cardsPlayed);
    distribute(cardsPlayed, player1, player2, player3, player4);

    do{
      for (int i = 1; i <= 4; i++){
        showCards(i, player1, player2, player3, player4, cardsPlayed);
        chooseCard(i, player1, player2, player3, player4, cardsPlayed);
        say
        bs
        effective
      }

    }while(false);

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
      try{
        for (int i = 0; player1[i] == userInput; i++){
          count++;
          toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
        }
      } catch(Exception e){
          System.out.println("Choose a card from your set");
          System.out.println("P1");
          chooseCard(userNumber, player1, player2, player3, player4, cardsPlayed);
      }
    } else if (userNumber==2){
      x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
      try{
        for (int i = 0; player2[i] == userInput; i++){
          count++;
          toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
        }
      } catch(Exception e){
          System.out.println("Choose a card from your set");
          System.out.println("P2");
          chooseCard(userNumber, player1, player2, player3, player4, cardsPlayed);
      }
    } else if (userNumber==3){
        try{
          for (int i = 0; player3[i] == userInput; i++){
            count++;
            toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
          }
        } catch(Exception e){
            System.out.println("Choose a card from your set");
            System.out.println("P3");
            chooseCard(userNumber, player1, player2, player3, player4, cardsPlayed);
      }
    } else {
        try{
          for (int i = 0; player4[i] == userInput; i++){
            count++;
            toMiddle(count, userNumber, player1, player2, player3, player4, cardsPlayed);
          }
        } catch(Exception e){
            System.out.println("Choose a card from your set");
            System.out.println("P4");
            chooseCard(userNumber, player1, player2, player3, player4, cardsPlayed);
        }
      }
    }

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
    ublic static void BScaller(){
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

    public static void checkBS(){
      int y;
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      if(sayCard=cardsPlayed[y]){
        BSTrue();
      }else{
        BSFalse();
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
