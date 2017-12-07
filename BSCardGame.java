/**
  BSCardGame allows the users to play a card game called Bullshit using this program.
  This program requires four players to play the game.
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
  Main methods
*/
public class BSCardGame1 {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int[] player1 = new int [52];
    int[] player2 = new int [52];
    int[] player3 = new int [52];
    int[] player4 = new int [52];
    int[] cardsPlayed = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
    int x;
    boolean play;
    boolean turn = true;

    printRules();
    TextIO.putf("Ready to play?");
    play = TextIO.getlnBoolean();

    shuffle(cardsPlayed);
    distribute(cardsPlayed, player1, player2, player3, player4);

    do{
      while(turn==true){
        for (int i = 1; i <= 4; i++){
          showCards(i, player1, player2, player3, player4, cardsPlayed);
          chooseCard(i, player1, player2, player3, player4, cardsPlayed);
          TextIO.putf("What card did you just put in the middle?");
          x = sayCard();
          BScaller(x, i, player1, player2, player3, player4, cardsPlayed);
        }
        nextTurn();
      }
      winner(player1, player2, player3, player4);
      playAgain(play);
    }while(play==true);

  }

  /**
  nextTurn() read the response from the users and moves to the next turn if the
  users are ready for the next turn
  @return the boolean the user inputs
  */
  public static boolean nextTurn(){
    TextIO.putf("Now all four of you have played one card. Ready for the next turn?%n");
    boolean turn = TextIO.getlnBoolean();
    return turn;
  }

  /**
   shuffle() shuffles the elements in cardsPlayed[] with Fisher–Yates shuffle
   @param cardsPlayed[] a String array that contains the cards that are not held by the users
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
    distribute() distributes 13 elements per player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
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
    showCards() shows the array of cards in each player's hand
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
  */
  public static void showCards(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    System.out.println("");
    System.out.println("Here are you cards...");
    if (userNumber==1){
      showCards1(player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==2){
      showCards2(player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==3){
      showCards3(player1, player2, player3, player4, cardsPlayed);
    } else {
      showCards4(player1, player2, player3, player4, cardsPlayed);
    }
  }

  public static void showCards1(int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int x;
    System.out.println("Player 1:");
    x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
    for (int i = 0; i<x; i++ ){
      System.out.print(player1[i] + " ");
    }
  }

  public static void showCards2(int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int x;
    System.out.println("Player 2:");
    x = arrayTracker(2, player1, player2, player3, player4, cardsPlayed);
    for (int i = 0; i<x; i++ ){
      System.out.print(player2[i] + " ");
    }
  }

  public static void showCards3(int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int x;
    System.out.println("Player 3:");
    x = arrayTracker(3, player1, player2, player3, player4, cardsPlayed);
    for (int i = 0; i<x; i++ ){
      System.out.print(player3[i] + " ");
    }
  }

  public static void showCards4(int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int x;
    System.out.println("Player 4:");
    x = arrayTracker(4, player1, player2, player3, player4, cardsPlayed);
    for (int i = 0; i<x; i++ ){
      System.out.print(player4[i] + " ");
    }
  }

  /**
    chooseCard() allows players to choose the cards they want to put to middle
    it also checks if the chosen cards are in the corresponding array
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
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
    checkCard() checks if the number is actually in the array and move all the index down
    @param userInput an integer that represents the card that is placed to middle by user
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
  */
  public static void checkCard(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    if (userNumber==1){
      checkCard1(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    }
    if (userNumber==2){
      checkCard2(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    }
    if (userNumber==3){
      checkCard3(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    }
    if (userNumber==4){
      checkCard4(userInput, userNumber, player1, player2, player3, player4, cardsPlayed);
    }
  } // method

  public static void checkCard1(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int count = 0;
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

  public static void checkCard2(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int count = 0;
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

  public static void checkCard3(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int count = 0;
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

  public static void checkCard4(int userInput, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int count = 0;
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

  /**
    toMiddle() moves number to middle
    move player elements down
    move middleSet element up
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
    @param count an integer that keeps track of index value of where the first 0 appear in the array to keep track of how many cards are there in the array
  */
  public static void toMiddle(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    if (userNumber==1){
      toMiddle1(count, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==2){
      toMiddle2(count, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==3){
      toMiddle3(count, userNumber, player1, player2, player3, player4, cardsPlayed);
    } else {
      toMiddle4(count, userNumber, player1, player2, player3, player4, cardsPlayed);
    }
  }

  public static void toMiddle1(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int y;
    System.out.println("ToMiddle is working");
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
    cardsPlayed[y] = player1[count];
    for (int i = count-1; i<x; i++ ) {
      player1[i] = player1[i+1];
    }
    player1[x-1] = 0;
  }

  public static void toMiddle2(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int y;
    System.out.println("ToMiddle is working");
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
    cardsPlayed[y] = player2[count];
    for (int i = count-1; i<x; i++ ) {
      player2[i] = player2[i+1];
    }
    player2[x-1] = 0;
  }

  public static void toMiddle3(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int y;
    System.out.println("ToMiddle is working");
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
    cardsPlayed[y] = player3[count];
    for (int i = count-1; i<x; i++ ) {
      player3[i] = player3[i+1];
    }
    player3[x-1] = 0;
  }

  public static void toMiddle4(int count, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int x;
    int y;
    System.out.println("ToMiddle is working");
    x = arrayTracker(userNumber, player1, player2, player3, player4, cardsPlayed);
    y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
    cardsPlayed[y] = player4[count];
    for (int i = count-1; i<x; i++ ) {
      player4[i] = player4[i+1];
    }
    player4[x-1] = 0;
  }

  /**
    arrayTracker() tracks how many elements are there in the array
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
  */
  public static int arrayTracker(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed) {
    int n = 0;
    if (userNumber==1){
      n = arrayTrackerP1(userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==2){
      n = arrayTrackerP2(userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==3){
      n = arrayTrackerP3(userNumber, player1, player2, player3, player4, cardsPlayed);
    } else if (userNumber==4){
      n = arrayTrackerP4(userNumber, player1, player2, player3, player4, cardsPlayed);
    } else {
      n = arrayTrackerP1(userNumber, player1, player2, player3, player4, cardsPlayed);
      }
      return n;
    }

  /**
    arrayTrackerP1 tracks how many elements are there in the array kept for player1
    @param userNumber an integer that represents the position of each player
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
  */
  public static int arrayTrackerP1(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int n=0;
    for (int i=0; i<player1.length; i++){
      if (player1[i] == 0){
        return n-1;
      }else {
        n++;
      }
    }
    return n;
  }

  /**
    arrayTrackerP2 tracks how many elements are there in the array kept for player2
    @param userNumber an integer that represents the position of each player
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
  */
  public static int arrayTrackerP2(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int n=0;
    for (int i=0; i<player2.length; i++){
      if (player2[i] == 0){
        return n-1;
      }else {
        n++;
      }
    }
    return n;
  }

  /**
    arrayTrackerP3 tracks how many elements are there in the array kept for player3
    @param userNumber an integer that represents the position of each player
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
  */
  public static int arrayTrackerP3(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int n=0;
    for (int i=0; i<player3.length; i++){
      if (player3[i] == 0){
        return n-1;
      }else {
        n++;
      }
    }
    return n;
  }

  /**
    arrayTrackerP4 tracks how many elements are there in the array kept for player4
    @param userNumber an integer that represents the position of each player
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
  */
  public static int arrayTrackerP4(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
    int n=0;
    for (int i=0; i<player4.length; i++){
      if (player4[i] == 0){
        return n-1;
      }else {
        n++;
      }
    }
    return n;
  }

  /**
    BScaller() checks if someone wants to call Bullshit
    and who called the Bullshit, if someone called
    @param userInput an integer that represents the card that is placed to middle by user
    @param userNumber an integer that represents the position of each player
    @param cardsPlayed[] a String array that contains the cards that are not held by the users
    @param player1[] a String array that contains the cards that are held by player1
    @param player2[] a String array that contains the cards that are held by player2
    @param player3[] a String array that contains the cards that are held by player3
    @param player4[] a String array that contains the cards that are held by player4
  */
  public static void BScaller(int say, int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
      int caller;
      TextIO.putf("Call Bullshit?%n");
      boolean call = TextIO.getlnBoolean();
      if (call==true){
        caller = numBSCaller();
        checkBS(say, caller, player1, player2, player3, player4, cardsPlayed);
      }
    }

    /**
    numBScaller() gets who called Bullshit
    @return the player's number who called Bullshit
    */
  public static int numBSCaller(){
      int x;
      TextIO.putf("Who called Bullshit? Enter the number of the player%n");
      x = TextIO.getInt();
      return x;
    }

    /**
    sayCard() asks user what card he/she claimed he/she played
    @return the card's number the user claimed he/she played
    */
  public static int sayCard(){
      int sayCard = TextIO.getInt();
      return sayCard;
    }

    /**
    printRules() prints out the instructions of the game
    */
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

    /**
      winner() checks if there is a winner in the game
      @param player1[] a String array that contains the cards that are held by player1
      @param player2[] a String array that contains the cards that are held by player2
      @param player3[] a String array that contains the cards that are held by player3
      @param player4[] a String array that contains the cards that are held by player4
    */
  public static void winner(int[] player1, int[] player2, int[] player3, int[] player4){
      for (int i = 1; i < 5; i++){
        if (i==1){
          if (player1[i]==0){
            TextIO.putf("Player 1 wins!!");
          }
        } else if (i==2){
          if (player2[i]==0){
            TextIO.putf("Player 2 wins!!");
          }
        } else if (i==3){
          if (player3[i]==0){
            TextIO.putf("Player 3 wins!!");
          }
        } else {
          if (player4[i]==0){
            TextIO.putf("Player 4 wins!!");
          }
        }
      }
    }

    /**
    playAgain() asks if the user wants to play the game again
    */
  public static boolean playAgain(boolean play){
      TextIO.putf("Do you wanna play a new game?");
      play = TextIO.getlnBoolean();
      return play;
    }

    /**
      checkBS() checks if the call of Bullshit is effective or not
      @param caller an integer that shows which player called the Bullshit
      @param say an integer that represents the card that the play claimed it to be
      @param cardsPlayed[] a String array that contains the cards that are not held by the users
      @param player1[] a String array that contains the cards that are held by player1
      @param player2[] a String array that contains the cards that are held by player2
      @param player3[] a String array that contains the cards that are held by player3
      @param player4[] a String array that contains the cards that are held by player4
    */
  public static void checkBS(int caller, int say, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
      int y;
      y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
      if(say==cardsPlayed[y]){
        BSTrue(caller, player1, player2, player3, player4, cardsPlayed);
      }else{
        BSFalse(caller, player1, player2, player3, player4, cardsPlayed);
      }
    }

    /**
      BSFalse() shows what happens when a Bullshit call is ineffective
      The caller gets all the cards from middle
      @param userNumber an integer that represents the position of each player
      @param cardsPlayed[] a String array that contains the cards that are not held by the users
      @param player1[] a String array that contains the cards that are held by player1
      @param player2[] a String array that contains the cards that are held by player2
      @param player3[] a String array that contains the cards that are held by player3
      @param player4[] a String array that contains the cards that are held by player4
    */
    public static void BSFalse(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        System.out.println("You are wrong! It wasn't a lie!");
        int x;
        int y;
        int count=0;
        if(userNumber==1){ //caller
          checkBSP1(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==2){
          checkBSP2(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==3){
          checkBSP3(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==4){
          checkBSP4(userNumber, player1, player2, player3, player4, cardsPlayed);
        }
      }

      /**
        BSTrue() shows what happens when a Bullshit call is effective
        The player who is called gets all the cards from middle
        @param userNumber an integer that represents the position of each player
        @param cardsPlayed[] a String array that contains the cards that are not held by the users
        @param player1[] a String array that contains the cards that are held by player1
        @param player2[] a String array that contains the cards that are held by player2
        @param player3[] a String array that contains the cards that are held by player3
        @param player4[] a String array that contains the cards that are held by player4
      */
    public static void BSTrue(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        System.out.println("You are right! It was a lie!");
        int x;
        int y;
        int count=0;
        userNumber=userNumber-1;
        if(userNumber==1){ //player that is called
          checkBSP1(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==2){
          checkBSP2(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==3){
          checkBSP3(userNumber, player1, player2, player3, player4, cardsPlayed);
        }else if(userNumber==4){
          checkBSP4(userNumber, player1, player2, player3, player4, cardsPlayed);
        }
      }

      /**
        checkBSP1() shows that the player1 will receive all the card on the table
        @param userNumber an integer that represents the position of each player
        @param player1[] a String array that contains the cards that are held by player1
        @param player2[] a String array that contains the cards that are held by player2
        @param player3[] a String array that contains the cards that are held by player3
        @param player4[] a String array that contains the cards that are held by player4
        @param cardsPlayed[] a String array that contains the cards that are not held by the users
      */
      public static void checkBSP1(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        int x;
        int y;
        int count=0;
        userNumber=userNumber-1;
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player1[i] = cardsPlayed[count];
          count++;
        }
      }

      /**
        checkBSP2() shows that the player2 will receive all the card on the table
        @param userNumber an integer that represents the position of each player
        @param player1[] a String array that contains the cards that are held by player1
        @param player2[] a String array that contains the cards that are held by player2
        @param player3[] a String array that contains the cards that are held by player3
        @param player4[] a String array that contains the cards that are held by player4
        @param cardsPlayed[] a String array that contains the cards that are not held by the users
      */
      public static void checkBSP2(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        int x;
        int y;
        int count=0;
        userNumber=userNumber-1;
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player2[i] = cardsPlayed[count];
          count++;
        }
      }

      /**
        checkBSP3() shows that the player3 will receive all the card on the table
        @param userNumber an integer that represents the position of each player
        @param player1[] a String array that contains the cards that are held by player1
        @param player2[] a String array that contains the cards that are held by player2
        @param player3[] a String array that contains the cards that are held by player3
        @param player4[] a String array that contains the cards that are held by player4
        @param cardsPlayed[] a String array that contains the cards that are not held by the users
      */
      public static void checkBSP3(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        int x;
        int y;
        int count=0;
        userNumber=userNumber-1;
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player3[i] = cardsPlayed[count];
          count++;
        }
      }

      /**
        checkBSP4() shows that the player4 will receive all the card on the table
        @param userNumber an integer that represents the position of each player
        @param player1[] a String array that contains the cards that are held by player1
        @param player2[] a String array that contains the cards that are held by player2
        @param player3[] a String array that contains the cards that are held by player3
        @param player4[] a String array that contains the cards that are held by player4
        @param cardsPlayed[] a String array that contains the cards that are not held by the users
      */
      public static void checkBSP4(int userNumber, int[] player1, int[] player2, int[] player3, int[] player4, int[] cardsPlayed){
        int x;
        int y;
        int count=0;
        userNumber=userNumber-1;
        x = arrayTracker(1, player1, player2, player3, player4, cardsPlayed);
        y = arrayTracker(0, player1, player2, player3, player4, cardsPlayed);
        for(int i=x+1;i<=x+y;i++){
          player4[i] = cardsPlayed[count];
          count++;
        }
      }
    }//class
