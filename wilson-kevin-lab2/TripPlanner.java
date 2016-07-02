// TripPlanner.java
// Kevin Wilson
// Lab 2 - Calculate total distance for itinerary

import java.lang.Math;
import java.util.Scanner;

public class TripPlanner
{
  // Class constant for scanner
  public static final Scanner INPUT = new Scanner( System.in );

  // Entry point to program
  public static void main( String[] args )
  {
    printHeader();
    int numPlaces = getNumOfDests();
    getItinerary( numPlaces );
  }

  // Print header for lab
  public static void printHeader()
  {
    System.out.println( "Lab 2 written by Kevin Wilson\n" );
  }

  // Get number of destinations from user
  public static int getNumOfDests()
  {
    System.out.println( "How many destinations would you like to travel to?" );
    return INPUT.nextInt();
  }

  // Make itinerary for the tript
  public static void getItinerary( int numDests )
  {
    System.out.println( "Your origin is: SAT" );

    String prevApCode = "SAT";
    String nextApCode = "";
    double lon1 = 0.0;
    double lat1 = 0.0;
    double lon2 = 0.0;
    double lat2 = 0.0;
    int distance = 0;
    int totalDistance = 0;

    for( int i = 0; i < numDests; i++ )
    {
      System.out.print( "Enter the next airport code: " );
      nextApCode = INPUT.next();
      lon1 = Airports.getAirportLongitude( prevApCode );
      lat1 = Airports.getAirportLatitude( prevApCode );
      lon2 = Airports.getAirportLongitude( nextApCode );
      lat2 = Airports.getAirportLatitude( nextApCode );
      distance = computeDistance( lon1, lat1, lon2, lat2 );
      totalDistance += distance;

      System.out.println( prevApCode + "-" + nextApCode + ": " + distance + " miles" );

      prevApCode = nextApCode;
    }

    System.out.println( "The total length of your trip is " + totalDistance + " miles." );
  }

  // Compute and return distance between two places
  public static int computeDistance( double lon1, double lat1, double lon2, double lat2 )
  {
    lon1 = Math.toRadians( lon1 );
    lat1 = Math.toRadians( lat1 );
    lon2 = Math.toRadians( lon2 );
    lat2 = Math.toRadians( lat2 );
    double dLon = lon2 - lon1;
    double dLat = lat2 - lat1;
    int earthRadius = 3961;

    double part1 = Math.pow( Math.sin( dLat / 2 ), 2 ) + Math.cos( lat1 ) * Math.cos( lat2 ) * Math.pow( Math.sin( dLon / 2 ), 2 );
    double part2 = 2 * Math.atan2( Math.sqrt( part1 ), Math.sqrt( 1 - part1 ) );
    return ( int ) part2 * earthRadius;
  }
}
