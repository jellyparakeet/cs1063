// SocialNetwork.java
// Kevin Wilson
// Simulates a social network analysis of a number of individuals

import java.awt.*;
import java.util.*;

public class SocialNetwork
{
  public static final Color BACKGROUND = Color.BLACK;
  public static final Color CIRCLE_COLOR = Color.RED;
  public static final int CIRCLE_SIZE = 35;
  public static final Font FONT = new Font( "Monospaced", Font.PLAIN, 15 );
  public static final int HEIGHT = 600;
  public static final Color HIGHLIGHT_CIRCLE = Color.BLUE;
  public static final Scanner INPUT = new Scanner( System.in );
  public static final Color LINE_COLOR = Color.WHITE;
  public static final int RADIUS = 200;
  public static final Random RANDOM = new Random();
  public static final Color TEXT_COLOR = Color.WHITE;
  public static final int WIDTH = 800;

  // Main entry point to program
  public static void main( String[] args )
  {
    int numPeople = getPeopleNumber();
    int[][] adjMatrix = new int[ numPeople ][ numPeople ];
    populateMatrix( adjMatrix );

    DrawingPanel panel = new DrawingPanel( WIDTH, HEIGHT );
    panel.setBackground( BACKGROUND );

    displayMatrix( panel, adjMatrix );
    /*
    Point array returned because, you need the center points to highlight max
    centrality circles in other method
    */
    Point[] points = drawSocialNetwork( panel, adjMatrix );
    displayDegreeCentrality( panel, adjMatrix, points );
    displayNetworkCentrality( panel, adjMatrix );
  }

  // Prompts for and returns number of individuals
  public static int getPeopleNumber()
  {
    int choice = 0;
    System.out.print( "Enter the number of people for the social network (3-12): " );

    while( choice < 3 || choice > 12 )
    {
      while( !INPUT.hasNextInt() )
      {
        INPUT.next();
        System.out.print( "Enter only numbers from 3 to 12: " );
      }
      choice = INPUT.nextInt();
      if( choice < 3 || choice > 12 )
      {
        System.out.print( "Enter only numbers from 3 to 12: " );
      }
    }
    return choice;
  }

  // Fills adjacency matrix randomly based on a 30% chance of a relationship
  public static void populateMatrix( int[][] matrix )
  {
    for( int i = 0; i < matrix.length; i++ )
    {
      for( int j = 0; j < matrix.length; j++ )
      {
        int rand = RANDOM.nextInt( 10 );
        if( rand < 3 && j != i )
        {
          matrix[ i ][ j ] = 1;
          matrix[ j ][ i ] = 1;
        }
      }
    }
  }

  // Displays values in the adjacency matrix
  public static void displayMatrix( DrawingPanel panel, int[][] matrix )
  {
    Graphics g = panel.getGraphics();
    g.setColor( TEXT_COLOR );
    g.setFont( FONT );
    g.drawString( "Adjacency Matrix:", WIDTH - 225, 20 );

    for( int i = 0; i < matrix.length; i++ )
    {
      String noSpaces = Arrays.toString( matrix[ i ] );
      noSpaces = noSpaces.replace( " ", "" );
      g.drawString( noSpaces, WIDTH - 225, ( i + 1 ) * 15 + 20 );
    }
  }

