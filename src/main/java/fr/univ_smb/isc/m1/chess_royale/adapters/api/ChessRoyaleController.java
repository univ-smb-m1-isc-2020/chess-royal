package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
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
    public List<String> pippos() {
        return chessRoyaleClientService.users()
                .stream()
                .map(p-> p.getName())
                .collect(toList());
    }
}
