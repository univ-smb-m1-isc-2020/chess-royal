package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;


import javax.persistence.*;
import javax.servlet.annotation.MultipartConfig;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class ChessDuel {

    @Id
    @GeneratedValue
    private Long id; //id in the chess royale db
    private Date startDate;
    private Date endDate;

    //@ForeignKey
    //private ChessRoyaleParticipant whitePlayer;
    private Long blackPlayerId;


//    @ManyToOne
//    @JoinColumn(name = "person_id",
//            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
//    )

    public ChessDuel() {
        // keep empty for JPA
    }

    public ChessDuel(String name, List<ChessRoyaleParticipant> participants) {
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
