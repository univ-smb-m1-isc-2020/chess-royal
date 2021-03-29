package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ChessRoyaleController {

    private final ChessRoyaleService chessRoyaleService;

    public ChessRoyaleController(ChessRoyaleService chessRoyaleService) {
        this.chessRoyaleService = chessRoyaleService;
    }


    @GetMapping(value="/chess-royale")
    public List<String> pippos() {
        return chessRoyaleService.facts()
                .stream()
                .map(p-> p.getName())
                .collect(toList());
    }

}
