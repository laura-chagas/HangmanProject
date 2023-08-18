import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;
import Domain.Service.HangmanGameUseCase;
import Domain.Service.LoginServiceUseCase;
import Domain.Service.RegisterServiceUseCase;
import Repository.PlayerRepositoryImpl;
import Service.WordGeneratorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        PlayerRepository playerRepository = new PlayerRepositoryImpl();
        HangmanGameUseCase hangmanGame = new HangmanGameUseCase(WordGeneratorService.generatorWord(),playerRepository);
        PlayerClass playerClass =menuPrincipal();
        while (true){
            System.out.println("1-Jogar\n2-Ver meus pontos\n3-Sair");
            switch (scan.next()){
                case "1":{
                    hangmanGame.setPlayerOne(playerClass);
                    hangmanGame.playGame();
                    break;
                }
                case "2":{
                    System.out.println("Pontos do "+playerClass.getNamePlayer()+": "+playerClass.getScorePlayer());
                   break;
                }
                case "3":{
                    System.exit(0);
                }
            }
        }
    }

    public static PlayerClass menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        PlayerRepository playerRepository = new PlayerRepositoryImpl();
        RegisterServiceUseCase registerService = new RegisterServiceUseCase(playerRepository);
        LoginServiceUseCase loginService = new LoginServiceUseCase(playerRepository);
        PlayerClass playerClass =null;
        System.out.println("1-Registrar\n2-Loggin\n3-Sair");
        switch (scan.next()){
            case "1":{
                playerClass = registerService.registerPlayer();
                break;
            }
            case "2":{
                playerClass =loginService.loginPlayer();
                break;
            }
            case "3":{
                System.exit(0);
            }
            }
            return playerClass;
        }
    }

