package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckOfcards {
    private Map<Integer,String> cardsMap= new HashMap<>();
    private Map<Integer, ArrayList<String>> playersMap = new HashMap<>();
    DeckOfcards(){
        for(int i=2;i<=9;i++){
            String cardName="";
            switch(i){
                case 2:cardName="Clubs";break;
                case 3:cardName="Diamonds";break;
                case 4:cardName="Hearts";break;
                case 5:cardName="Spades";break;
                case 6:cardName="Jack";break;
                case 7:cardName="Queen";break;
                case 8:cardName="King";break;
                case 9:cardName="Ace";break;
            }
            cardsMap.put(i,cardName);
        }

        playersMap.put(1,new ArrayList<String>());
        playersMap.put(2,new ArrayList<String>());
        playersMap.put(3,new ArrayList<String>());
        playersMap.put(4,new ArrayList<String>());
    }
    public void shuffleCards(){
        int cardCount=36;
        int i=0;
        while (cardCount>0){
          int randomNumber=  generateRandomNumber();
          ArrayList<String> cardsList=playersMap.get(i%4+1);
              cardsList.add(cardsMap.get(randomNumber));
         i++;
          cardCount--;
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * (9 - 2 + 1)) + 2;
    }
    public void showCards(){
        for(int i=1;i<=4;i++){
            System.out.println(playersMap.get(i));
        }
    }

}
