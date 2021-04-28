package fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
class Initializer {

    private final ChessRoyaleUserRepository userRepository;
    private final ChessRoyaleParticipantRepository participantRepository;
    private final ChessRoyaleGameRepository gameRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Initializer(ChessRoyaleUserRepository userRepository,
                       ChessRoyaleParticipantRepository participantRepository,
                       ChessRoyaleGameRepository gameRepository)
    {
        this.userRepository = userRepository;
        this.participantRepository = participantRepository;
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void initialize() {

        userRepository.deleteAllInBatch();
        gameRepository.deleteAllInBatch();
        participantRepository.deleteAllInBatch();

        var admin = new ChessRoyaleUser("admin", passwordEncoder.encode("chess-royale"), "testToken0");
        admin.setRoles("ADMIN,USER");

        var user1 = new ChessRoyaleUser("User1", passwordEncoder.encode("password1"), "testToken1");
        var user2 = new ChessRoyaleUser("User2", passwordEncoder.encode("password2"), "testToken2");
        var user3 = new ChessRoyaleUser("User3", passwordEncoder.encode("password3"), "testToken3");
        var user4 = new ChessRoyaleUser("User4", passwordEncoder.encode("password4"), "testToken4");

        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAndFlush(user1);
            userRepository.saveAndFlush(user2);
            userRepository.saveAndFlush(user3);
            userRepository.saveAndFlush(user4);
            userRepository.saveAndFlush(admin);
        }

        var game1 = new ChessRoyaleGame("Test Game 1");

        if (gameRepository.findAll().isEmpty())
        {
            gameRepository.saveAndFlush(game1);
        }

        user1.subscribe(game1);
        user2.subscribe(game1);
        user3.subscribe(game1);
        user4.subscribe(game1);
    }

}
