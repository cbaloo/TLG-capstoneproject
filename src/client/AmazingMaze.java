package client;

import java.awt.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import gamemap.GameMap;
import gamemap.Quiz;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazingMaze extends GameMap {

    public static void main(String[] args) throws IOException {

        BufferedReader in;
        String input;
        String output;
      /*  File file = new File("C:\\Users\\chand\\Documents\\testtlg.txt");
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8.name());
        String content = null;
        try (scanner){
            content = scanner.useDelimiter("\\A").next();

     //   } catch(IOException e){
     //       e.printStackTrace();
        }
        // System.out.println(content);
        System.out.println(content);
*/

        GameMap gameMap = new GameMap();
        gameMap.getQuizEveryClass();

       // public static void title() {
            //System.out.println("Welcome to TLG Amazing Maze");
       // }
        in = new BufferedReader(new InputStreamReader(System.in));
       // gameMap.showIntro();
        do {
            System.out.println("> ");
            input = in.readLine();
            output = gameMap.RunCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));

    }


}

