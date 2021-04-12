package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleRepository;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChessRoyaleService {

    private final ChessRoyaleRepository repository;

    public ChessRoyaleService(ChessRoyaleRepository repository) {
        this.repository = repository;
    }

    public List<ChessRoyaleUser> users() {
        //return List.of(new ChessRoyale("This is a chessroyale user."));
        return repository.findAll();
    }

    public void delete(Long userId) {
        Optional<ChessRoyaleUser> fact = repository.findById(userId);
        fact.ifPresent(repository::delete);
    }

    public void create(String name) {
        // FIXME : check if not already present
        repository.save(new ChessRoyaleUser(name));
    }

}