  // Draws visual of the people in the social network returns array containing center points of each
  public static Point[] drawSocialNetwork( DrawingPanel panel, int[][] matrix )
  {
    Graphics g = panel.getGraphics();
    int numPeople = matrix.length;
    Point[] centers = new Point[ numPeople ];

    double slice = 2 * Math.PI / numPeople;
    int midX = WIDTH / 2 - 25;
    int midY = HEIGHT / 2;

    for( int i = 1; i <= numPeople; i++ )
    {
      int index = i - 1;

      // Get center of checked circle and store into points array
      double angle = slice * i;
      int centerX = ( int ) ( midX + RADIUS * Math.cos( angle ) );
      int centerY = ( int ) ( midY + RADIUS * Math.sin( angle ) );
      centers[ index ] = new Point( centerX, centerY );

      int centerDigits = 0; // To center double digit vertex in circle
      if( index > 9 )
      {
        centerDigits = 4;
      }

      for( int j = 0; j < index; j++ )
      {
        if( matrix[ index ][ j ] == 1 )
        {
          // Get center of related circle
          double connAngle = slice * ( j + 1 );
          int endX = ( int ) ( midX + RADIUS * Math.cos( connAngle ) );
          int endY = ( int ) ( midY + RADIUS * Math.sin( connAngle ) );
          g.setColor( LINE_COLOR );
          g.drawLine( centerX, centerY, endX, endY );

          int centerEndDigits = 0; // To center double digit vertex at end circle
          if( j + 1 > 9 )
          {
            centerEndDigits = 4;
          }

          // Redraw both circles after a line was drawn to guarentee lines are under circle
          g.setColor( CIRCLE_COLOR );
          g.fillOval( centerX - CIRCLE_SIZE / 2, centerY - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE );
          g.setColor( TEXT_COLOR );
          g.drawString( String.valueOf( i - 1 ), centerX - 4 - centerDigits, centerY + 4 );

          g.setColor( CIRCLE_COLOR );
          g.fillOval( endX - CIRCLE_SIZE / 2, endY - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE );
          g.setColor( TEXT_COLOR );
          g.drawString( String.valueOf( j ), endX - 4 - centerEndDigits, endY + 4 );
        }
      }

      // Draw circles again in case if statement was always false ( array of 0's )
      g.setColor( CIRCLE_COLOR );
      g.fillOval( centerX - CIRCLE_SIZE / 2, centerY - CIRCLE_SIZE / 2, CIRCLE_SIZE, CIRCLE_SIZE );
      g.setColor( TEXT_COLOR );
      g.drawString( String.valueOf( i - 1 ), centerX - 4 - centerDigits, centerY + 4 );
    }
    return centers; // Return points array
  }

  // Calculates and displays degree centrality for each vertex
  public static void displayDegreeCentrality( DrawingPanel panel, int[][] matrix, Point[] points )
  {
    int numPeople = matrix.length;
    double[] degrees = new double[ numPeople ];
    Graphics g = panel.getGraphics();

    for( int i = 0; i < numPeople; i++ )
    {
      double numConns = 0.0;
      for( int conn: matrix[i] )
      {
        if( conn == 1 )
        {
          numConns++;
        }
      }
      degrees[ i ] = numConns / ( numPeople - 1 ); // Store degrees in array
    }

    g.setColor( TEXT_COLOR );
    g.setFont( FONT );
    g.drawString( "Normalized degree centralities for each vertex", 20, 20 );

    double max = -1.0;

    for( int j = 0; j < numPeople; j++ )
    {
      // Display degrees on screen and check for the max
      g.drawString( String.format( "Vertex %d: %.3f", j, degrees[ j ] ), 20, ( j + 1 ) * 15 + 20 );
      if( degrees[ j ] > max )
      {
        max = degrees[ j ];
      }
    }

    // Iterate degrees array checking if equal to max, draw highlight circle if true
    for( int k = 0; k < numPeople; k++ )
    {
      if( degrees[ k ] == max )
      {
        Point p = points[ k ];
        g.setColor( HIGHLIGHT_CIRCLE );
        g.drawOval( p.x - CIRCLE_SIZE / 2 - 5, p.y - CIRCLE_SIZE / 2 - 5,
                    CIRCLE_SIZE + 10, CIRCLE_SIZE + 10 );
      }
    }
  }

  // Calculates and displays degree centrality for entire network
  public static void displayNetworkCentrality( DrawingPanel panel, int[][] matrix )
  {
    Graphics g = panel.getGraphics();
    int numPeople = matrix.length;
    double maxConns = 0.0;
    double sumDifferences = 0.0;
    double networkCentrality = 0.0;

    // Get max number of connections
    for( int i = 0; i < numPeople; i++ )
    {
      int counter = 0;
      for( int conn: matrix[ i ] )
      {
        if( conn == 1 )
        {
          counter++;
        }
      }
      if( counter > maxConns )
      {
        maxConns = counter;
      }
    }

    // Subtract # of connections in each array from the max and add that to a sum
    for( int j = 0; j < numPeople; j++ )
    {
      int counter = 0;
      for( int conn: matrix[ j ] )
      {
        if( conn == 1 )
        {
          counter++;
        }
      }
      double diff = maxConns - counter;
      sumDifferences += diff;
    }

    // Calculates the entire centrality based on sum obtained earlier
    networkCentrality = sumDifferences / ( ( numPeople - 1 ) * (numPeople - 2) );

    g.setColor( TEXT_COLOR );
    g.setFont( FONT );
    g.drawString( String.format( "Normalized degree centrality for the network: %.3f", networkCentrality ),
                  20, HEIGHT - 20 );
  }
}
