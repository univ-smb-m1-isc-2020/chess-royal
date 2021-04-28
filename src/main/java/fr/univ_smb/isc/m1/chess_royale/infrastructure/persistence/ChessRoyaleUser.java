package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import javax.persistence.*;
import java.util.*;

@Entity
public class ChessRoyaleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String lichessAPIToken; //token to access the lichess API token
    private String roles;

    @OneToMany
    private Set<ChessRoyaleParticipant> userParticipations;

    public ChessRoyaleUser() {
        // keep empty for JPA
    }

    public ChessRoyaleUser(String username, String password, String lichessAPIToken)
    {
        this.username = username;
        this.password = password;
        this.lichessAPIToken = lichessAPIToken;
        this.roles = "USER";

        this.userParticipations = new HashSet<>();
    }

    public void subscribe(ChessRoyaleGame chessRoyaleGame)
    {
        var participant = new ChessRoyaleParticipant(this);
        participant.subscribe(chessRoyaleGame);
        this.userParticipations.add(participant);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLichessAPIToken() {
        return lichessAPIToken;
    }

    public void setLichessAPIToken(String lichessAPIToken) {
        this.lichessAPIToken = lichessAPIToken;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
