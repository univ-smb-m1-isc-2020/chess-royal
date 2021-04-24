package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessRoyaleServerService {

    private final ChessRoyaleUserRepository userRepository;
    private final ChessRoyaleGameRepository gameRepository;
    private final ChessRoyaleParticipantRepository participantRepository;

    public ChessRoyaleServerService(ChessRoyaleUserRepository userRepository,
                                    ChessRoyaleGameRepository gameRepository,
                                    ChessRoyaleParticipantRepository participantRepository
                                    )
    {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.participantRepository = participantRepository;
    }

    public List<ChessRoyaleUser> users() {
        return userRepository.findAll();
    }

    public List<ChessRoyaleGame> games()
    {
        return gameRepository.findAll();
    }

    public List<ChessRoyaleParticipant> getParticipants(Long gameId)
    {
        //FIXME: do it by game ID
        //return participantRepository.findById(gameId);
        return participantRepository.findAll();
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
