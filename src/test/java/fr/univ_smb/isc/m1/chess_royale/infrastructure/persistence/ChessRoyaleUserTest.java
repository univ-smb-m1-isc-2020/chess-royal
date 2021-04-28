package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleUserService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(usernames.contains("username")).isTrue();
    }

    @Test
    void testId() {
        user.setId(93L);

        assertEquals(93, user.getId());
    }

    @Test
    void getUsername() {
        assertEquals("username", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("toto");

        assertEquals("toto", user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("test", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("tin");

        assertEquals("tin", user.getPassword());
    }

    @Test
    void getLichessAPIToken() {
        assertEquals("testToken", user.getLichessAPIToken());
    }

    @Test
    void setLichessAPIToken() {
        user.setLichessAPIToken("toast");

        assertEquals("toast", user.getLichessAPIToken());
    }

    @Test
    void getRoles() {
        assertEquals("USER", user.getRoles());
    }

    @Test
    void setRoles() {
        user.setRoles("ADMIN");
        assertEquals("ADMIN", user.getRoles());
    }
}