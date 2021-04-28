package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.util.Date;

@Entity
public class ChessDuel {

    private enum ResultType
    {
        IN_PROGRESS,
        BLACK_VICTORY,
        WHITE_VICTORY,
        PAT,
        DRAW
    }

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private ChessRoyaleParticipant whitePlayer;

    @ManyToOne
    private ChessRoyaleParticipant blackPlayer;

    private ResultType result;

    public ChessDuel() {
        // keep empty for JPA
    }

    public ChessDuel(ChessRoyaleParticipant whitePlayer, ChessRoyaleParticipant blackPlayer) {
        this.startDate = new Date();
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.result = ResultType.IN_PROGRESS;
    }

    public boolean isOver()
    {
        return this.result != ResultType.IN_PROGRESS;
    }

    public void checkIfOver()
    {
        //need some request to the Lichess API to change result
        this.result = ResultType.BLACK_VICTORY;
        this.endDate = new Date();
        this.updateScores();
    }

    public void updateScores() {
        switch (this.result)
        {
            case WHITE_VICTORY:
                this.whitePlayer.incrementScore(3);
                break;
            case BLACK_VICTORY:
                this.blackPlayer.incrementScore(3);
                break;
            case PAT:
            case DRAW:
                this.whitePlayer.incrementScore(1);
                this.blackPlayer.incrementScore(1);
                break;
            case IN_PROGRESS:
                //Do nothing
                break;
        }
    }

    @Override
    public String toString() {
        return "ChessDuel{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", whitePlayer=" + whitePlayer +
                ", blackPlayer=" + blackPlayer +
                ", result=" + result +
                '}';
    }
}
