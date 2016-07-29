// CrapsSimulation.java
// Kevin Wilson
// Simulation of the dice game Craps

import java.util.*;

public class CrapsSimulation
{
  public static final double BET = 2.50; // Bet size
  public static final Random RANDOM = new Random();
  public static final Scanner INPUT = new Scanner( System.in );

  // Main entry point of program
  public static void main( String[] args )
  {
    double bankRoll = 25.00;
    while( bankRoll >= BET )
    {
      printMenu( bankRoll );
      int userChoice = getChoice();
      System.out.println();

      if( userChoice == 1 )
      {
        System.out.println( "Player bets on Pass!\n" );
        bankRoll = playCraps( bankRoll, userChoice, true ); // True for Pass
      }
      else if( userChoice == 2 )
      {
        System.out.println( "Player bets on Don't Pass!\n" );
        bankRoll = playCraps( bankRoll, userChoice, false ); // False for Don't Pass
      }
      else
      {
        break;
      }
    }
    System.out.printf( "%nThanks for playing! Your final balance was: $%.2f%n", bankRoll );
  }

  // Prints out menu for the user
  public static void printMenu( double bankRoll )
  {
    System.out.println( "Craps Simulation" );
    System.out.println( "1. Bet on Pass" );
    System.out.println( "2. Bet on Don't Pass" );
    System.out.println( "3. Stop Playing" );
    System.out.printf( "Bankroll: $%.2f%n", bankRoll );
    System.out.print( "Enter your choice > " );
  }

  // Processes and returns menu choice
  public static int getChoice()
  {
    int choice = 0;
    while( 1 > choice || choice > 3 )
    {
      while( !INPUT.hasNextInt() )
      {
        INPUT.next();
        System.out.print( "Please enter only numbers > " );
      }
      choice = INPUT.nextInt();
      if( 1 > choice || choice > 3 )
      {
        System.out.print( "Only enter 1, 2 or 3 > " );
      }
    }
    return choice;
  }

  // Returns random die roll number
  public static int getDieRoll()
  {
    return RANDOM.nextInt( 6 ) + 1;
  }

  // Prints formatted dice roll results
  public static void printRoll( int die1, int die2 )
  {
    System.out.printf( "Shooter rolls a %d (%d, %d)%n", die1 + die2, die1, die2 );
  }

  // Prints come-out results, returns true if point is set
  public static boolean getComeoutResult( int diceRoll )
  {
    if( diceRoll == 7 || diceRoll == 11 )
    {
      System.out.println( "Come-out Roll is a 7 or 11: Pass bets WIN. Don't Pass bets LOSE." );
    }
    else if( diceRoll < 4 || diceRoll == 12 )
    {
      System.out.println( "Come-out Roll is Craps (2, 3, or 12): Don't Pass bets WIN. Pass bets LOSE." );
    }
    else
    {
      System.out.printf( "The point is %d.%n", diceRoll );
      return true;
    }
    return false;
  }

  // Returns true if user chooses to bet the field
  public static boolean shouldBetField( double bankRoll )
  {
    System.out.printf( "Make a Field bet - Balance $%.2f - (y/n)? ", bankRoll );
    String answer = INPUT.next();
    answer = answer.toLowerCase();

    if( answer.charAt( 0 ) == 'y' )
    {
      return true;
    }
    return false;
  }

  // Processes and returns amount won or lost from field bet
  public static double getFieldBetResult( int diceRoll )
  {
    if( diceRoll == 2 || diceRoll == 12 )
    {
      System.out.println( "Field bets WIN double." );
      return BET * 3;
    }
    else if( diceRoll < 5 || diceRoll > 8 )
    {
      System.out.println( "Field bets WIN even money." );
      return BET * 2;
    }
    System.out.println( "Field bets LOSE." );
    return 0.00;
  }

  // When point is set processes roll, returns true if round over
  public static boolean processPointRoll( int point, int diceRoll )
  {
    if( diceRoll == point )
    {
      System.out.printf( "Shooter hits the Point (%d): Pass bets WIN. Don't Pass bets LOSE.%n", point );
      return true;
    }
    else if( diceRoll == 7 )
    {
      System.out.printf( "Shooter rolled a 7 before Point (%d): Don't Pass bets WIN. Pass bets LOSE.%n", point );
      return true;
    }
    else if( diceRoll == 12 )
    {
      System.out.printf( "Shooter rolled a 12 before Point (%d): All bets push.%n%n", point );
      return true;
    }
    return false;
  }

  // Returns true if user won game
  public static boolean didUserWin( int firstRoll, int currentRoll, boolean isPointSet, boolean isPassBet )
  {
    String passWin = "You WIN on your Pass bet.\n";
    String passLose = "You LOSE on your Pass bet.\n";
    String dontPassWin = "You WIN on your Don't Pass bet.\n";
    String dontPassLose = "You LOSE on your Don't Pass bet.\n";

    if( isPassBet && isPointSet )
    {
      if( firstRoll == currentRoll )
      {
        System.out.println( passWin );
        return true;
      }
      System.out.println( passLose );
      return false;
    }
    else if( !isPassBet && isPointSet )
    {
      if( firstRoll != currentRoll )
      {
        System.out.println( dontPassWin );
        return true;
      }
      System.out.println( dontPassLose );
      return false;
    }
    else if( isPassBet && !isPointSet )
    {
      if( firstRoll == 7 || firstRoll == 11 )
      {
        System.out.println( passWin );
        return true;
      }
      System.out.println( passLose );
      return false;
    }
    else
    {
      if( firstRoll < 4 || firstRoll == 12 )
      {
        System.out.println( dontPassWin );
        return true;
      }
      System.out.println( dontPassLose );
      return false;
    }
  }

  // Simulates a game of Craps, returns current bankroll after game ends
  public static double playCraps( double bankRoll, int userChoice, boolean isPassBet )
  {
    double currentBankRoll = bankRoll - BET;
    int die1 = getDieRoll();
    int die2 = getDieRoll();
    int diceRoll = die1 + die2;
    boolean isRoundOver = false;

    System.out.print( "Come-out Roll: " );
    printRoll( die1, die2 );

    boolean isPointSet = getComeoutResult( diceRoll );
    if( !isPointSet )
    {
      isRoundOver = true; // If point isn't set skip and check if winner
    }

    while( !isRoundOver ) // Loop to keep rolling until point or otherwise
    {
      boolean betField = false;
      if( currentBankRoll >= BET )
      {
        betField = shouldBetField( currentBankRoll );
      }


      die1 = getDieRoll();
      die2 = getDieRoll();
      printRoll( die1, die2 );

      if( betField )
      {
        currentBankRoll -= BET;
        double fieldBetResult = getFieldBetResult( die1 + die2 );
        currentBankRoll += fieldBetResult;
      }

      isRoundOver = processPointRoll( diceRoll, die1 + die2 );
    }

    if( isPointSet && die1 + die2 == 12 )
    {
      return currentBankRoll + BET; // Check if round results in push and ends
    }

    boolean didWin = didUserWin( diceRoll, die1 + die2, isPointSet, isPassBet );
    if( didWin )
    {
      return currentBankRoll + BET * 2;
    }
    return currentBankRoll;
  }
}
