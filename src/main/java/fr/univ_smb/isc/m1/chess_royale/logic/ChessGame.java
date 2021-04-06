package fr.univ_smb.isc.m1.chess_royale.logic;

//Class represents a single instance of a Chess game between 2 participants
public class ChessGame {

    private enum ChessGameIssue{
        WHITE_VICTORY,
        BLACK_VICTORY,
        PAT,
        TIE
    }

    private ChessRoyaleParticipant whitePlayer;
    private ChessRoyaleParticipant blackPlayer;
    private ChessGameIssue gameIssue;

    private int gameId; //Game id on chess API


}
