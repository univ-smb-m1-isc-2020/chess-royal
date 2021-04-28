package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChessRoyaleGameTest {


    private fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleGame chessRoyaleGameInstance;

    @BeforeEach
    public void setup() throws Exception {
        chessRoyaleGameInstance = new ChessRoyaleGame("gameNameTest");
    }

    @Test
    void getId() {
        Long _long = 111111111111111111L;
        chessRoyaleGameInstance.setId(_long);
        assertEquals(_long, chessRoyaleGameInstance.getId());
    }

    @Test
    void setName() {
        chessRoyaleGameInstance.setName("NewGameName");
        assertEquals("NewGameName",chessRoyaleGameInstance.getName());
    }

    @Test
    void getStartDate() {
        Date _dateTest = new Date();
        chessRoyaleGameInstance.setStartDate(_dateTest);
        assertEquals(_dateTest, chessRoyaleGameInstance.getStartDate());
    }

    @Test
    void setStartDate() {
        Date _dateTest = new Date();
        chessRoyaleGameInstance.setStartDate(_dateTest);
        assertEquals(_dateTest, chessRoyaleGameInstance.getStartDate());
    }


    @Test
    void setParticipants() {
        ChessRoyaleUser _userTest = new ChessRoyaleUser("username", "password", "token");
        ChessRoyaleParticipant _participantTest = new ChessRoyaleParticipant(_userTest);
        List<ChessRoyaleParticipant> _participantsListTest = new ArrayList<>();
        _participantsListTest.add(_participantTest);
        chessRoyaleGameInstance.setParticipants(_participantsListTest);

        List<ChessRoyaleParticipant> _participantsListWitness = new ArrayList<>();
        _participantsListWitness.add(_participantTest);

        assertEquals(_participantsListWitness,chessRoyaleGameInstance.getParticipants());
    }

}