package com.reecebedding;

import java.util.InvalidPropertiesFormatException;

public class Choices {

    public static Option[] OPTIONS = {
            new Rock(),
            new Paper(),
            new Scissors()
    };

    public static Option GetOptionFromChoice(String option) throws InvalidPropertiesFormatException {

        switch (option.toLowerCase()){
            case "rock":
                return new Rock();
            case "paper":
                return new Paper();
            case "scissors":
                return new Scissors();
            default:
                throw new InvalidPropertiesFormatException("Invalid choice");
        }
    }

    static abstract class Option implements Comparable<Option> {
        abstract String GetName();
        abstract Option WinsAgainst();

        @Override
        public int compareTo(Option o) {
            if(o.GetName() == GetName())
                return 0;
            if(o.GetName() == WinsAgainst().GetName())
                return 1;
            else
                return -1;
        }
    }

    public static class Rock extends Option {

        @Override
        public String GetName() {
            return "rock";
        }

        @Override
        public Option WinsAgainst(){
            return new Scissors();
        }


    }

    public static class Paper extends Option {

        @Override
        public String GetName() {
            return "paper";
        }

        @Override
        public Option WinsAgainst(){
            return new Rock();
        }
    }

    public static class Scissors extends Option {

        @Override
        public String GetName() {
            return "scissors";
        }

        @Override
        public Option WinsAgainst(){
            return new Paper();
        }
    }

}
