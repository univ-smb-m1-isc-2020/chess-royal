package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class ChessRoyaleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;
    private String lichessAPIToken; //token to access the lichess API token

    @OneToMany
    private Set<ChessRoyaleParticipant> userParticipants;

    public ChessRoyaleUser() {
        // keep empty for JPA
    }

    public ChessRoyaleUser(String name, String password, String lichessAPIToken) {
        this.username = name;
        this.password = password;
        this.lichessAPIToken = lichessAPIToken;
    }


    public String getUsername() {
        return username;
    }
}
