package com.company;

import java.util.Scanner;

public class Main {
    private static final int CARD_SHUFFLE = 1;
    private static final int SHOW_CARDS = 2;
    private static final int SORT_IN_ASCENDING_ORDER = 3;
    private static final int SORT_IN_DESCENDING_ORDER = 4;
    private static final int START_NEW_GAME = 5;
    private static final int EXIT = 6;
    private static final Scanner scanner = new Scanner(System.in);
    private DeckOfcards deckOfcards;
    private boolean isShuffled = false;
    private boolean isSortedInAscendingOrder=false;
    private boolean isSortedInDescendingOrder=false;
    private boolean isCardDistributed=false;

    public static void main(String[] args) {
        System.out.println("Welcome to deck of Card Games");
        Main main = new Main();
        main.deckOfcards = new DeckOfcards();
        main.options(main);
    }

    private void options(Main main) {
        while (true) {
            System.out.println("Enter 1 for Card Shuffle, 2 for Show Cards,3 for Sort Cards in Ascending order\n  4 for" +
                    "Sort Cards in Descending Order , 5 for starting new Game, 6 for exit");
            int option = scanner.nextInt();
            switch (option) {
                case CARD_SHUFFLE:
                    shuffleCards();
                    break;
                case SHOW_CARDS:
                    showCards();
                    break;
                case SORT_IN_ASCENDING_ORDER:
                    sortInAscendingOrder();
                    break;
                case SORT_IN_DESCENDING_ORDER:
                    sortInDescendingOrder();
                    break;
                case START_NEW_GAME:
                    startNewGame();
                    break;
                case EXIT:
                    System.out.println("See U Again");
                    return;

            }
        }
    }

    private void startNewGame() {
        if(!isShuffled){
            System.out.println("You Are Already in a new Game");
            printLines();
            return;
        }
        System.out.println("Cards taken from Players and Ready for Next Play");
        deckOfcards = new DeckOfcards();
        isShuffled = false;
        isSortedInAscendingOrder=false;
        isSortedInDescendingOrder=false;
        isCardDistributed=false;
        printLines();
    }

    private void sortInDescendingOrder() {
        if(!isSortedInDescendingOrder&&isCardDistributed) {
            deckOfcards.sortByRankDecreasing();
            isSortedInDescendingOrder=true;
            isSortedInAscendingOrder=false;
            printLines();
            return;
        }
        if(!isCardDistributed){
            System.out.println("Please Shuffle The Cards and try this option");
            printLines();
            return;
        }
        System.out.println("Already sorted in Descending Order");
        printLines();
    }

    private void sortInAscendingOrder() {
        if(!isSortedInAscendingOrder&&isCardDistributed) {
            deckOfcards.sortByRankIncreasing();
            isSortedInAscendingOrder=true;
            isSortedInDescendingOrder=false;
            printLines();
            return;
        }
        if(!isCardDistributed){
            System.out.println("Please Shuffle The Cards and try this option");
            printLines();
            return;
        }
        System.out.println("Already sorted in Ascending Order");
        printLines();
    }

    private void showCards() {
        if(isCardDistributed){
            deckOfcards.show();
            printLines();
            return;
        }
        System.out.println("Cards are not yet Shuffled , Please Shuffle and check this option");
        printLines();
    }

    private void shuffleCards() {
        if (!isShuffled) {
            deckOfcards.cardShuffle();
            isCardDistributed=true;
            printLines();
            isShuffled = true;
            return;
        }
        System.out.println("Cards Already Shuffled");
        printLines();
    }

    private void printLines() {
        System.out.println("---------------------------------------------");
    }
}
