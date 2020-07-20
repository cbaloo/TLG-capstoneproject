package gamemap;

import java.io.IOException;
import java.util.*; //CB- used fro ArrayList
import gameobjects.Apprenti;
import gameobjects.Level;
//import jdk.swing.interop.SwingInterOpUtils;
import leveldirection.Direction;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;



public class GameMap extends Quiz{

    private  ArrayList <Level>map; // CB- here we are using map as an ArrayList of Levels
    private Apprenti player; //

    List<String> commands = new ArrayList<>(Arrays.asList("take", "answer","move", "n", "s", "w", "e"));
    List<String> objects = new ArrayList<>(Arrays.asList("quiz", "guitar", "presentation"));
   //changes
    Scanner userInput = new Scanner(System.in);
    HashMap<String, String> javaQuiz = new HashMap<String, String>();
    HashMap<String, String> javaQuizRev = new HashMap<String, String>();
   // HashMap<String, String> jsQuiz = new HashMap<String, String>();
    //HashMap<String, String> dsQuiz = new HashMap<String, String>();
   // HashMap<String, String> liQuiz = new HashMap<String, String>();
    //HashMap<String, String> pyQuiz = new HashMap<String, String>();
    //HashMap<String, String> caQuiz = new HashMap<String, String>();
    //HashMap<String, String> resultFail = new HashMap<String, String>();

