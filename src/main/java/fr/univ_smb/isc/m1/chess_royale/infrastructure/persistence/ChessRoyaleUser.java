package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ChessRoyaleUser {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private String name; //username
    private String hash; //hashed password
    private int score;//for testing
    private String lichessAPIToken; //token to access the lichess API token

    public ChessRoyaleUser() {
        // keep empty for JPA
    }

    public ChessRoyaleUser(String name, String hash) {
        this.name = name;
        this.hash = hash;
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

    public String getHash()
    {
        return this.hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
