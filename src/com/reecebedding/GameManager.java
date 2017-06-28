package com.reecebedding;

import java.util.Random;

public class GameManager {

    private int aiScore;
    private int userScore;

    public int getAIScore(){
        return  aiScore;
    }

    public int getUserScore(){
        return userScore;
    }

    private Choices.Option GenerateAiResponse(){

        Random randomizer = new Random();
        int randomChoice = randomizer.nextInt(Choices.OPTIONS.length);

        return Choices.OPTIONS[randomChoice];
    }

    public void ManageResult(Choices.Option userOption){
        Choices.Option aiAnswer = GenerateAiResponse();
        System.out.println("Opponent chose: " + aiAnswer.GetName());

        int result = userOption.compareTo(aiAnswer);

        switch (result){
            case -1:
                System.out.println("You lose!");
                aiScore++;
                break;
            case 0:
                System.out.println("You drew!");
                break;
            case 1:
                System.out.println("You win!");
                userScore++;
                break;
        }
    }
}
