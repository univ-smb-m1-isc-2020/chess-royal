package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleParticipantRepository;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserRepository;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChessRoyaleClientService {

    private final ChessRoyaleUserRepository userRepository;

    public ChessRoyaleClientService(ChessRoyaleUserRepository repository) {
        this.userRepository = repository;
    }

    public List<ChessRoyaleUser> users() {
        //return List.of(new ChessRoyale("This is a chessroyale user."));
        return userRepository.findAll();
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
