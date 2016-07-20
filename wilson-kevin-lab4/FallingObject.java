// FallingObject.java
// Kevin Wilson
// Calculate and draw position of a falling object

import java.awt.*;
import java.util.*;

public class FallingObject
{
  public static final int HEIGHT = 768;
  public static final Scanner INPUT = new Scanner( System.in );
  public static final int GROUND_Y_COORD = 710;
  public static final int WIDTH = 1024;

  // Main entry point to program
  public static void main( String[] args )
  {
    // Get ball color string from user
    System.out.println( "Select a color for your ball: " );
    System.out.print( "\tRed\n\tBlue\n\tGreen\n\n>> " );
    String color = INPUT.next();

    // Get initial values for position and velocity
    System.out.print( "Enter initial position x ( x < 1024 ): " );
    int positionX = INPUT.nextInt();
    System.out.print( "Enter initial position y ( y < 700 ): " );
    int positionY = INPUT.nextInt();
    System.out.print( "Enter initial velocity x ( -100 <= x <= 100 ): " );
    int velocityX = INPUT.nextInt();
    System.out.print( "Enter initial velocity y ( -100 <= y <= 100 ): " );
    int velocityY = INPUT.nextInt();

    // Check for valid values from user
    if( positionX >= 1024 || positionY >= 530 || velocityX < -100 ||
        velocityX > 100 || velocityY < -100 || velocityY > 100 )
    {
      System.out.println( "\nERROR: Values are out of bounds." );
      System.exit( 1 );
    }

    // Create drawing panel
    DrawingPanel panel = new DrawingPanel( WIDTH, HEIGHT );
    Graphics g = panel.getGraphics();

    // Draw the surroundings
    drawScene( g );

    // Get ball color object
    Color ballColor = getBallColor( color );

    // Draw the ball over time
    drawFallingBall( g, positionX, positionY, velocityX, velocityY, ballColor );

    // Draw the header
    drawHeader( g );
  }

  // Returns Color object for the color of the ball
  public static Color getBallColor( String color )
  {
    String lowerColor = color.toLowerCase();

    if( lowerColor.startsWith( "r" ) )
    {
      return new Color( 255, 0, 0 );
    }
    else if( lowerColor.startsWith( "g" ) )
    {
      return new Color( 0, 255, 0 );
    }
    else if( lowerColor.startsWith( "b" ) )
    {
      return new Color( 0, 0, 255 );
    }
    else
    {
      return Color.YELLOW;
    }
  }

  // Draws sky and ground
  public static void drawScene( Graphics g )
  {
    g.setColor( new Color( 102, 178, 255 ) );
    g.fillRect( 0, 0, WIDTH, GROUND_Y_COORD );
    g.setColor( new Color( 153, 76, 0 ) );
    g.fillRect( 0, GROUND_Y_COORD, WIDTH, HEIGHT );
  }

  // Draws the falling ball over time
  public static void drawFallingBall( Graphics g, int positionX, int positionY,
                                    int velocityX, int velocityY, Color color )
  {
    for( int i = 0; i < 25; i++ )
    {
      // Get positions in time for falling ball
      int nextX = ( int ) ( positionX + velocityX * i );
      int nextY = ( int ) ( positionY + velocityY * i + 4.9 * i * i );

      // Check ball is above ground, if not end loop with ball above ground
      if( nextY + 20 > GROUND_Y_COORD )
      {
        g.setColor( color );
        g.fillOval( nextX, GROUND_Y_COORD - 20, 20, 20 );
        g.setColor( Color.BLACK );
        g.drawOval( nextX, GROUND_Y_COORD - 20, 20, 20 );
        break;
      }

      // Draw ball with user color over time
      g.setColor( color );
      g.fillOval( nextX, nextY, 20, 20 );
      g.setColor( Color.BLACK );
      g.drawOval( nextX, nextY, 20, 20 );
    }
  }

  // Draw the header on the panel
  public static void drawHeader( Graphics g )
  {
    g.setColor( new Color( 150, 50, 50 ) );
    g.setFont( new Font( "Monospaced", Font.BOLD, 15 ) );
    g.drawString( "Lab 4 by Kevin Wilson", 10, 20 );
  }
}
