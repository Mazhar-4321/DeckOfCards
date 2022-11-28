package com.company;

import java.util.*;

public class Queue {
    private Card head;
    private Card tail;

    public void enqueue(Card card) {
        if (head == null) {
            head = card;
            tail = card;
            return;
        }
        tail.setNext(card);
        tail = card;
    }

    private void addReverse(Card card) {
        if (head == null) {
            head = card;
            tail = card;
            return;
        }
        card.setNext(head);
        head = card;
    }

    public void showCards() {
        Card temp = head;
        while (temp != null) {
            System.out.print(temp.getName() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void sortByRankIncreasingOrder(Map<Integer, String> cardsMap) {
        Card temp = head;
        Map<Integer, Integer> ranksMap = new TreeMap<>();
        while (temp != null) {
            ranksMap.put(temp.getRank(), ranksMap.containsKey(temp.getRank()) ? ranksMap.get(temp.getRank()) + 1 : 1);
            temp = temp.getNext();
        }
        Set<Integer> keyset = ranksMap.keySet();
        Iterator it = keyset.iterator();
        head = null;
        tail = null;
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Integer count = ranksMap.get(key);
            String cardName = cardsMap.get(key);
            int rank = key;
            for (int i = 1; i <= count; i++) {
                Card card = new Card(cardName, rank, null);
                enqueue(card);
            }
        }
    }

    public void sortByRankDecreasingOrder(Map<Integer, String> cardsMap) {
        Card temp = head;
        Map<Integer, Integer> ranksMap = new TreeMap<>();
        while (temp != null) {
            ranksMap.put(temp.getRank(), ranksMap.containsKey(temp.getRank()) ? ranksMap.get(temp.getRank()) + 1 : 1);
            temp = temp.getNext();
        }
        Set<Integer> keyset = ranksMap.keySet();
        Iterator it = keyset.iterator();
        head = null;
        tail = null;
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Integer count = ranksMap.get(key);
            String cardName = cardsMap.get(key);
            int rank = key;
            for (int i = 1; i <= count; i++) {
                Card card = new Card(cardName, rank, null);
                addReverse(card);
            }
        }
    }
}
