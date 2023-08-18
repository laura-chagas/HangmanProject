package Domain.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PLAYER")
public class PlayerClass implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",unique=true,nullable=false)
    private Integer id;
    private String namePlayer;
    private int scorePlayer;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "senha")
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }
}
