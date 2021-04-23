package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class Initializer {

    private final ChessRoyaleUserRepository repository;

    public Initializer(ChessRoyaleUserRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {

        repository.deleteAllInBatch();

        if (repository.findAll().isEmpty()) {
            repository.saveAndFlush(new ChessRoyaleUser("User 1", "password", "toto"));
            repository.saveAndFlush(new ChessRoyaleUser("User 2", "password2", "toto2"));
            repository.saveAndFlush(new ChessRoyaleUser("User 3", "password3", "toto3"));
            repository.saveAndFlush(new ChessRoyaleUser("User 4", "password4", "toto4"));
        }
    }

}
