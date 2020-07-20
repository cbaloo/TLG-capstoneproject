package client;

import java.util.Scanner;
import gamemap.GameMap;
import gamemap.Quiz;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmazingMaze extends GameMap {
    public static void main(String[] args) throws IOException {

        BufferedReader in;
        String input;
        String output;
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

