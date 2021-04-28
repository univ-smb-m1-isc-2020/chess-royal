package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ChessRoyaleParticipant implements Serializable {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private String accountUsername;

    private int score;//for testing
    private int lifePoints;

    @OneToMany
    private List<ChessDuel> chessDuels = new ArrayList<>();

    //Constructors
    public ChessRoyaleParticipant() {
        // keep empty for JPA
    }

    public ChessRoyaleParticipant(ChessRoyaleUser chessRoyaleUser) {
        this.accountUsername = chessRoyaleUser.getUsername();
        this.score = 0;
        this.lifePoints = 2;
    }

    public void incrementScore(int update)
    {
        this.score += update;
    }

    public void decreaseLifePoints()
    {
        this.lifePoints--;
    }

    public void subscribe(ChessRoyaleGame chessRoyaleGame) {
        chessRoyaleGame.addParticipant(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public List<ChessDuel> getChessDuels() {
        return chessDuels;
    }

    public void setChessDuels(List<ChessDuel> chessDuels) {
        this.chessDuels = chessDuels;
    }
}
