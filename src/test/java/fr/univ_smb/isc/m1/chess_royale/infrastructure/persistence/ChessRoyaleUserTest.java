package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessRoyaleUserTest {

    private ChessRoyaleGame game = new ChessRoyaleGame("testGame");
    private ChessRoyaleUser user = new ChessRoyaleUser("username", "test", "testToken");

    @BeforeEach
    void setUp() {
    }

    @Test
    void subscribe() {
        //var participant = new ChessRoyaleUserService();

        //user.subscribe(game);
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getLichessAPIToken() {
    }

    @Test
    void setLichessAPIToken() {
    }

    @Test
    void getRoles() {
    }

    @Test
    void setRoles() {
    }
}