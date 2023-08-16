package Domain.Service;

import Domain.Entity.PlayerClass;
import Domain.Entity.WordClass;

import java.util.Scanner;

public class HangmanGame {

    private PlayerClass playerOne;
    private WordClass wordGen;
    private StringBuilder wordTemp = new StringBuilder("-----");

    public HangmanGame(PlayerClass playerOne, WordClass wordGen) {
        this.playerOne = playerOne;
        this.wordGen = wordGen;
    }

    private Boolean findChar(String letter) {

        return wordGen.getWord().contains(letter);
    }

    private void compareLetter(String letter) {
        for (int i = 0; i < wordGen.getWord().length(); i++) {
            if (wordGen.getWord().charAt(i) == (letter.toCharArray())[0]) {
                wordTemp.setCharAt(i, (letter.toCharArray())[0]);
            }
        }
    }

    private void scoreCount() {
        playerOne.setScorePlayer(playerOne.getScorePlayer() + 10);
    }

    public void playGame() {
        Scanner scan = new Scanner(System.in);

        for (int i = 7; i > 0; i--) {
            if (!(wordGen.getWord().equals(wordTemp.toString()))) {
                System.out.println("Você tem " + (i) + " tentativas para adivinhar. ");
                System.out.println("Adivinhe a palavra: ");
                System.out.println(wordTemp);
                System.out.println("Informe uma letra: ");
                String letterIn = scan.next();

                if (findChar(letterIn)) {
                    scoreCount();
                    compareLetter(letterIn);
                }
                System.out.println(wordTemp);
            }else {
                System.out.println("Parabéns, você acertou a palavra :)) ");
                System.out.println("Seus pontos: " + playerOne.getScorePlayer());
                return;
            }

        }
        System.out.println("Infelizmente suas chances acabaram :((( \nA palavra era: " + wordGen.getWord());

    }

    public static void main(String[] args) {
        PlayerClass newPlayer = new PlayerClass();
        newPlayer.setNamePlayer("Laura");
        WordClass word = new WordClass();
        word.setWord("amora");

        HangmanGame newGame = new HangmanGame(newPlayer, word);
        newGame.playGame();

    }
}