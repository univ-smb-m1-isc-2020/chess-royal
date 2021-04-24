package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ChessRoyaleParticipant implements Serializable {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private String name; //username
    private int score;//for testing
    private int lifePoints;

    @ManyToOne
    @JoinColumn(nullable=false)
    private ChessRoyaleUser userAccount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ChessRoyaleGame chessRoyaleGame;

    //Constructors

    public ChessRoyaleParticipant() {
        // keep empty for JPA
    }

    public ChessRoyaleParticipant(ChessRoyaleUser userAccount) {
        this.userAccount = userAccount;
        this.name = userAccount.getUsername();
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore()
    {
        this.score += 9000;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
