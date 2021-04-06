package fr.univ_smb.isc.m1.chess_royale.adapters.api;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    private final ChessRoyaleService chessRoyaleService;

    public AdminController(ChessRoyaleService chessRoyaleService) {
        this.chessRoyaleService = chessRoyaleService;
    }

    @GetMapping(value="/admin")
    public String home(Model model) {
        model.addAttribute("facts", chessRoyaleService.facts());
        return "admin";
    }

}