package Domain.Abstract;

import Domain.Entity.PlayerClass;

public interface PlayerRepository {
    PlayerClass findPlayer(String email,String password);
    void addPlayer(PlayerClass playerClass);
    void updateScore(PlayerClass playerClass);
}
