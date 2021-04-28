package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    private final ChessRoyaleClientService chessRoyaleClientService;

    public HomeController(ChessRoyaleClientService chessRoyaleClientService) {
        this.chessRoyaleClientService = chessRoyaleClientService;
    }

    @GetMapping(value="/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("users", chessRoyaleClientService.users());
        model.addAttribute("connectedUserName", principal.getName());
        return "home";
    }


}