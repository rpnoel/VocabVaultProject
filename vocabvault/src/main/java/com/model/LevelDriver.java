package com.model;
import java.util.Scanner;

public class LevelDriver {
    public static void main(String[] args) {
        BookReader reader = new BookReader("VocabVault\\txt\\goldilocksESP.txt");
        Scanner scan = new Scanner(System.in);
        Level level = new Level(1, reader.getBook());
        for (int i = 0; i < 12; i++) {
            if (i == 3 || i == 7 || i == 11) {
                Question currQ = level.getQuestion(4);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            } else if (i == 2 || i == 6 || i == 10) {
                Question currQ = level.getQuestion(3);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            } else if (i == 1 || i == 5|| i == 9) {
                Question currQ = level.getQuestion(2);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            } else {
                Question currQ = level.getQuestion(1);
                System.out.println(currQ.toString());
                String userInput = scan.nextLine();
                Boolean corr = currQ.checkAnswer(userInput);
                level.score(corr);
            }
        }
        System.out.println("Your score: " + level.getScore() + " / " + level.getQNum());
    }
}
