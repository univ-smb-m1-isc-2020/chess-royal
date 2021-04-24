package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.util.Date;

@Entity
public class ChessDuel {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private ChessRoyaleParticipant whitePlayer;
    @ManyToOne
    private ChessRoyaleParticipant blackPlayer;

    private boolean whiteVictory;
    private boolean blackVictory;

//    @ManyToOne
//    @JoinColumn(name = "person_id",
//            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
//    )

    public ChessDuel() {
        // keep empty for JPA
    }

    public ChessDuel(String name) {
//        this.name = name;
        this.startDate = new Date();
//        this.participants = new HashMap<Long, ChessRoyaleParticipant>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ChessRoyaleParticipant getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(ChessRoyaleParticipant whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public ChessRoyaleParticipant getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(ChessRoyaleParticipant blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public boolean isWhiteVictory() {
        return whiteVictory;
    }

    public void setWhiteVictory(boolean whiteVictory) {
        this.whiteVictory = whiteVictory;
    }

    public boolean isBlackVictory() {
        return blackVictory;
    }

    public void setBlackVictory(boolean blackVictory) {
        this.blackVictory = blackVictory;
    }
}
