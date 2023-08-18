package Domain.UseCase;

import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;
import Domain.Entity.WordClass;

import java.util.Scanner;

public class HangmanGameUseCase {

    private PlayerClass playerOne;
    private PlayerRepository playerRepository;
    private WordClass wordGen;
    private StringBuilder wordTemp = new StringBuilder("-----");

    public HangmanGameUseCase(WordClass wordGen, PlayerRepository playerRepository) {
        this.wordGen = wordGen;
        this.playerRepository = playerRepository;
    }

    public void setPlayerOne(PlayerClass playerOne) {
        this.playerOne = playerOne;
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
        wordTemp = new StringBuilder(("-----"));
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------ Regras de pontuação ------------------");
        System.out.print("Acada letra correta você ganhara 10 pontos,\ncaso haja letra repitida você recebera a mesma pontuação!\n--------------------- Boa Sorte! ---------------------");
        for (int i = 7; i > 0; i--) {
            if (!(wordGen.getWord().equals(wordTemp.toString()))) {
                System.out.println("\nVocê tem " + (i) + " tentativas para adivinhar. ");
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
                playerRepository.updateScore(playerOne);

                return;
            }
        }
        System.out.println("Infelizmente suas chances acabaram :((( \nA palavra era: " + wordGen.getWord());
        System.out.println("Pontuação geral: " + playerOne.getScorePlayer()+"\n");
    }


}