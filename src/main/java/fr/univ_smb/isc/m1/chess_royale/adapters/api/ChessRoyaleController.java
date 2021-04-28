package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessDuel;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleGame;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleParticipant;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ChessRoyaleController {

    private final ChessRoyaleClientService chessRoyaleClientService;

    public ChessRoyaleController(ChessRoyaleClientService chessRoyaleClientService) {
        this.chessRoyaleClientService = chessRoyaleClientService;
    }

    @GetMapping(value="/list-users")
        public List<String> listUserNames() {
        return chessRoyaleClientService.users()
                .stream()
                .map(ChessRoyaleUser::getUsername)
                .collect(toList());
    }

    @GetMapping(value="/list-games")
        public List<String> listChessRoyaleGames()
    {
        return chessRoyaleClientService.games()
                .stream()
                .map(ChessRoyaleGame::getName)
                .collect(toList());
    }

    @GetMapping(value="/list-participants")
    public List<String> listParticipants()
    {
        return chessRoyaleClientService.participants()
                .stream()
                .map(ChessRoyaleParticipant::getAccountUsername)
                .collect(toList());
    }

    @GetMapping(value="/list-duels")
    public List<String> listDuels()
    {
        return chessRoyaleClientService.duels()
                .stream()
                .map(ChessDuel::getId)
                .map(Object::toString)
                .collect(toList());
    }
}
