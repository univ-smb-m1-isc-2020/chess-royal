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

    final private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

        ChessRoyaleUser admin = new ChessRoyaleUser("admin", passwordEncoder.encode("root"), "testToken");
        admin.setRoles("ADMIN");

        ChessRoyaleUser user1 = new ChessRoyaleUser("User1", passwordEncoder.encode("none"), "testToken");
        ChessRoyaleUser user2 = new ChessRoyaleUser("User2", passwordEncoder.encode("none"), "testToken");
        ChessRoyaleUser user3 = new ChessRoyaleUser("User3", passwordEncoder.encode("none"), "testToken");
        ChessRoyaleUser user4 = new ChessRoyaleUser("User4", passwordEncoder.encode("none"), "testToken");

        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAndFlush(user1);
            userRepository.saveAndFlush(user2);
            userRepository.saveAndFlush(user3);
            userRepository.saveAndFlush(user4);
            userRepository.saveAndFlush(admin);
        }

        ChessRoyaleGame game1 = new ChessRoyaleGame("Test Game 1");

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
