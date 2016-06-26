// CurrencyTables.java
// Kevin Wilson
// Project A - Converts and prints out a table of USD to other currencies

import java.util.*;

public class CurrencyTables
{
  public static final Scanner INPUT = new Scanner( System.in ); // Scanner class constant
  public static final double EUR = 0.902888; // Euro
  public static final double CNY = 6.62140; // Chinese yuan
  public static final double BRL = 3.37284; // Brazilian real
  public static final double ILS = 3.88656; // Israeli shekel
  public static final double MXN = 18.9477; // Mexican peso
  public static final double ZAR = 15.0500; // South African rand

  // Entry point to program
  public static void main( String[] args )
  {
    printHeader();
    printTableOfConversions();
  }

  // Prints our project header
  public static void printHeader()
  {
    System.out.println( "Project A written by Kevin Wilson" );
  }

  // Prints table title and currency codes
  public static void printTableHeader()
  {
    System.out.println( "Currency conversions for US Dollars" );
    System.out.println( "USD\tEUR\tCNY\tBRL\tILS\tMXN\tZAR" );
  }

  // Converts and prints currencies
  public static void printTableOfConversions()
  {
    System.out.print( "Enter start value: " );
    int start = INPUT.nextInt();
    System.out.print( "Enter end value: " );
    int end = INPUT.nextInt();
    System.out.print( "Enter increment: " );
    int increment = INPUT.nextInt();

    printTableHeader(); // Call to print table header method

    for( ; start <= end; start += increment )
    {
      System.out.print( start + "\t" );
      System.out.print( ( int ) ( start * EUR ) + "\t" );
      System.out.print( ( int ) ( start * CNY ) + "\t" );
      System.out.print( ( int ) ( start * BRL ) + "\t" );
      System.out.print( ( int ) ( start * ILS ) + "\t" );
      System.out.print( ( int ) ( start * MXN ) + "\t" );
      System.out.println( ( int ) ( start * ZAR ) );
    }
  }
}
