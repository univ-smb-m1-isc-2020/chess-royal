package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleService;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CreateAccountController {

    private final ChessRoyaleService chessRoyaleService;

    public CreateAccountController(ChessRoyaleService chessRoyaleService) {
        this.chessRoyaleService = chessRoyaleService;
    }

    @GetMapping(value = "/create-account")
    public String home(Model model) {
        model.addAllAttributes(chessRoyaleService.users());
        return "create-account";
    }

    @GetMapping(value="/create-account/create")
    public String pidUserSubmit(@RequestParam(name = "name") String name,
                                @RequestParam(name = "hash") String hash
                                ) {
        //String author = principal.getName();
        chessRoyaleService.create(name, hash);
        return "redirect:/create-account";
    }

    @PostMapping(value = "/create-account/increment-score", params = {"userId"})
    public String incrementUserScore(HttpServletRequest req) {
        Long userId = Long.valueOf(req.getParameter("userId"));
        ChessRoyaleUser userToUpdate = chessRoyaleService.getUser(userId);
        userToUpdate.incrementScore();
        chessRoyaleService.saveUser(userToUpdate);
        return "redirect:/create-account";
    }
}