package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import fr.univ_smb.isc.m1.chess_royale.adapters.api.ChessRoyaleController;
import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ChessRoyaleParticipantTest {

    private fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleParticipant ChessRoyaleParticipantInstance;

    @BeforeEach
    public void setup() throws Exception {
        ChessRoyaleUser userTest = new ChessRoyaleUser("NomTest", "none","token");
        this.ChessRoyaleParticipantInstance = new ChessRoyaleParticipant(userTest);
    }

    @Test
    @DisplayName("Increment the participant score.")
    void incrementScore() {
        ChessRoyaleParticipantInstance.incrementScore(2);
        assertEquals(2, ChessRoyaleParticipantInstance.getScore() );

    }

//    @Test
//    void decreaseLifePoints() {
//    }
//
//    @Test
//    void subscribe() {
//    }
//
//    @Test
//    void getId() {
//    }
//
//    @Test
//    void setId() {
//    }
//
//    @Test
//    void getAccountUsername() {
//    }
//
//    @Test
//    void setAccountUsername() {
//    }
//
//    @Test
//    void getScore() {
//    }
//
//    @Test
//    void setScore() {
//    }
//
//    @Test
//    void getLifePoints() {
//    }
//
//    @Test
//    void setLifePoints() {
//    }
//
//    @Test
//    void getChessDuels() {
//    }
//
//    @Test
//    void addChessDuel() {
//    }
}