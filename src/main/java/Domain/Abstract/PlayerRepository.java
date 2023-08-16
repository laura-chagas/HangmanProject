package Domain.Abstract;

import Domain.Entity.PlayerClass;

public interface PlayerRepository {
    public PlayerClass findPlayer(String email,String password);
    public void addPlayer(PlayerClass playerClass);
}
