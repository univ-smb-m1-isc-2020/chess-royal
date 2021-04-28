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
        assertNotEquals(null, duel.getEndDate());
    }

    void checkIfNotOver()
    {
        duel.setResult(ChessDuel.ResultType.WHITE_VICTORY);
        assertTrue(duel.checkIfOver();
    }

    @Test
    void updateScores() {
        duel.setResult(ChessDuel.ResultType.DRAW);

        whitePlayer.setScore(0);
        blackPlayer.setScore(0);

        duel.updateScores();

        assertEquals(1, whitePlayer.getScore());
        assertEquals(1, blackPlayer.getScore());
    }

    void updateScoreAfterVictory()
    {
        duel.setResult(ChessDuel.ResultType.WHITE_VICTORY);

        whitePlayer.setScore(0);
        blackPlayer.setScore(0);

        duel.updateScores();

        assertEquals(3, whitePlayer.getScore());
        assertEquals(0, blackPlayer.getScore());
    }

    @Test
    void test_Id() {
        duel.setId(1L);
        assertEquals(1, duel.getId());
    }

    @Test
    void getStartDate() {
        assertNotEquals(null, duel.getStartDate());
    }

    @Test
    void setStartDate() {
        Date now = new Date();
        duel.setStartDate(now);

        assertEquals(now, duel.getStartDate());
    }

    @Test
    void testEndDate() {
        Date now = new Date();
        duel.setEndDate(now);

        assertEquals(now, duel.getEndDate());
    }

    @Test
    void getWhitePlayer() {
        assertEquals(whitePlayer, duel.getWhitePlayer());
    }

    @Test
    void setWhitePlayer() {
        ChessRoyaleParticipant p = new ChessRoyaleParticipant();

        duel.setWhitePlayer(p);

        assertEquals(p, duel.getWhitePlayer());
    }

    @Test
    void getBlackPlayer() {
        assertEquals(blackPlayer, duel.getBlackPlayer());
    }

    @Test
    void setBlackPlayer() {
        ChessRoyaleParticipant p = new ChessRoyaleParticipant();

        duel.setBlackPlayer(p);

        assertEquals(p, duel.getBlackPlayer());
    }

    @Test
    void getResult() {
        assertEquals(ChessDuel.ResultType.IN_PROGRESS, duel.getResult());
    }

    @Test
    void setResult() {
        duel.setResult(ChessDuel.ResultType.PAT);

        assertEquals(ChessDuel.ResultType.PAT, duel.getResult());
    }

    @Test
    void testToString() {
        assertNotNull(duel.toString());
    }
}