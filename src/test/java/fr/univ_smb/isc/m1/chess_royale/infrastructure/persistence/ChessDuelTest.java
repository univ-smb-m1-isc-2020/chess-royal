package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ChessDuelTest {
    ChessRoyaleParticipant whitePlayer;
    ChessRoyaleParticipant blackPlayer;
    ChessDuel duel;

    @BeforeEach
    void setUp() {
        whitePlayer = new ChessRoyaleParticipant();
        blackPlayer = new ChessRoyaleParticipant();

        duel = new ChessDuel(whitePlayer, blackPlayer);
    }

    @Test
    void should_return_is_not_over() {
        assertFalse(duel.isOver());
    }

    @Test
    void checkIfOver() {
        duel.checkIfOver();
        assertNotEquals(duel.getEndDate(), null);
    }

    @Test
    void updateScores() {
        duel.setResult(ChessDuel.ResultType.DRAW);

        whitePlayer.setScore(0);
        blackPlayer.setScore(0);

        duel.updateScores();

        assertEquals(whitePlayer.getScore(), 1);
        assertEquals(blackPlayer.getScore(), 1);
    }

    @Test
    void test_Id() {
        duel.setId(1L);
        assertEquals(duel.getId(), 1);
    }

    @Test
    void getStartDate() {
        assertNotEquals(duel.getStartDate(), null);
    }

    @Test
    void setStartDate() {
        Date now = new Date();
        duel.setStartDate(now);

        assertEquals(duel.getStartDate(), now);
    }

    @Test
    void testEndDate() {
        Date now = new Date();
        duel.setEndDate(now);

        assertEquals(duel.getEndDate(), now);
    }

    @Test
    void getWhitePlayer() {
        assertEquals(duel.getWhitePlayer(), whitePlayer);
    }

    @Test
    void setWhitePlayer() {
        ChessRoyaleParticipant p = new ChessRoyaleParticipant();

        duel.setWhitePlayer(p);

        assertEquals(duel.getWhitePlayer(), p);
    }

    @Test
    void getBlackPlayer() {
        assertEquals(duel.getBlackPlayer(), blackPlayer);
    }

    @Test
    void setBlackPlayer() {
        ChessRoyaleParticipant p = new ChessRoyaleParticipant();

        duel.setBlackPlayer(p);

        assertEquals(duel.getBlackPlayer(), p);
    }

    @Test
    void getResult() {
        assertEquals(duel.getResult(), ChessDuel.ResultType.IN_PROGRESS);
    }

    @Test
    void setResult() {
        duel.setResult(ChessDuel.ResultType.PAT);

        assertEquals(duel.getResult(), ChessDuel.ResultType.PAT);
    }

    @Test
    void testToString() {
        assertNotEquals(duel.toString(), "");
    }
}