import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class CeaserCypher {
  /**
  Focus for this is to make it point towards the reference of the number its going to be at

  a => 0
  roation of 3
  a => 23

  arrays.length (26) - rotation = newA
  */
  public static boolean hasSetRotation = false;
  private static int rotation = 0;
  private static char characterAtNewRotation;
  public static Map<Character, Byte> newRotationAlphabet = new HashMap<Character, Byte>();

  private static void setupRotation(int rotation) {
    try {
      //Initalize the first one
      byte a = 0;
      newRotationAlphabet.clear();
      //Find the first index (letter) where index - rotation = 0
      //Technically the new a :sob:
      for (Map.Entry<Character, Byte> entry : CeaserCypherTest.alphabet.entrySet()) {
        Character key = entry.getKey();
        Byte value = entry.getValue();

        if ( (byte) value - (byte) rotation == 0) {
          characterAtNewRotation = (char) key; //the new 'a'
          break;
        }
      }

      for (char c = characterAtNewRotation; c <= 'z'; c++) {
        newRotationAlphabet.put(c, a);
        a++;
      }

      for (char c = 'a'; c < characterAtNewRotation; c++) {
        newRotationAlphabet.put(c, a);
        a++;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static boolean isInCharacterList(char c) {
  if (!Character.isAlphabetic(c) || !Character.isLowerCase(c) || c == ' ') {
    return false;
  }

  for (Map.Entry<Character, Byte> entry : CeaserCypherTest.alphabet.entrySet()) {
    Character key = entry.getKey();
    if (key == c) {
      return true;
    }
  }

  return false;
  }

  public static String encrypt(String input) {
    String toReturn = "";
    char[] inputToCharArray = getToCharArray(input);

      for (char c : inputToCharArray) {
      if (isInCharacterList(c)) {
        Byte origin = CeaserCypherTest.alphabet.get(c);
        char newChar = 0;

        for (Map.Entry<Character, Byte> entry : newRotationAlphabet.entrySet()) {
          if (origin == entry.getValue()) {
            newChar = entry.getKey();
          }
        }

        toReturn += "" + newChar;
      } else {
        toReturn += "" + c;
      }
    }

    return toReturn;
  }

  public static String decrypt(String input) {
    String toReturn = "";
    char[] inputToCharArray = getToCharArray(input);

    for (char c : inputToCharArray) {
      if (isInCharacterList(c)) {
        Byte origin = newRotationAlphabet.get(c);
        char originChar = 0;

        for (Map.Entry<Character, Byte> entry : CeaserCypherTest.alphabet.entrySet()) {
          if (origin == entry.getValue()) {
            originChar = entry.getKey();
          }
        }

        toReturn += "" + originChar;
      } else {
        toReturn += "" + c;
      }
    }

    return toReturn;
  }

  private static char[] getToCharArray(String input) {	
  char[] toReturn = new char[input.length()];
  for (int i = 0; i < input.length(); i++) {
    if (input.charAt(i) == ' ') {
      toReturn[i] = ' ';
    } else {
      toReturn[i] = input.charAt(i);
    }
  }
  return toReturn;
  }

public static void setRotation(int r) {
    rotation = r;
    setupRotation(rotation);
    hasSetRotation = true;
  }
}