// Fireworks.java
// Kevin Wilson
// Simulates fireworks exploding on a drawing panel

import java.awt.*;
import java.util.*;

public class Fireworks
{
  public static final Scanner CONSOLE = new Scanner( System.in );
  public static final int HEIGHT = 450;
  public static final int NUMBER_OF_SPARKS = 100;
  public static final Random RANDOM = new Random();
  public static final int SPARK_WIDTH = 2;
  public static final int VELOCITY_RANGE = 50;
  public static final int WIDTH = 900;

  // Main entry point to program
  public static void main( String[] args )
  {
    int numFireworks = getFireworksNumber();

    Color[] colors = new Color[ 3 ];
    Point[] positions = new Point[ numFireworks ];
    Point[] initialVelocities = new Point[ 100 ];

    initializeColors( colors );
    initializePositions( positions );
    initializeVelocities( initialVelocities );

    DrawingPanel panel = new DrawingPanel( WIDTH, HEIGHT );
    startFireworks( panel, positions, initialVelocities, colors );
  }

  // Prompts for and returns number of fireworks
  public static int getFireworksNumber()
  {
    int choice = 0;
    System.out.print( "How many fireworks do you want to see? (1-8)\n> " );

    while( choice < 1 || choice > 8 )
    {
      while( !CONSOLE.hasNextInt() )
      {
        CONSOLE.next();
        System.out.print( "Enter only numbers from 1 to 8\n> " );
      }
      choice = CONSOLE.nextInt();
      if( choice < 1 || choice > 8 )
      {
        System.out.print( "Enter only numbers from 1 to 8\n> " );
      }
    }
    return choice;
  }

  // Returns random integer based on min and max
  public static int getRandomInt( int min, int max )
  {
    return RANDOM.nextInt( max - min + 1 ) + min;
  }

  // Initializes the colors array
  public static void initializeColors( Color[] colors )
  {
    int length = colors.length;
    for( int i = 0; i < length; i++ )
    {
      int red = getRandomInt( 100, 255 );
      int green = getRandomInt( 150, 255 );
      int blue = getRandomInt( 120, 255 );
      colors[ i ] = new Color( red, green, blue );
    }
  }

  // Initializes the positions array
  public static void initializePositions( Point[] positions )
  {
    int length = positions.length;
    for( int i = 0; i < length; i++ )
    {
      int x = getRandomInt( 200, 600 );
      int y = getRandomInt( 150, 350 );
      positions[ i ] = new Point( x, y );
    }
  }

  // Initializes the initialVelocities array
  public static void initializeVelocities( Point[] velocities )
  {
    int length = velocities.length;
    for( int i = 0; i < length; i++ )
    {
      int x = RANDOM.nextInt( VELOCITY_RANGE + 1 ) - VELOCITY_RANGE / 2;
      int y = RANDOM.nextInt( VELOCITY_RANGE + 1 ) * -1;
      velocities[ i ] = new Point( x, y );
    }
  }

  // Draws black background
  public static void drawBackground( DrawingPanel panel )
  {
    Graphics g = panel.getGraphics();
    g.setColor( Color.BLACK );
    g.fillRect( 0, 0, WIDTH, HEIGHT );
  }

  // Animates the fireworks exploding on the drawing panel
  public static void startFireworks( DrawingPanel panel, Point[] positions, Point[] velocities, Color[] colors )
  {
    Graphics g = panel.getGraphics();
    int colorTracker = 0;

    for( Point p: positions )
    {
      for( double i = 0.0; i < 10.0; i += 0.5 )
      {
        for( Point v: velocities )
        {
          int nextX = ( int ) ( p.x + v.x * i );
          int nextY = ( int ) ( p.y + v.y * i + 4.9 * i * i );

          g.setColor( colors[ colorTracker % 3 ] );
          g.fillOval( nextX, nextY, SPARK_WIDTH, SPARK_WIDTH );
          colorTracker++;
        }
        panel.sleep( 100 );
        drawBackground( panel );
      }
      initializeColors( colors ); // new colors for next firework
    }
  }
}
