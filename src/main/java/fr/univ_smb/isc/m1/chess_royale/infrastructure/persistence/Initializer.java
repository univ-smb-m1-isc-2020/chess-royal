package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class Initializer {

    private final ChessRoyaleUserRepository repository;

    final private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Initializer(ChessRoyaleUserRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {

        repository.deleteAllInBatch();

        if (repository.findAll().isEmpty()) {
            repository.saveAndFlush(new ChessRoyaleUser("User1", passwordEncoder.encode("none")));
            repository.saveAndFlush(new ChessRoyaleUser("User2", passwordEncoder.encode("none")));
            repository.saveAndFlush(new ChessRoyaleUser("User3", passwordEncoder.encode("none")));
            repository.saveAndFlush(new ChessRoyaleUser("User4", passwordEncoder.encode("none")));
        }
    }

}
