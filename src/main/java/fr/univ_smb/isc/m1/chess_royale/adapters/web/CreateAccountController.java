package fr.univ_smb.isc.m1.chess_royale.adapters.web;

import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleClientService;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.UsernameAlreadyTakenException;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CreateAccountController {

    private final ChessRoyaleClientService chessRoyaleClientService;

    public CreateAccountController(ChessRoyaleClientService chessRoyaleClientService) {
        this.chessRoyaleClientService = chessRoyaleClientService;
    }

    @GetMapping(value = "/create-account")
    public String home(Model model) {
        model.addAllAttributes(chessRoyaleClientService.users());
        return "create-account";
    }

    @GetMapping(value="/create-account/create")
    public String pidUserSubmit(@RequestParam(name = "name") String name,
                                @RequestParam(name = "hash") String hash,
                                @RequestParam(name = "lichessAPIToken") String lichessAPIToken
                                ) {
        try{
            chessRoyaleClientService.createUser(name, hash, lichessAPIToken);
            return "redirect:/create-account";
        }
        catch (UsernameAlreadyTakenException e)
        {
            return "redirect:/error-username-already-taken";
        }
    }

    @PostMapping(value = "/create-account/increment-score", params = {"userId"})
    public String incrementUserScore(HttpServletRequest req) {
        var userId = Long.valueOf(req.getParameter("userId"));
        ChessRoyaleUser userToUpdate = chessRoyaleClientService.getUser(userId);
        chessRoyaleClientService.saveUser(userToUpdate);
        return "redirect:/create-account";
    }
}