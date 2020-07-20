package gamemap;

import java.util.Scanner;

public class Quiz {

    private String quizAnswer;
    private String quizQuestion;
    private boolean pass;

    Scanner userInput = new Scanner (System.in);

    //Getters Setters
    public String setQuizAnswer (String quizAnswer) {
        this.quizAnswer = quizAnswer;
        return quizAnswer;
    }

    public String getQuizAnswer () {
        return quizAnswer;
    }

    public String setQuizQuestion (String quizQuestion) {
        this.quizQuestion = quizQuestion;
        return quizQuestion;
    }

    public String getQuizQuestion () {
        return quizQuestion;
    }



}
