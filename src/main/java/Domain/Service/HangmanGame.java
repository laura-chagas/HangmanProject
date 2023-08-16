package Domain.Service;

import Domain.Entity.PlayerClass;
import Domain.Entity.WordClass;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {

    private PlayerClass playerOne;
    private WordClass wordGen;
    private char[] wordTemp = {'-', '-', '-', '-', '-'};

    public HangmanGame(PlayerClass playerOne, WordClass wordGen) {
        this.playerOne = playerOne;
        this.wordGen = wordGen;
    }
    private Boolean findChar(String letter){

        if (wordGen.getWord().contains(letter)){
            return true;
        }else {
            return false;
        }
    }

    private void showWord(String letter){
        for (int i = 0; i < wordGen.getWord().length(); i++) {
            if (wordGen.getWord().charAt(i) == (letter.toCharArray())[0]) {
                wordTemp[i] = (letter.toCharArray())[0];
            }
        }

    }
    private void scoreCount(){
        playerOne.setScorePlayer(playerOne.getScorePlayer() + 10);
    }

    public void playGame(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Sua palavra possui 5 letras, informe uma: ");
        String letterIn = scan.next();

       if (findChar(letterIn)){
           scoreCount();
           showWord(letterIn);
       }
        System.out.println(wordTemp);

        System.out.println("Seus pontos: " + playerOne.getScorePlayer());
    }

    public static void main(String[] args) {
        PlayerClass eu = new PlayerClass();
        eu.setNamePlayer("Laura");
        WordClass word = new WordClass();
        word.setWord("amora");

        HangmanGame aaa = new HangmanGame(eu,word);
        aaa.playGame();

    }
}
