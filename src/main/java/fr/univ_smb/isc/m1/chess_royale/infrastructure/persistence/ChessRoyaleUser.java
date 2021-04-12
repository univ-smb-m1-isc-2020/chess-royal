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

    public ChessRoyaleUser() {
        // keep empty for JPA
    }

    public ChessRoyaleUser(String name, String hash) {
        this.name = name;
        this.hash = hash;
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
