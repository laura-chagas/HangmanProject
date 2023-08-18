package Domain.UseCase;

import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;

import java.util.Scanner;

public class LoginUseCase {
    private PlayerRepository playerRepository;
    public LoginUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public PlayerClass loginPlayer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu email:");
        String email = scan.next();
        System.out.println("Digite sua senha: ");
        String password = scan.next();
        PlayerClass playerClass = playerRepository.findPlayer(email,password);
        return playerClass;
    }
}
