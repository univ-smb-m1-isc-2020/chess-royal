package fr.univ_smb.isc.m1.chess_royale.logic;

import java.util.HashMap;
import java.util.List;

//Class represents an instance of a ChessRoyale game
public class ChessRoyaleGame {

    private enum RoundType {
        ScoreRound, //represents rounds where the goal is to get the maximum score
        LifeRound //represents rounds where the player has a limited amount of life points
    }
    private List<ChessRoyaleParticipant> participants;
    private List<ChessGame> ongoingChessGames;
    private List<ChessGame> passedChessGames;

    private int maximumRounds;
    private HashMap<Integer, RoundType> roundTypes;

    public ChessRoyaleGame(String filepath)
    {
        //TODO: read JSON file to setup game
    }


    private void CullPlayers(float percentToCull)
    {
        HashMap<ChessRoyaleParticipant, Integer> scores = new HashMap<>();

        for (ChessRoyaleParticipant participant : participants)
        {
            scores.put(participant, participant.getScore());
        }
    }
}
