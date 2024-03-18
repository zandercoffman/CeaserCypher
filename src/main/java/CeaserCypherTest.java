import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class CeaserCypherTest {
  public final static Scanner in = new Scanner(System.in);
  public static Map<Character, Byte> alphabet = new HashMap<Character, Byte>();

  public static boolean init() {
    try {
      byte a = 0;
      for (char c = 'a'; c <= 'z'; c++) {
        alphabet.put(c, a);
        a++;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  private static void setupR() {
    System.out.println("What rotation would you like to set the program to have?");
    String s = in.next();
    try {
      int rotation = Integer.parseInt(s);
      if (rotation < 1 || rotation > 25) {
        throw new Exception();
      }
      CeaserCypher.setRotation(rotation);
    } catch (Exception e) {
      System.out.println("Please enter a valid input.");
    }
  }

  private static void changeR() {
    boolean r = true;
    while (r) {
      System.out.println("Would you like to change the rotation? (true/false)");
      String s = in.next();
      switch(s.toLowerCase()) {
        case "true":
          setupR();
          r = false;
          break;
        case "false":
          r = false;
          break;
        default:
          System.out.println("Please put a valid statement.");
          break;
      }
    }
  }

  public static void main(String[] args) {
    if (!init()) {
      System.exit(1);
    }

    boolean canRun = true;

    while (canRun) {
      boolean needToAskInput = true;
      while (needToAskInput) {
        System.out.println("What do you want to do?");
          System.out.println("Q. quit");
          System.out.println("E. encrypt");
          System.out.println("D. decrypt");

          String input = in.next();
          char choice = input.toLowerCase().charAt(0);
          String gotten;
          String[] arr;

          switch (choice) {
              case 'q':
                  System.exit(0);
                  break;
              case 'e':
                  // Handle encryption
                if (!CeaserCypher.hasSetRotation) {
                  System.out.println("First, we need to setup a rotation for this program.");
                  setupR();
                } else {
                  changeR();
                }

                System.out.println("Give me a string you would like to work with:\n");

                gotten = in.next();

                arr = gotten.split(" ");
                System.out.println(gotten + "-" + arr + "Encrypted String: ");

                for (String s : arr) {
                  System.out.print(s + "-" + CeaserCypher.encrypt(s));
                }

                needToAskInput = false;
                  break;
              case 'd':
                  // Handle decryption
                if (!CeaserCypher.hasSetRotation) {
                  System.out.println("First, we need to setup a rotation for this program.");
                  setupR();
                } else {
                  changeR();
                }

                System.out.println("Give me a string you would like to work with: ");
                gotten = in.next();

                System.out.println("Decrypted String: " + CeaserCypher.decrypt(gotten));

                needToAskInput = false;
                  break;
              default:
                  System.out.println("Invalid choice. Please try again.");
                  break;
          }
      }
      // not gonna lie this looks like tuff code frfr ong frfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrfrffrfrfrfrfrfrrfrfrfrfrfr
    }
}}
