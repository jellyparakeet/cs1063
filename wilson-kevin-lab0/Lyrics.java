// Lyrics.java
// Kevin Wilson
// Lab 0 - Print out lyrics to a song

public class Lyrics
{
  // Programs entry point
  public static void main( String [] args)
  {
    printHeader();
    printVerseOne();
    printVerseTwo();
    printChorus();
    printVerseThree();
    printVerseFour();
    printChorus();
    printChorus();
  }

  // Prints the header for the program
  public static void printHeader()
  {
    System.out.print( "Lab 0 written by Kevin Wilson\n" + 
                      "\"Rock and Roll All Nite\" by Kiss\n" + 
                      "Lyrics from http://www.azlyrics.com/lyrics/kiss/rockandrollallnite\n\n" );
  }

  // Prints the chorus
  public static void printChorus()
  {
    System.out.println( "\tYou keep on shouting, you keep on shouting\n" + 
                        "\tI wanna rock and roll all night and party every day\n" + 
                        "\tI wanna rock and roll all night and party every day\n" + 
                        "\tI wanna rock and roll all night and party every day\n" + 
                        "\tI wanna rock and roll all night and party every day\n" );
  }

  // Prints the first verse
  public static void printVerseOne()
  {
    System.out.println( "You show us everything you've got\n" + 
                        "You keep on dancing and the room gets hot\n" + 
                        "You drive us wild, we'll drive you crazy\n" );
  }

  // Prints the second verse
  public static void printVerseTwo()
  {
    System.out.println( "You say you wanna go for a spin\n" + 
                        "The party's just begun, we'll let you in\n" + 
                        "You drive us wild, we'll drive you crazy\n" );
  }

  // Prints the third verse
  public static void printVerseThree()
  {
    System.out.println( "You keep on saying you'll be mine for a while\n" + 
                        "You're looking fancy and I like your style\n" + 
                        "You drive us wild, we'll drive you crazy\n" );
  }

  // Prints the fourth verse
  public static void printVerseFour()
  {
    System.out.println( "You show us everything you've got\n" + 
                        "Baby, baby that's quite a lot\n" + 
                        "And you drive us wild, we'll drive you crazy\n" );
  }
}
