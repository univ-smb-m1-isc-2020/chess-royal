package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class ChessRoyaleGame {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private String name; //username
    private Date startDate;

    @OneToMany
    private Map<Long, ChessRoyaleParticipant> participants; //map of chessRoyaleParticipants based on their id


//    @ManyToOne
//    @JoinColumn(name = "person_id",
//            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
//    )

    public ChessRoyaleGame() {
        // keep empty for JPA
    }

    public ChessRoyaleGame(String name, List<ChessRoyaleParticipant> participants) {
        this.name = name;
        this.startDate = new Date();
        this.participants = new HashMap<Long, ChessRoyaleParticipant>();

        for (ChessRoyaleParticipant p : participants)
        {
            this.participants.put(p.getId(), p);
        }
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
}
