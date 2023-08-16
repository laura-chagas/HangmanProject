package Domain.Service;

import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;

import java.util.Scanner;

public class RegisterService {
    private PlayerRepository playerRepository;
    public RegisterService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public PlayerClass registerPlayer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String name = scan.nextLine();
        System.out.println("Digite seu email:");
        String email = scan.next();
        System.out.println("Digite sua senha: ");
        String password = scan.next();

        PlayerClass playerClass = new PlayerClass();
        playerClass.setEmail(email);
        playerClass.setSenha(password);
        playerClass.setScorePlayer(0);
        playerClass.setNamePlayer(name);
        playerClass.setId(3);
        playerRepository.addPlayer(playerClass);
        return playerClass;
    }
}