    public void getQuizEveryClass() throws IOException {

        int x = 1;
        String jv1 = "Guitar";
        String jv2 = "Guitar";
        do {
            try {
                javaQuiz.put("Guitar", "What's Jay's passion besides teaching?");
                javaQuizRev.put("What's Jay's passion besides teaching?", "Guitar");
                //jsQuiz.put("Running", "How does Nelly keep himself fit?");
                //dsQuiz.put("Hi-jack", "What's Tom's funny story?");
                //liQuiz.put("AWS", "What other subject John teach besides Linux");
                //pyQuiz.put("Gang", "What's Zach's favourite word");
                //caQuiz.put("Casablanca", "What's Rennie's favourite movie");


                System.out.println("Welcome to TLG AMAZING MAZE, your first class is JAVA with Jay!");
                System.out.println("To Move to next class you need to pass the java quiz");

                System.out.println(javaQuiz.get("Guitar"));
                setQuizAnswer(userInput.nextLine());

            } catch (Exception e) {

                System.out.println("\n" + "Invalid user input, please type text only" + "\n");
                x = 2;

            }
           // for (Map.Entry<String, String> entry : javaQuiz.entrySet()) {

                //if (entry.getKey().equals(getQuizAnswer()))
                // && entry.getValue() == javaQuizRev.get("Guitar"))
                   if ( jv1.equals(jv2))
                    {

                    //if (javaQuiz.containsKey("jv")) {

                    System.out.println("You have passed, move to next class, press : W");

                }


            System.out.println("\n" + "Sorry, you have failed" + "\n");
        } while (x == 1);
    }

// changes
    public GameMap() {

        this.map = new ArrayList<Level>();//CB- making the map Generic list of Level
        //constructing a new adventure
        //Add levels to the map

        map.add(new Level("Java", "Java class with Jay! You need to pass the quiz to move to JavaScript class", Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT));
        map.add(new Level("JavaScript", "JS class with Nelly! You need to pass the quiz to move to Linux/AWS class ", Direction.NOEXIT, Direction.NOEXIT, 2, Direction.NOEXIT));
        map.add(new Level("Linux", "Linux/AWS class with John! You need to pass the quiz to move to Algorithm/Datastructures class", Direction.NOEXIT, Direction.NOEXIT, 3,Direction.NOEXIT));
        map.add(new Level("Algorithm", "Algorithm class with Tom! You need to pass the quiz to move to Capstone class", Direction.NOEXIT, Direction.NOEXIT, 4, Direction.NOEXIT));
        map.add(new Level("Capstone", "Agile/Capstone class with Rennie! You need to pass the quiz to move to your destination at AMAZON'S OJT", Direction.NOEXIT, Direction.NOEXIT, 5, Direction.NOEXIT));
        map.add(new Level("AmazonOJT", "CONGRATULATIONS!! YOU DESERVE IT!! Welcome to AMAZON'S OJT! HURRAY!!! GET SET FOR ANOTHER ADVENTURE, YES YOU ARE NOT DONE YET! IT'S ALWAYS A DAY 1 ", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
//CB- Below creating the player and placing in a Level Java ie the Level at 0 index of map)
        player = new Apprenti("player", "Welcome to TLG!! You are in Java class", map.get(0));
    }
    //access methods
    //map
    ArrayList getMap() {
        return map;
    }

    void setMap(ArrayList aMap) {
        map = aMap;

    }
    // player
      public Apprenti getPlayer() {
        return player;
    }
    public void setPlayer(Apprenti aPlayer) {
    player = aPlayer;
    }

    //moving a Person to a Room or Level
void moveApprentiTo(Apprenti p, Level aLevel) {

        p.setLevel(aLevel);

    }

    // moving Player in direction 'dir'

    int moveTo(Apprenti anApp, Direction dir) {

        //return should be : Constant representing the room or the level number moved to, or NOEXIT
        //Also moving can be any Person need not be the player in direction dir

        Level l = anApp.getLevel();
        int exit;

        switch (dir) {
            case NORTH :
                exit = l.getN();
                break;
            case SOUTH :
                exit = l.getS();
                break;
            case EAST :
                exit = l.getE();
                break;
            case WEST :
                exit = l.getW();
                break;
            default :
                exit = Direction.NOEXIT; //CB- NOEXIT which means stay in the same room or level
                break;
        }

        if (exit !=Direction.NOEXIT) {

            moveApprentiTo(anApp, map.get(exit));

        }

        return exit;

    }

    public int movePlayerTo(Direction dir) {

        // CB- now return: Constant representing the room number moved to or NOEXIT CHECK moveTo()

        return moveTo(player, dir);

    }

    private void goN() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

     private void goS() {
         updateOutput(movePlayerTo(Direction.SOUTH));
     }

     private void goW() {
         updateOutput(movePlayerTo(Direction.WEST));
     }

      private void goE() {
          updateOutput(movePlayerTo(Direction.EAST));
    }

     void updateOutput(int levelNumber) {

        //WHEN level or room is equal to NOEXIT then should display a diff message
         // or else display text which is name and description of room or level
        String S;
        if (levelNumber == Direction.NOEXIT) {

            S = "You can't Exit!";
        } else {

            Level l = getPlayer().getLevel();
            S = "You are in" + " " + l.getName() + ". " + l.getDescription();

            //new StringBuilder().append(S - " You are in the class").append(l.getName()).append(", ").append(l.getDescription()).toString();
        }
         System.out.println(S);
    }

    public String ProcessVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {

            msg = verb + "Please enter valid verb!";
        } else {

            switch (verb) {
                case "n":
                    goN();
                    break;
                case "s":
                    goS();
                    break;
                case "w":
                    goW();
                    break;
                case "e":
                    goE();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;

    }

    public String ProcessVerbNoun(List<String> wordlist) {

        String verb;
        String noun;
        String msg = "";
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {

            msg = verb + "Please enter a valid verb!";
        }

        if (!objects.contains(noun)) {

            msg = verb + (" Please enter a valid noun!");
        }
        msg += " (not implemented)";
        return msg;
    }

    public String ParseCommand(List<String> wordlist) {

        String msg;

        if (wordlist.size() == 1) {

            msg = ProcessVerb(wordlist);
        } else if (wordlist.size() == 2) {

            msg = ProcessVerbNoun(wordlist);
        } else {
            msg = "WARNING!!! ONLY 2 WORD COMMANDS ALLOWED!!";
        }
        return msg;

    }
   public List<String> WordList(String input) {

        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {

           t = tokenizer.nextToken();
           strlist.add(t);
       }
       return strlist;

   }
    public String RunCommand(String inputstr) {
        List<String> wordlist;
        String S = "ok";
        String lowstr = inputstr.trim().toLowerCase();

        if (lowstr.equals("")) {
            S = "You must enter a command";
        } else {
            wordlist =WordList(lowstr);

            wordlist.forEach((astr) -> System.out.println(astr));
            ParseCommand(wordlist);
        }
        return S;
    }
}



/*
 public class UserInput {

        public static void ParseCommand(List<String> worldlist) {

            String verb;
            String noun;
            List<String> commands = new ArrayList<>(Arrays.asList("take", "answer","move"));
            List<String> objects = new ArrayList<>(Arrays.asList("quiz", "guitar", "presentation"));
            if(worldlist.size()>2) {

                 System.out.println("Allowed 2 word commands only");
        } else {
                verb = worldlist.get(0);
                if (!commands.contains(verb)) {
                    System.out.println(verb + " is not a known verb!");
                }
            }
    }

    public static List<String> WordList(String input) {

        String delims = " \t, .:?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;
        while (tokenizer.hasMoreTokens()) {

            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public String RunCommand(String input) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = input.trim().toLowerCase();

        if (lowstr.equals(""))
            s = "You must enter a command";
    } else {
        wordlist =WordList(lowstr);
        wordlist.forEach(astr(->System.out.println(astr));
        ParseCommand(wordlist);
    }
    return s;
}

}
 */