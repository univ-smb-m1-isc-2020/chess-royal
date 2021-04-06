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
            repository.saveAndFlush(new ChessRoyaleUser("Chuck Norris can divide by zero."));
            repository.saveAndFlush(new ChessRoyaleUser("Chuck Norris once lost his wedding ring....since then it's been war in Middle Earth"));
            repository.saveAndFlush(new ChessRoyaleUser("In the Beginning there was nothing ... then Chuck Norris roundhouse kicked nothing and told it to get a job"));
            repository.saveAndFlush(new ChessRoyaleUser("When God said, “Let there be light!” Chuck said, “Say Please.”"));
        }
    }

}
