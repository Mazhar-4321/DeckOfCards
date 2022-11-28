package com.company;

public class Card {
    private String name;
    private int rank;
    private Card next;

    public Card(String name, int rank, Card next) {
        this.name = name;
        this.rank = rank;
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Card getNext() {
        return next;
    }

    public void setNext(Card next) {
        this.next = next;
    }
}
