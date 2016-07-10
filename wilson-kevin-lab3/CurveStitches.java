// CurveStitches.java
// Kevin Wilson
// Lab 3 - Draw a circle and diamond with curve stitches

import java.awt.*;
import java.util.*;

public class CurveStitches
{
  public static final int WIDTH = 600;
  public static final int HEIGHT = 600;
  public static final int RADIUS = 300;
  public static final int NUM_VERTICES = 100;
  public static final Random RANDOM = new Random();
  public static final Scanner INPUT = new Scanner( System.in );

  // Main entry point to program
  public static void main( String[] args )
  {
    System.out.print( "Please enter an interval (pixels): " );
    int interval = INPUT.nextInt();
    DrawingPanel panel = new DrawingPanel( WIDTH, HEIGHT );
    Graphics g = panel.getGraphics();

    makeDarkBackground( panel );
    drawCircleStitching( g );
    drawDiamondStitching( g, interval );
    drawHeader( g );
  }

  // Change to dark background
  public static void makeDarkBackground( DrawingPanel p )
  {
    Color c = new Color( 20, 20, 40 );

    p.setBackground( c );
  }

  // Return random grayscale color
  public static Color getRandomGrayColor()
  {
    int randomVal = RANDOM.nextInt( 255 - 128 + 1 ) + 128;

    return new Color( randomVal, randomVal, randomVal );
  }

  // Return random full color
  public static Color getRandomFullColor()
  {
    int randomRed = RANDOM.nextInt( 256 );
    int randomBlue = RANDOM.nextInt( 256 );
    int randomGreen = RANDOM.nextInt( 256 );

    return new Color( randomRed, randomBlue, randomGreen );
  }

  // Draw the circle curve stitching
  public static void drawCircleStitching( Graphics g )
  {
    double slice = 2 * Math.PI / NUM_VERTICES;
    int midX = WIDTH / 2;
    int midY = HEIGHT / 2;

    for( int i = 1; i <= 100; i++ )
    {
      double startAngle = slice * i;
      double x = midX + RADIUS * Math.cos( startAngle );
      double y = midY + RADIUS * Math.sin( startAngle );
      int startX = ( int ) x;
      int startY = ( int ) y;

      double endAngle = slice * ( i + 20 );
      x = midX + RADIUS * Math.cos( endAngle );
      y = midY + RADIUS * Math.sin( endAngle );
      int endX = ( int ) x;
      int endY = ( int ) y;

      g.setColor( getRandomGrayColor() );
      g.drawLine( startX, startY, endX, endY );
    }
  }

  // Draw the diamond curve stitching
  public static void drawDiamondStitching( Graphics g, int interval )
  {
    int midX = WIDTH / 2;
    int midY = HEIGHT / 2;
    int steps = midX / interval;

    for( int i = 0; i <= steps; i++ )
    {
      int startY = i * interval;
      int endX = ( i + 1 ) * interval + midX;

      g.setColor( getRandomFullColor() );
      g.drawLine( midX, startY, endX, midY );

      g.setColor( getRandomFullColor() );
      g.drawLine( midX, HEIGHT - startY, endX, midY );

      endX = midX - ( ( i + 1 ) * interval );

      g.setColor( getRandomFullColor() );
      g.drawLine( midX, startY, endX, midY );

      g.setColor( getRandomFullColor() );
      g.drawLine( midX, HEIGHT - startY, endX, midY );
    }
  }

  // Draw the header on the panel
  public static void drawHeader( Graphics g )
  {
    g.setColor( new Color( 220, 100, 100 ) );
    g.setFont( new Font( "Monospaced", Font.BOLD, 15 ) );
    g.drawString( "Lab 3 by Kevin Wilson", 10, HEIGHT - 10 );
  }
}
