package com.reecebedding;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Rock paper scissors");
        Scanner scanner = new Scanner(System.in);

        GameManager manager = new GameManager();

        while(true){

            Choices.Option userOption;

            try {
                System.out.print("Make a choice: ");
                String userChoice = scanner.nextLine();

                if (userChoice.isEmpty())
                    continue;

                userOption = Choices.GetOptionFromChoice(userChoice);
            } catch (InvalidPropertiesFormatException exn){
                System.out.println("Invalid choice.");
                continue;
            }

            manager.ManageResult(userOption);
            printScore(manager);
            System.out.println();
        }
    }

    private static void printScore(GameManager manager){

        StringBuilder builder = new StringBuilder(50);
        builder.append("You: ");
        builder.append(manager.getUserScore());
        builder.append(" - ");
        builder.append("Opponent: ");
        builder.append(manager.getAIScore());

        System.out.println(builder.toString());
    }
}
