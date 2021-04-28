package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.util.*;

@Entity
public class ChessRoyaleGame {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private String name; //name for the game given by user
    private Date startDate;

    @OneToMany
    private List<ChessRoyaleParticipant> participants = new ArrayList<>();

    public ChessRoyaleGame() {
        // keep empty for JPA
    }

    public ChessRoyaleGame(String name) {
        this.name = name;
        this.startDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<ChessRoyaleParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ChessRoyaleParticipant> participants) {
        this.participants = participants;
    }

    public void addParticipant(ChessRoyaleParticipant chessRoyaleParticipant) {
        this.participants.add(chessRoyaleParticipant);
    }
}
