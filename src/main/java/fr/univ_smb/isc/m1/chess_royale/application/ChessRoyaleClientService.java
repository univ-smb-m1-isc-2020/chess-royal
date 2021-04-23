package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChessRoyaleClientService {

    private final ChessRoyaleUserRepository userRepository;
    private final ChessRoyaleGameRepository gameRepository;
    private final ChessRoyaleParticipantRepository participantRepository;

    public ChessRoyaleClientService(ChessRoyaleUserRepository userRepository,
                                    ChessRoyaleGameRepository gameRepository,
                                    ChessRoyaleParticipantRepository participantRepository
    )
    {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.participantRepository = participantRepository;
    }

    public List<ChessRoyaleUser> users()
    {
        return userRepository.findAll();
    }

    public List<ChessRoyaleGame> games()
    {
        return gameRepository.findAll();
    }

    public void deleteUser(Long userId) {
        Optional<ChessRoyaleUser> fact = userRepository.findById(userId);
        fact.ifPresent(userRepository::delete);
    }

    public void createUser(String name, String hash) {
        // FIXME : check if not already present
        userRepository.save(new ChessRoyaleUser(name, hash));
    }

    public ChessRoyaleUser getUser(Long userId)
    {
        return userRepository.getOne(userId);
    }

    public void saveUser(ChessRoyaleUser chessRoyaleUser)
    {
        userRepository.save(chessRoyaleUser);
    }

}
