package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ChessRoyaleParticipantTest {

    private fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleParticipant chessRoyaleParticipantInstance;

    @BeforeEach
    public void setup() throws Exception {
        ChessRoyaleUser userTest = new ChessRoyaleUser("NomTest", "none","token");
        this.chessRoyaleParticipantInstance = new ChessRoyaleParticipant(userTest);
    }

    @Test
    @DisplayName("Increment the participant score.")
    void incrementScore() {
        chessRoyaleParticipantInstance.incrementScore(2);
        assertEquals(2, chessRoyaleParticipantInstance.getScore() );
    }

    @Test
    void decreaseLifePoints() {
        chessRoyaleParticipantInstance.decreaseLifePoints();
        assertEquals(1, chessRoyaleParticipantInstance.getLifePoints());
    }

    @Test
    void subscribe() {
        ChessRoyaleGame chessRoyaleGame = new ChessRoyaleGame("game name");
        chessRoyaleParticipantInstance.subscribe(chessRoyaleGame);
        assertTrue(chessRoyaleGame.getParticipants().contains(chessRoyaleParticipantInstance));
    }

    @Test
    void getId() {
        Long _long = 111111111111111111L;
        chessRoyaleParticipantInstance.setId(_long);
        assertEquals(_long, chessRoyaleParticipantInstance.getId());
    }

    @Test
    void getAccountUsername() {
        assertEquals("NomTest", chessRoyaleParticipantInstance.getAccountUsername());
    }

    @Test
    void setAccountUsername() {
        chessRoyaleParticipantInstance.setAccountUsername("nouveauNom");

        assertEquals("nouveauNom", chessRoyaleParticipantInstance.getAccountUsername());
    }


    @Test
    void setScore() {
        chessRoyaleParticipantInstance.setScore(8);
        assertEquals(8, chessRoyaleParticipantInstance.getScore());
    }

    @Test
    void setLifePoints() {
        chessRoyaleParticipantInstance.setLifePoints(6);
        assertEquals(6, chessRoyaleParticipantInstance.getLifePoints());
    }

    @Test
    void getChessDuels() {
        ChessRoyaleUser userTest = new ChessRoyaleUser("nomTest2", "none","token2");
        ChessRoyaleParticipant chessRoyaleParticipantInstance2 = new ChessRoyaleParticipant(userTest);
        ChessDuel _chessDuel = new ChessDuel( chessRoyaleParticipantInstance,  chessRoyaleParticipantInstance2);
        chessRoyaleParticipantInstance.addChessDuel(_chessDuel);
        assertTrue(chessRoyaleParticipantInstance.getChessDuels().contains(_chessDuel));
    }
    
}