package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleUserService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ChessRoyaleUserTest {

    ChessRoyaleUser user;
    ChessRoyaleGame game;
    ChessRoyaleParticipant participant;

    @BeforeEach
    public void setup() throws Exception {
        user = new ChessRoyaleUser("username", "test", "testToken");
        game = new ChessRoyaleGame("game");
        participant = new ChessRoyaleParticipant(user);
    }

    @Test
    void subscribe() {
        user.subscribe(game);
        List<String> usernames = game.getParticipants()
                .stream()
                .map(ChessRoyaleParticipant::getAccountUsername)
                .collect(Collectors.toList());
        assert(usernames.contains("username"));
    }

    @Test
    void testId() {
        user.setId(93L);

        assertEquals(user.getId(), 93);
    }

    @Test
    void getUsername() {
        assertEquals(user.getUsername(), "username");
    }

    @Test
    void setUsername() {
        user.setUsername("toto");

        assertEquals(user.getUsername(), "toto");
    }

    @Test
    void getPassword() {
        assertEquals(user.getPassword(), "test");
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