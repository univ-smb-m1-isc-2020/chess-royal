package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class ChessRoyaleUser implements UserDetails {

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

    public ChessRoyaleUser(String username, String password) {
        this.username = username;

        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<ChessRoyaleParticipant> getUserParticipants() {
        return userParticipants;
    }

    public void setUserParticipants(Set<ChessRoyaleParticipant> userParticipants) {
        this.userParticipants = userParticipants;
    }

    @Override
    public String toString() {
        return "ChessRoyaleUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lichessAPIToken='" + lichessAPIToken + '\'' +
                ", userParticipants=" + userParticipants +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
