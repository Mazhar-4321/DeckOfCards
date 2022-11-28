package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to deck of Card Games");
        DeckOfcards deckOfcards = new DeckOfcards();
        deckOfcards.shuffleCards();
        deckOfcards.showCards();
    }
}
