package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleRepository;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessRoyaleService {

    private final ChessRoyaleRepository repository;

    public ChessRoyaleService(ChessRoyaleRepository repository) {
        this.repository = repository;
    }

    public List<ChessRoyale> facts() {
        return List.of(new ChessRoyale("Chuck Norris threw a grenade and killed 50 people, then it exploded."));
        //return repository.findAll();
    }

}
