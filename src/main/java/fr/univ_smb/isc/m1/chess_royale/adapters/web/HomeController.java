package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ChessRoyaleService chessRoyaleService;

    public HomeController(ChessRoyaleService chessRoyaleService) {
        this.chessRoyaleService = chessRoyaleService;
    }

    @GetMapping(value="/")
    public String home(Model model) {
        model.addAttribute("users", chessRoyaleService.users());
        return "home";
    }

}