// Coins.java
// Kevin Wilson
// Lab 1 - Converts coins to dollars and vice versa

import java.util.*;

public class Coins
{
  public static final Scanner INPUT = new Scanner( System.in );

  public static void main( String[] args )
  {
    makeHeader();
    convertToDollars();
    convertToCoins();
  }

  public static void makeHeader()
  {
    System.out.print( "Please enter your first name: " );
    String name = INPUT.nextLine();
    System.out.println( "\nLab 1 written by " + name + "\n" );
  }

  public static void convertToDollars()
  {
    System.out.println( "Please enter a number for each type of coin to see the total value" );

    System.out.print( "Quarters: " );
    int quarters = INPUT.nextInt();
    System.out.print( "Dimes: " );
    int dimes = INPUT.nextInt();
    System.out.print( "Nickels: " );
    int nickels = INPUT.nextInt();
    System.out.print( "Pennies: " );
    int pennies = INPUT.nextInt();
    int totalCoins = quarters + dimes + nickels + pennies;

    double value = 0.0;
    value += quarters * 0.25;
    value += dimes * 0.10;
    value += nickels * 0.05;
    value += pennies * 0.01;

    System.out.println( "Total coins: " + totalCoins );
    System.out.println( "Value: " + value + "\n" );
  }
}
