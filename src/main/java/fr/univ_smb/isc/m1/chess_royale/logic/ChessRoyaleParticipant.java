package fr.univ_smb.isc.m1.chess_royale.logic;

//Class represents a particular player in a particular instance of a ChessRoyale game
public class ChessRoyaleParticipant {
    private int playerid; //player ID in the DB
    private int score;
    private int lifePoints;

    public Integer getScore() {
        return this.score;
    }
}
