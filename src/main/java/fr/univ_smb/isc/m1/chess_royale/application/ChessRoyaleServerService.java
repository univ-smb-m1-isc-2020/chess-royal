package fr.univ_smb.isc.m1.chess_royale.application;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChessRoyaleServerService {

    private final ChessRoyaleUserRepository userRepository;
    private final ChessRoyaleGameRepository gameRepository;

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
        var game = gameRepository.findById(gameId);
        if (game.isPresent())
        {
            return game.get().getParticipants();
        }
        else
        {
            return new ArrayList<>();
        }
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
