package Repository;

import Domain.Abstract.PlayerRepository;
import Domain.Entity.PlayerClass;
import Infra.DAO;

public class PlayerRepositoryImpl implements PlayerRepository {
    private DAO dao = new DAO();
    @Override
    public PlayerClass findPlayer(String email, String password) {
        return dao.loginPlayer(email,password);
    }

    @Override
    public void addPlayer(PlayerClass playerClass) {
        dao.addPlayer(playerClass);
    }

    @Override
    public void updateScore(PlayerClass playerClass) {
        dao.incrementScore(playerClass);
    }
}
