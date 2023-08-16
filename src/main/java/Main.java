import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;
import Domain.Service.HangmanGame;
import Domain.Service.LoginService;
import Domain.Service.RegisterService;
import Repository.PlayerRepositoryImpl;
import Service.WordGeneratorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        PlayerRepository playerRepository = new PlayerRepositoryImpl();
        RegisterService registerService = new RegisterService(playerRepository);
        LoginService loginService = new LoginService(playerRepository);
        PlayerClass playerClass =new  PlayerClass();
        HangmanGame hangmanGame = new HangmanGame(playerClass,WordGeneratorService.generatorWord());
        while (true){
            System.out.println("1-Registrar\n2-Loggin\n3-Jogar\n4-Sair");
            switch (scan.next()){
                case "1":{
                    registerService.registerPlayer();
                    break;
                }
                case "2":{
                    loginService.loginPlayer();
                    break;
                }
                case "3":{
                    hangmanGame.playGame();
                    break;
                }
                case "4":{
                    System.exit(0);
                }
            }
        }
    }
}
