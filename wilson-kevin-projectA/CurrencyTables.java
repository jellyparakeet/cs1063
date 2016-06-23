// CurrencyTables.java
// Kevin Wilson
// Project A - Converts and prints out a table of USD to other currencies

import java.util.*;

public class CurrencyTables
{
  public static final Scanner INPUT = new Scanner( System.in );
  public static final double EUR = 0.876875; // Euro
  public static final double CNY = 6.56948; // Chinese yuan
  public static final double BRL = 3.35393; // Brazilian real
  public static final double ILS = 3.82141; // Israeli shekel
  public static final double MXN = 18.3304; // Mexican peso
  public static final double ZAR = 14.4681; // South African rand

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
  }

  // Converts and prints currencies
  public static void printTableOfConversions()
  {
  }
}
