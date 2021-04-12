package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class Initializer {

    private final ChessRoyaleRepository repository;

    public Initializer(ChessRoyaleRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {

        repository.deleteAllInBatch();

        if (repository.findAll().isEmpty()) {
            repository.saveAndFlush(new ChessRoyaleUser("User 1"));
            repository.saveAndFlush(new ChessRoyaleUser("User 2"));
            repository.saveAndFlush(new ChessRoyaleUser("User 3"));
            repository.saveAndFlush(new ChessRoyaleUser("User 4"));
        }
    }

}
